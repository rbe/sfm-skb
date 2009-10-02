package de.sfhms.skb.processor.plugin.output;

import de.sfhms.skb.model.MyCell;
import de.sfhms.skb.model.MyDatamodel;
import de.sfhms.skb.model.MyRow;
import de.sfhms.skb.output.ExcelDataOutputAdapterImpl;
import de.sfhms.skb.output.MyOutput;
import de.sfhms.skb.processor.ProcessorException;
import de.sfhms.skb.processor.plugin.AbstractPlugin;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

/**
 *
 * @author rbe
 */
public class AkvdOutputPlugin extends AbstractPlugin {

    @Override
    public MyDatamodel execute() throws ProcessorException {
        OutputHelper oh = OutputHelper.getInstance();
        MyDatamodel model = new MyDatamodel();
        try {
            Connection conn = MyOutput.openDB();
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT a1.fab, a1.pktvwd, a1.pktakvd, a1.fallvwd, a1.fallakvd" +
                    ", a1.pktvwd - (SELECT a2.pktvwd FROM akvd a2 WHERE a2.fab = a1.fab AND MONTH(a2.datum) = ? AND YEAR(a2.datum) = ?) differenz_vwd" +
                    ", a1.pktakvd - (SELECT a2.pktakvd FROM akvd a2 WHERE a2.fab = a1.fab AND MONTH(a2.datum) = ? AND YEAR(a2.datum) = ?) differenz_akvd" +
                    " FROM akvd a1" +
                    " WHERE MONTH(a1.datum) = ? AND YEAR(a1.datum) = ?");
            //
            Calendar precCal = Calendar.getInstance();
            precCal.setTime(oh.getActualYear());
            int precMonth = precCal.get(Calendar.MONTH + 1);
            int precYear = precCal.get(Calendar.YEAR) - 1;
            Calendar actualCal = Calendar.getInstance();
            //
            actualCal.setTime(oh.getActualYear());
            int actualMonth = actualCal.get(Calendar.MONTH + 1);
            int actualYear = actualCal.get(Calendar.YEAR);
            //
            stmt.setInt(1, precMonth);
            stmt.setInt(2, precYear);
            stmt.setInt(3, precMonth);
            stmt.setInt(4, precYear);
            stmt.setInt(5, actualMonth);
            stmt.setInt(6, actualYear);
            //
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                MyRow row = new MyRow();
                row.addCell(new MyCell("fab", result.getString("fab")));
                row.addCell(new MyCell("pktvwd", result.getDouble("pktvwd")));
                row.addCell(new MyCell("pktakvd", result.getDouble("pktakvd")));
                row.addCell(new MyCell("fallvwd", result.getDouble("fallvwd")));
                row.addCell(new MyCell("fallakvd", result.getDouble("fallakvd")));
                row.addCell(new MyCell("differenz_vwd", result.getDouble("differenz_vwd")));
                row.addCell(new MyCell("differenz_akwd", result.getDouble("differenz_akwd")));
                model.addRow(row);
            }
        } catch (Exception e) {
            throw new ProcessorException("", e);
        }
        return model;
    }

    @Override
    public void persist(MyDatamodel model) throws ProcessorException {
        try {
            ExcelDataOutputAdapterImpl e = new ExcelDataOutputAdapterImpl();
            e.open(new URL("file:///c:/ralf.xls"));
            e.init();
            int rw = 0;
            int cl = 0;
            for (MyRow row : model.getRows()) {
                for (MyCell cell : row.getCells()) {
                    e.setCell(0, rw++, cl++, cell.getValue());
                }
            }
            e.close();
        } catch (MalformedURLException ex) {
            throw new ProcessorException("", ex);
        }
    }
}
