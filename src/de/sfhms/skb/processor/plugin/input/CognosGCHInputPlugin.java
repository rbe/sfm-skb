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
public class CognosGCHInputPlugin extends AbstractPlugin {

    @Override
    public MyDatamodel execute() throws ProcessorException {
        List<MyRow> rows = new ArrayList<MyRow>();
        try {
            // Load Excel sheet
            String url = config.getDatasourceByName(config.getActualJob(), "cognos").getUrl();
            DataImportAdapter excel = DataImportFactory.createExcelImportAdapter(new URL(url));
            // Create datamodel
            MyDatamodel model = excel.getMyDatamodel(0);
            String temp = null;
            // Skip first 9 rows
            for (int i = 9; i < (int) model.getRowCount(); i++) {
                MyRow row = model.getRow(i);
                // Check first cell
                MyCell cell0 = row.getCell(0);
                if (null != cell0.getValue()) {
                    temp = cell0.getValueAsString();
                } else {
                    cell0.setValue(temp);
                }
                //Set cell names
                MyCell kostenart = row.getCell(0); //.setName("Kostenart");
                MyCell bezeichnung = row.getCell(1); // .setName("Bezeichnung");
                MyCell kumGCH = row.getCell(2); //.setName("kumGCH");
                MyCell kumPflegeBereich = row.getCell(3); //.setName("kumPflegeBereich");
                MyCell kumDSA = row.getCell(4); //.setName("kumDSA");
                MyCell kumOP = row.getCell(5); //.setName("kumOP");
                MyCell kumOP6 = row.getCell(6); //.setName("kumOP6");
                MyCell kumDSAZOP = row.getCell(7); //.setName("kumDSAZOP");
                MyCell MonatGCH = row.getCell(8); //.setName("MonatGCH");
                MyCell MonatPflegeBereich = row.getCell(9); //.setName("MonatPflegeBereich");
                MyCell MonatDSA = row.getCell(10); //.setName("MonatDSA");
                MyCell MonatOP = row.getCell(11); //.setName("MonatOP");
                MyCell MonatOP6 = row.getCell(12); //.setName("MonatOP6");
                MyCell MonatDSAZOP = row.getCell(13); //.setName("MonatDSAZOP");
                //
                MyRow row1 = new MyRow();
                row1.addCell(new MyCell("fab", "GCH"));
                row1.addCell(new MyCell("kostenart", kostenart.getValue()));
                row1.addCell(new MyCell("bezeichnung", bezeichnung.getValue()));
                row1.addCell(new MyCell("kumJahr", row.getCell(2).getValueAsDouble() + row.getCell(3).getValueAsDouble() + row.getCell(4).getValueAsDouble() + row.getCell(5).getValueAsDouble() + row.getCell(6).getValueAsDouble() + row.getCell(7).getValueAsDouble()));
                row1.addCell(new MyCell("Monat", row.getCell(8).getValueAsDouble() + row.getCell(9).getValueAsDouble() + row.getCell(10).getValueAsDouble() + row.getCell(11).getValueAsDouble() + row.getCell(12).getValueAsDouble() + row.getCell(13).getValueAsDouble()));
                rows.add(row1);
            }
        } catch (MalformedURLException ex) {
            throw new ProcessorException("Could not open Excel file", ex);
        }
        MyDatamodel model = new MyDatamodel();
        model.setName("cognos");
        model.addRows(rows);
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
