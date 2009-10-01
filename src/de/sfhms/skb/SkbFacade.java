package de.sfhms.skb;

import de.sfhms.skb.processor.ProcessorException;
import de.sfhms.skb.processor.plugin.PluginExecutor;
import java.sql.SQLException;

public class SkbFacade {

    public SkbFacade() {
    }

    public static void main(String[] args) throws ProcessorException, SQLException {
        SkbConfig config = SkbConfig.getInstance();
        config.setActualJob(config.getJobByName("GCH"));
        System.out.println(config.getActualJob().getName());
        System.out.println("ds´   "+config.getDatasourceByName(config.getActualJob(), "mysql").getUrl());
        PluginExecutor pe = new PluginExecutor();
        pe.fireInputPlugins();

    }
}

