package de.sfhms.skb.processor.plugin.input.akvd;

import de.sfhms.skb.processor.plugin.AbstractPlugin;
import de.sfhms.skb.processor.ProcessorException;
import de.sfhms.skb.processor.plugin.dept.DeptPluginStrategy;

/**
 *
 * @author brandes
 */
public class GCHDeptImpl implements DeptPluginStrategy {

    private AbstractPlugin plugin;

    public GCHDeptImpl(AbstractPlugin plugin) {
        this.plugin = plugin;
    }

    public void execute() throws ProcessorException {
        plugin.setVar("AKVD_TEST", 1.053);
    }
}
