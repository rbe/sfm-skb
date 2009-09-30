package de.sfhms.skb.processor.plugin.dept;

import de.sfhms.skb.processor.ProcessorException;

/**
 *
 * @author brandes
 */
public interface DeptPluginStrategy {

    void execute() throws ProcessorException;
}
