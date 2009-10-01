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
public class PprInputPlugin1 extends AbstractPlugin {

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
                Logger.getLogger(PprInputPlugin1.class.getName()).log(Level.SEVERE, null, ex);
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
            // Load CSV file 1
            model = new MyDatamodel();
            DataImportAdapter csv1 = DataImportFactory.createCsvImportAdapter(tmp1.toURI().toURL());
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
    }
}
