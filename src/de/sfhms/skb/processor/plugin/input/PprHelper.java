package de.sfhms.skb.processor.plugin.input;

import de.sfhms.skb.processor.ProcessorException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rbe
 */
public class PprHelper {

    private PprHelper() {
    }

    public static File[] readPpr(URL url) throws ProcessorException {
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
        return new File[]{tmp1, tmp2};
    }
}
