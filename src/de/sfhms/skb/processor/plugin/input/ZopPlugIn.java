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
 * @author brandes
 */
public class ZopPlugin extends AbstractPlugin {

    @Override
    public MyDatamodel execute() throws ProcessorException {

        List<MyRow> rows = new ArrayList<MyRow>();
        DataImportAdapter csv;
        try {
            URL url = new URL(config.getDatasourceByName(config.getActualJob(), "zop").getUrl());
            csv = DataImportFactory.createCsvImportAdapter(url);
            MyDatamodel model = csv.getMyDatamodel(0);
            //skip first line and set names
            for (int i = 1; i < (int) model.getRowCount(); i++) {
                MyRow row = model.getRow(i);
                // Check first cell
                MyCell cell0 = row.getCell(2);
                cell0.setValue(convDate(cell0.getValueAsString()));
                //System.out.println(cell0.getValueAsString());
                //Set cell names
                row.getCell(0).setName("Fallnummer");
                row.getCell(1).setName("Fallstatus");
                row.getCell(2).setName("OP_Datum");
                row.getCell(3).setName("OP_ID");
                row.getCell(4).setName("FA_Kurz");
                row.getCell(5).setName("FA_Lang");
                row.getCell(6).setName("SN");
                row.getCell(7).setName("RZ");
                row.getCell(8).setName("KSTNR");
                row.getCell(9).setName("KSTBezeichnung");
                row.getCell(10).setName("ProtID");
                rows.add(row);
            }
        } catch (MalformedURLException ex) {
            throw new ProcessorException("Could not open csv file zop", ex);
        }  
        MyDatamodel model = new MyDatamodel();
        model.setName("zop");
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
            throw new ProcessorException("Could not persist zop", ex);
        }
    }

    private String convDate(String date) {
        String[] parts = date.split("\\.");
        if (parts.length > 1) {
            //System.out.println(String.format("%s-%s-%s", parts[2], parts[1], parts[0]));
            return String.format("%s-%s-%s", parts[2], parts[1], parts[0]);
        } else {
            return "";
        }
    }
}
