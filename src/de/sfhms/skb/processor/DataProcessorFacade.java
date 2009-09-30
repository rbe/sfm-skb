package de.sfhms.skb.processor;

import de.sfhms.skb.processor.plugin.PluginExecutor;

public class DataProcessorFacade {

    private PluginExecutor pluginExecutor;

    public DataProcessorFacade() {
    }

    public void firePlugins() {
    }

    public void setConfiguration() {
    }

    public PluginExecutor getPluginExecutor() {
        return pluginExecutor;
    }

    public void setPluginExecutor(PluginExecutor val) {
        this.pluginExecutor = val;
    }
}

