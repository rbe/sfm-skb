package de.sfhms.skb.processor.plugin.input;

import de.sfhms.skb.input.DataImportAdapter;
import de.sfhms.skb.input.DataImportFactory;
import de.sfhms.skb.processor.plugin.AbstractPlugin;
import de.sfhms.skb.processor.ProcessorException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author rbe
 */
public class AkvdInputPlugin extends AbstractPlugin {

    @Override
    public void execute() throws ProcessorException {
        try {
            // Load Excel sheet
            String url = config.getDatasourceByName(config.getActualJob(), "akvd").getUrl();
            DataImportAdapter excel = DataImportFactory.createExcelImportAdapter(new URL(url));
            // Create datamodel
            // Get cell value
            System.out.println("" + excel.getCell(0, 0, 0).getValue());
            // Calculate...
            // Fire plugin for certain department
            fireDepartmentPlugin();
        } catch (MalformedURLException ex) {
            throw new ProcessorException("Could not open Excel file", ex);
        }
    }

    @Override
    public void persist() throws ProcessorException {
        System.out.println(getVar("AKVD_TEST"));
    }
}
