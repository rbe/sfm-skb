package de.sfhms.skb.processor.plugin;

import de.sfhms.skb.processor.*;
import de.sfhms.skb.SkbConfig;
import de.sfhms.skb.jaxb.config.Skb;
import de.sfhms.skb.processor.plugin.dept.DeptPluginStrategy;
import de.sfhms.skb.processor.plugin.input.akvd.GCHDeptImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public abstract class AbstractPlugin {

    protected static final Logger logger;
    protected final SkbConfig config;
    protected final Skb.Job actualJob;
    protected final String actualJobName;
    private final Map<String, Object> map;

    static {
        logger = Logger.getLogger(PluginExecutor.class.getName());
    }

    public AbstractPlugin() {
        map = new HashMap<String, Object>();
        config = SkbConfig.getInstance();
        actualJob = config.getActualJob();
        actualJobName = actualJob.getName();
    }

    public abstract void execute() throws ProcessorException;

    public abstract void persist() throws ProcessorException;

    public void fireDepartmentPlugin() throws ProcessorException {
        DeptPluginStrategy ps = null;
        if (actualJobName.equals("GCH")) {
            ps = new GCHDeptImpl(this);
        }
        ps.execute();
    }

    public Object getVar(String name) {
        return map.get(name);
    }

    public void setVar(String name, Object value) {
        map.put(name, value);
    }
}

