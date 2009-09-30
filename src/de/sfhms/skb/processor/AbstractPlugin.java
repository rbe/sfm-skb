package de.sfhms.skb.processor;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public abstract class AbstractPlugin {

    protected static final Logger logger;
    protected final String jobName;
    private final Map<String, Object> map;

    static {
        logger = Logger.getLogger(PluginExecutor.class.getName());
    }

    public AbstractPlugin(String jobName) {
        this.jobName = jobName;
        map = new HashMap<String, Object>();
    }

    public abstract void execute();

    public abstract void persist();

    public Object getVar(String name) {
        return map.get(name);
    }

    protected void setVar(String name, Object value) {
        map.put(name, value);
    }
}

