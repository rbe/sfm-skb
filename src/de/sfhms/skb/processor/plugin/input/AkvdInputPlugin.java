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
import java.util.Date;

/**
 *
 * @author rbe
 */
public class AkvdInputPlugin extends AbstractPlugin {

    @Override
    public MyDatamodel execute() throws ProcessorException {
        MyDatamodel model = null;
        try {
            // Load Excel sheet
            String url = config.getDatasourceByName(config.getActualJob(), "akvd").getUrl();
            DataImportAdapter excel = DataImportFactory.createExcelImportAdapter(new URL(url));
            // Create datamodel
            // Get cell value
            String fab = config.getActualJob().getDept().getFab();
            model = excel.getMyDatamodel(0);
            MyRow[] row = model.findRowByValue(fab);
            if (row.length == 1) {
                model = new MyDatamodel();
                model.setName("akvd");
                row[0].getCell(0).setName("FAB");
                row[0].getCell(1).setName("PKTVWD");
                row[0].getCell(2).setName("PKTAKVD");
                row[0].getCell(3).setName("FALLVWD");
                row[0].getCell(4).setName("FALLAKVD");
                model.addRow(row[0]);
            }
            // Calculate...
            // Fire plugin for certain department
            fireDeptPlugins();
        } catch (MalformedURLException ex) {
            throw new ProcessorException("Could not open Excel file", ex);
        }
        return model;
    }

    @Override
    public void persist(MyDatamodel model) throws ProcessorException {
        try {
            MyOutput.toDatabase(model, new MyCell("Datum", new Date()), false);
        }catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
            logger.warning(e.toString());
        } catch (SQLException ex) {
            throw new ProcessorException("Could not persist akvd", ex);
        }
    }
}