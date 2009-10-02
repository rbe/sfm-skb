package de.sfhms.skb;

import de.sfhms.skb.processor.ProcessorException;
import de.sfhms.skb.processor.plugin.PluginExecutor;
import de.sfhms.skb.processor.plugin.output.OutputHelper;
import java.sql.SQLException;
import java.util.Date;

public class SkbFacade {

    public SkbFacade() {
    }

    public static void main(String[] args) throws ProcessorException, SQLException {
        SkbConfig config = SkbConfig.getInstance();
        config.setActualJob(config.getJobByName("GCH"));
        PluginExecutor pe = new PluginExecutor();
//        pe.fireInputPlugins();
        OutputHelper.getInstance().setActualYear(new Date());
        pe.fireOutputPlugins();
    }
}
