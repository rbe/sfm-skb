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
public class PprInputPlugin2 extends AbstractPlugin {

    @Override
    public MyDatamodel execute() throws ProcessorException {
        MyDatamodel model = null;
        try {
            URL url = new URL(config.getDatasourceByName(config.getActualJob(), "ppr").getUrl());
            File[] tmp = PprHelper.readPpr(url);
            // Load CSV file 2
            DataImportAdapter csv2 = DataImportFactory.createCsvImportAdapter(tmp[1].toURI().toURL());
            MyDatamodel model2 = csv2.getMyDatamodel(0);
            MyRow[] row2 = model2.findRowByValue(config.getActualJob().getDept().getName());
            if (row2.length > 0) {
                model = new MyDatamodel();
                model.setName("ppr_wert");
                for (MyRow myRow : row2) {
                    myRow.getCell(0).setName("Fachrichtung");
                    myRow.getCell(1).setName("Station");
                    myRow.getCell(2).setName("Fallwert");
                    myRow.getCell(3).setName("Grundwert");
                    myRow.getCell(4).setName("Minuten");
                    myRow.getCell(5).setName("Tage");
                    myRow.getCell(6).setName("Neugeborene");
                    myRow.getCell(7).setName("Mittelwert");
                    myRow.getCell(8).setName("Summe");
                    myRow.getCell(9).setName("Summe_mit_Ausgleich");
                    myRow.removeCell(10);
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
