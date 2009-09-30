package de.sfhms.skb.processor.plugin.akvd;

import de.sfhms.skb.processor.AbstractPlugin;
import de.sfhms.skb.processor.plugin.PluginStrategy;

/**
 *
 * @author brandes
 */
public class GCH implements PluginStrategy {

    private AbstractPlugin plugin;

    public GCH(AbstractPlugin plugin) {
        this.plugin = plugin;
    }

    public void execute() {
        plugin.setVar("AKVD_TEST", 1.053);
    }
}
