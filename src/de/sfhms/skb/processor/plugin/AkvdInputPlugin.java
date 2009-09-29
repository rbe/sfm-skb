package de.sfhms.skb.processor.plugin;

import de.sfhms.skb.input.DataImportAdapter;
import de.sfhms.skb.input.DataImportFactory;
import de.sfhms.skb.processor.AbstractPlugin;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rbe
 */
public class AkvdInputPlugin extends AbstractPlugin {

    @Override
    public void execute() {
        try {
            // Load Excel sheet
            DataImportAdapter excel = DataImportFactory.createExcelImportAdapter(new URL("file://c:/test.xls"));
            // Get cell value
            System.out.println("" + excel.getCell(0, 0, 0).getValue());
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
}
