package de.sfhms.skb.processor.plugin;

import de.sfhms.skb.input.DataImportAdapter;
import de.sfhms.skb.input.DataImportFactory;
import de.sfhms.skb.processor.AbstractPlugin;
import de.sfhms.skb.processor.plugin.akvd.GCH;
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
            PluginStrategy ps = null;
            if (config.getActualJob().getName().equals("GCH")) {
                ps = new GCH(this);
            }
            ps.execute();
        } catch (MalformedURLException ex) {
            logger.log(Level.SEVERE, "Could not open Excel file", ex);
        }
    }

    @Override
    public void persist() {
        System.out.println(getVar("AKVD_TEST"));
    }
//    public static void main(String[] args) {
//        AkvdInputPlugin test = new AkvdInputPlugin();
//        test.execute();
//
//    }
}
