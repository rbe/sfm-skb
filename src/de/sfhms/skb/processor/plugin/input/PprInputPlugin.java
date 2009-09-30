package de.sfhms.skb.processor.plugin.input;

import de.sfhms.skb.input.DataImportAdapter;
import de.sfhms.skb.input.DataImportFactory;
import de.sfhms.skb.processor.plugin.AbstractPlugin;
import de.sfhms.skb.processor.ProcessorException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

/**
 *
 * @author brandes
 */
public class PprInputPlugin extends AbstractPlugin {

    @Override
    public void execute() throws ProcessorException {
        try {
            // Load CSV file
            String url = config.getDatasourceByName(config.getActualJob(), "ppr").getUrl();
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
    public void persist() throws ProcessorException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
