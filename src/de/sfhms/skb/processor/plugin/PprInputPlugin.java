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
public class PprInputPlugin extends AbstractPlugin {

    @Override
    public void execute() {
        try {
            // Load CSV file
            String url = config.getDataSourceByName(config.getActualJob(), "ppr").getUrl();
            DataImportAdapter csv = DataImportFactory.createCsvImportAdapter(new URL(url));
            // Get cell value
            //System.out.println("" + csv.getCell(0, 0, 0).getValue());
            // Calculate...
            // Set var
            setVar("PPR_TEST", 5.689);
        } catch (MalformedURLException ex) {
            logger.log(Level.SEVERE, "Could not open Excel file", ex);
        }
    }

    @Override
    public void persist() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
