package de.sfhms.skb.processor.plugin.input;

import de.sfhms.skb.input.DataImportAdapter;
import de.sfhms.skb.input.DataImportFactory;
import de.sfhms.skb.model.MyRow;
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
            MyRow[] row = excel.getMyDatamodel(0).findRowByValue(config.getActualJob().getDept().getFab());
            if (row.length > 0) {
                System.out.println("Akvd: row#0 cell#1: " + row[0].getCell(1).getValue());
            }
            System.out.println("Akvd: row#0 cell#0: " + excel.getCell(0, 0, 0).getValue());
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
