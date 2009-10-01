package de.sfhms.skb.processor.plugin;

import de.sfhms.skb.SkbConfig;
import de.sfhms.skb.jaxb.config.Skb;
import de.sfhms.skb.model.MyDatamodel;
import de.sfhms.skb.processor.ProcessorException;
import java.util.List;
import java.util.logging.Logger;

public class PluginExecutor {

    private static final Logger logger;
    private SkbConfig config;

    static {
        logger = Logger.getLogger(PluginExecutor.class.getName());
    }

    public PluginExecutor() {
        config = SkbConfig.getInstance();
    }

    public void fireInputPlugins() throws ProcessorException {
        Skb.Job actualJob = config.getActualJob();
        List<Skb.Job.Input.Plugin> plugin = actualJob.getInput().getPlugin();
        for (Skb.Job.Input.Plugin p : plugin) {
            try {
                Class clazz = Class.forName(p.getClazz());
                AbstractPlugin ap = (AbstractPlugin) clazz.newInstance();
                MyDatamodel model = ap.execute();
                ap.fireDeptPlugins();
                ap.persist(model);
            } catch (Exception e) {
                throw new ProcessorException("Could not execute plugins " + p.getClazz() + " for input job " + actualJob.getName(), e);
            }
        }
    }

    public void fireOutputPlugins() throws ProcessorException {
        Skb.Job actualJob = config.getActualJob();
        List<Skb.Job.Output.Plugin> plugin = actualJob.getOutput().getPlugin();
        for (Skb.Job.Output.Plugin p : plugin) {
            try {
                Class clazz = Class.forName(p.getClazz());
                AbstractPlugin ap = (AbstractPlugin) clazz.newInstance();
                MyDatamodel model = ap.execute();
                ap.fireDeptPlugins();
                ap.persist(model);
            } catch (Exception e) {
                throw new ProcessorException("Could not execute plugins for output job " + actualJob.getName(), e);
            }
        }
    }
}

