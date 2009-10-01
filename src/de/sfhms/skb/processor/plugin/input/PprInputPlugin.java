package de.sfhms.skb.processor.plugin.input;

import de.sfhms.skb.input.DataImportAdapter;
import de.sfhms.skb.input.DataImportFactory;
import de.sfhms.skb.model.MyDatamodel;
import de.sfhms.skb.model.MyRow;
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
    public MyDatamodel execute() throws ProcessorException {
        MyDatamodel model = null;
        try {
            // Load CSV file
            model=new MyDatamodel();
            String url = config.getDatasourceByName(config.getActualJob(), "ppr").getUrl();
            DataImportAdapter csv = DataImportFactory.createCsvImportAdapter(new URL(url));
            // Get cell value
            MyRow[] row = csv.getMyDatamodel(0).findRowByValue(config.getActualJob().getDept().getFab());
            //System.out.println("PPR: row#0 cell#0: "+row[0].getCell(0));
            // Calculate...
            // Set var
            setVar("PPR_TEST", 5.689);
        } catch (MalformedURLException ex) {
            logger.log(Level.SEVERE, "Could not open Excel file", ex);
        }

        return model;
    }

    @Override
    public void persist(MyDatamodel model) throws ProcessorException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
