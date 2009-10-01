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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rbe
 */
public class AkvdInputPlugin extends AbstractPlugin {

    @Override
    public void execute() throws ProcessorException {

        try {
            // Load Excel sheet
            String url = config.getDatasourceByName(config.getActualJob(), "akvd").getUrl();
            DataImportAdapter excel = DataImportFactory.createExcelImportAdapter(new URL(url));
            // Create datamodel
            // Get cell value
            MyRow[] row = excel.getMyDatamodel(0).findRowByValue(config.getActualJob().getDept().getFab());
            if (row.length > 0) {
                System.out.println("Akvd: row#0 cell#1: " + row[0].getCell(1).getValue());
            }
            System.out.println("Akvd: row#0 cell#0: " + excel.getCell(0, 0, 0).getValue());
            // Calculate...
            // Fire plugin for certain department
            fireDepartmentPlugin();
        } catch (MalformedURLException ex) {
            throw new ProcessorException("Could not open Excel file", ex);
        }
    }

    @Override
    public void persist() throws ProcessorException {
        MyDatamodel model = new MyDatamodel();
        model.setName("akvd");
        MyRow r1 = new MyRow();
        MyCell d1 = new MyCell("FAB", "GCH");
        MyCell d2 = new MyCell("PKTVWD", 1.5);
        MyCell d3 = new MyCell("PKTAKVD", 2.5);
        MyCell d4 = new MyCell("FALLVWD", 3.5);
        MyCell d5 = new MyCell("FALLAKVD", 4.5);
        MyCell e1 = new MyCell("FAB", "ACH");
        MyCell e2 = new MyCell("PKTVWD", 6.5);
        MyCell e3 = new MyCell("PKTAKVD", 5.5);
        MyCell e4 = new MyCell("FALLVWD", 7.5);
        MyCell e5 = new MyCell("FALLAKVD", 8.5);
        MyCell c1 = new MyCell("FAB", "UCH");
        MyCell c2 = new MyCell("PKTVWD", 9.5);
        MyCell c3 = new MyCell("PKTAKVD", 10.5);
        MyCell c4 = new MyCell("FALLVWD", 11.5);
        MyCell c5 = new MyCell("FALLAKVD", 12.5);
        r1.addCell(c1);
        r1.addCell(c2);
        r1.addCell(c3);
        r1.addCell(c4);
        r1.addCell(c5);
        model.addRow(r1);
        MyRow r2 = new MyRow();
        r2.addCell(d1);
        r2.addCell(d2);
        r2.addCell(d3);
        r2.addCell(d4);
        r2.addCell(d5);
        model.addRow(r2);
        MyRow r3 = new MyRow();
        r3.addCell(e1);
        r3.addCell(e2);
        r3.addCell(e3);
        r3.addCell(e4);
        r3.addCell(e5);
        model.addRow(r3);
        MyRow r4 = new MyRow();
        MyCell f1 = new MyCell("FAB", "ORT");
        MyCell f2 = new MyCell("PKTVWD", 12);
        MyCell f3 = new MyCell("PKTAKVD", 15.7);
        MyCell f4 = new MyCell("FALLVWD", 18);
        MyCell f5 = new MyCell("FALLAKVD", 22);
        r4.addCell(f1);
        r4.addCell(f2);
        r4.addCell(f3);
        r4.addCell(f4);
        r4.addCell(f5);
        model.addRow(r4);
        try {
            MyOutput.toDatabase(model, new MyCell("Datum", new Date()), true);
        } catch (SQLException ex) {
            Logger.getLogger(AkvdInputPlugin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
