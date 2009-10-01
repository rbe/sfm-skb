package de.sfhms.skb.processor.plugin.input;

import de.sfhms.skb.input.DataImportAdapter;
import de.sfhms.skb.input.DataImportFactory;
import de.sfhms.skb.model.MyCell;
import de.sfhms.skb.model.MyDatamodel;
import de.sfhms.skb.model.MyRow;
import de.sfhms.skb.output.MyOutput;
import de.sfhms.skb.processor.plugin.AbstractPlugin;
import de.sfhms.skb.processor.ProcessorException;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author brandes
 */
public class PprInputPlugin1 extends AbstractPlugin {

    @Override
    public MyDatamodel execute() throws ProcessorException {
        MyDatamodel model = null;
        try {
            URL url = new URL(config.getDatasourceByName(config.getActualJob(), "ppr").getUrl());
            File[] tmp = PprHelper.readPpr(url);
            // Load CSV file 1
            model = new MyDatamodel();
            DataImportAdapter csv1 = DataImportFactory.createCsvImportAdapter(tmp[0].toURI().toURL());
            MyDatamodel model1 = csv1.getMyDatamodel(0);
            MyRow[] row1 = model1.findRowByValue(config.getActualJob().getDept().getName());
            if (row1.length > 0) {
                model = new MyDatamodel();
                model.setName("ppr_einstufung");
                for (MyRow myRow : row1) {
                    myRow.getCell(0).setName("Fachrichtung");
                    myRow.getCell(1).setName("Station");
                    myRow.getCell(2).setName("A1_S1");
                    myRow.getCell(3).setName("A1_S2");
                    myRow.getCell(4).setName("A1_S3");
                    myRow.getCell(5).setName("A2_S1");
                    myRow.getCell(6).setName("A2_S2");
                    myRow.getCell(7).setName("A2_S3");
                    myRow.getCell(8).setName("A3_S1");
                    myRow.getCell(9).setName("A3_S2");
                    myRow.getCell(10).setName("A3_S3");
                    myRow.getCell(11).setName("Neugeborene");
                    myRow.getCell(12).setName("Aufnahmen");
                    myRow.getCell(13).setName("Falltage");
                    myRow.getCell(14).setName("ohne_Einstufung");
                    myRow.getCell(15).setName("Urlaub");
                    model.addRow(myRow);
                }
            }
        } catch (MalformedURLException ex) {
            throw new ProcessorException("Cannot load input file", ex);
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
            throw new ProcessorException("Could not persist akvd", ex);
        }
    }
}
