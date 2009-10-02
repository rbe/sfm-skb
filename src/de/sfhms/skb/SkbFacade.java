package de.sfhms.skb;

import de.sfhms.skb.processor.ProcessorException;
import de.sfhms.skb.processor.plugin.PluginExecutor;
import java.sql.SQLException;

public class SkbFacade {

    public SkbFacade() {
    }

    public static void main(String[] args) throws ProcessorException, SQLException {
        SkbConfig config = SkbConfig.getInstance();
        config.setActualJob(config.getJobByName("ACH"));
        PluginExecutor pe = new PluginExecutor();
        pe.fireInputPlugins();
    }
}
