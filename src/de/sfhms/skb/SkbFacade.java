package de.sfhms.skb;

import de.sfhms.skb.processor.PluginExecutor;
import de.sfhms.skb.processor.ProcessorException;

public class SkbFacade {

    public SkbFacade() {
    }

    public static void main(String[] args) throws ProcessorException {
        SkbConfig config = SkbConfig.getInstance();
        config.setActualJob(config.getJobByName("GCH"));
        PluginExecutor pe = new PluginExecutor();
        pe.fireInputPlugins();
    }
}

