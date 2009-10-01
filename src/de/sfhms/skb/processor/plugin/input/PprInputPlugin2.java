package de.sfhms.skb.processor.plugin.input;

import de.sfhms.skb.input.DataImportAdapter;
import de.sfhms.skb.input.DataImportFactory;
import de.sfhms.skb.model.MyDatamodel;
import de.sfhms.skb.model.MyRow;
import de.sfhms.skb.processor.plugin.AbstractPlugin;
import de.sfhms.skb.processor.ProcessorException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

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

            // Read "amazing AGFA CSV format" and split into 2 files
            File tmp1 = null;
            File tmp2 = null;
            BufferedReader reader = null;
            BufferedWriter writer = null;
            try {
                tmp1 = File.createTempFile("skb_ppr1_", ".csv");
                tmp1.deleteOnExit();
                tmp2 = File.createTempFile("skb_ppr2_", ".csv");
                tmp2.deleteOnExit();
                // Skip 3 lines, read/write everything, after blank line, read/write everything
                reader = new BufferedReader(new FileReader(new File(url.toURI())));
                writer = new BufferedWriter(new FileWriter(tmp1));
                String s = null;
                for (int i = 0; i < 5; i++) {
                    reader.readLine();
                }
                while (null != (s = reader.readLine())) {
                    if (s.length() == 0) {
                        writer.close();
                        writer = new BufferedWriter(new FileWriter(tmp2));
                    } else {
                        writer.write(s + "\r\n");
                    }
                }
            } catch (URISyntaxException ex) {
                Logger.getLogger(PprInputPlugin2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                throw new ProcessorException("Cannot split input file", ex);
            } finally {
                if (null != reader) {
                    try {
                        reader.close();
                    } catch (IOException ex) {
                    }
                }
                if (null != writer) {
                    try {
                        writer.close();
                    } catch (IOException ex) {
                    }
                }
            }
            // Load CSV file 2
            DataImportAdapter csv2 = DataImportFactory.createCsvImportAdapter(tmp2.toURI().toURL());
            MyDatamodel model2 = csv2.getMyDatamodel(0);
            MyRow[] row2 = model2.findRowByValue(config.getActualJob().getDept().getName());
            if (row2.length > 0) {
                model = new MyDatamodel();
                model.setName("ppr_einstufung");
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
    }
}
