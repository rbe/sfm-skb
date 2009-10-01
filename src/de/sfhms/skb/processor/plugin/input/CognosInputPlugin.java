package de.sfhms.skb.processor.plugin.input;

import de.sfhms.skb.input.DataImportAdapter;
import de.sfhms.skb.input.DataImportFactory;
import de.sfhms.skb.model.MyCell;
import de.sfhms.skb.model.MyDatamodel;
import de.sfhms.skb.model.MyRow;
import de.sfhms.skb.output.MyOutput;
import de.sfhms.skb.processor.plugin.AbstractPlugin;
import de.sfhms.skb.processor.ProcessorException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rbe
 */
public class CognosInputPlugin extends AbstractPlugin {

    @Override
    public MyDatamodel execute() throws ProcessorException {
        MyDatamodel model = null;
        try {
            // Load Excel sheet
            String url = config.getDatasourceByName(config.getActualJob(), "cognos").getUrl();
            DataImportAdapter excel = DataImportFactory.createExcelImportAdapter(new URL(url));
            // Create datamodel
            model = excel.getMyDatamodel(0);
            List<MyRow> row = new ArrayList<MyRow>();
            String temp = null;
            for (int i = 9; i < (int) model.getRowCount(); i++) {
                // Check first cell
                MyCell cell0 = model.getRow(i).getCell(0);
                if (null != cell0.getValue()) {
                    temp = cell0.getValueAsString();
                } else {
                    cell0.setValue(temp);
                }
                row.add(model.getRow(i));
            }
//            if (row.length == 1) {
//                model = new MyDatamodel();
//                model.setName("akvd");
//                row[0].getCell(0).setName("FAB");
//                row[0].getCell(1).setName("PKTVWD");
//                row[0].getCell(2).setName("PKTAKVD");
//                row[0].getCell(3).setName("FALLVWD");
//                row[0].getCell(4).setName("FALLAKVD");
//                model.addRow(row[0]);
//            }
            // Calculate...
            // Fire plugin for certain department
            fireDepartmentPlugin();
        } catch (MalformedURLException ex) {
            throw new ProcessorException("Could not open Excel file", ex);
        }
        return model;
    }

    @Override
    public void persist(MyDatamodel model) throws ProcessorException {
        try {
            MyOutput.toDatabase(model, new MyCell("Datum", new Date()), false);
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
            logger.warning(e.toString());
        } catch (SQLException ex) {
            throw new ProcessorException("Could not persist Cognos", ex);
        }
    }
}
