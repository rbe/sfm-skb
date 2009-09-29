package de.sfhms.skb.processor.plugin;

import de.sfhms.skb.input.DataImportAdapter;
import de.sfhms.skb.input.DataImportFactory;
import de.sfhms.skb.processor.AbstractPlugin;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

/**
 *
 * @author brandes
 */
public class PprPlugIn extends AbstractPlugin {

    @Override
    public void execute() {
        try {
            // Load Excel sheet
            DataImportAdapter csv = DataImportFactory.createCsvImportAdapter(new URL("file:///c:/test.csv"));
            // Get cell value
            //System.out.println("" + csv.getCell(0, 0, 0).getValue());
            // Calculate...
            // Set var
        } catch (MalformedURLException ex) {
            logger.log(Level.SEVERE, "Could not open Excel file", ex);
        }
    }

    @Override
    public void persist() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) {
        PprPlugIn test = new PprPlugIn();
        test.execute();
    }
}
