package de.sfhms.skb.processor.plugin;

import de.sfhms.skb.input.DataImportAdapter;
import de.sfhms.skb.input.DataImportFactory;
import de.sfhms.skb.processor.AbstractPlugin;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

/**
 *
 * @author rbe
 */
public class AkvdInputPlugin extends AbstractPlugin {

    @Override
    public void execute() {
        try {
            // Load Excel sheet
            String url = config.getDataSourceByName(config.getActualJob(), "akvd").getUrl();
            DataImportAdapter excel = DataImportFactory.createExcelImportAdapter(new URL(url));
            // Get cell value
            System.out.println("" + excel.getCell(0, 0, 0).getValue());
            // Calculate...
            // Set var
            setVar("AKVD_TEST", 1.053);
        } catch (MalformedURLException ex) {
            logger.log(Level.SEVERE, "Could not open Excel file", ex);
        }
    }

    @Override
    public void persist() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
//    public static void main(String[] args) {
//        AkvdInputPlugin test = new AkvdInputPlugin();
//        test.execute();
//
//    }
}
