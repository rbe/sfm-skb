package de.sfhms.skb.processor.plugin;

import de.sfhms.skb.SkbConfig;
import de.sfhms.skb.model.MyDatamodel;
import de.sfhms.skb.processor.ProcessorException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public abstract class AbstractPlugin {

    protected static final Logger logger;
    protected final SkbConfig config;
    private final Map<String, Object> map;

    static {
        logger = Logger.getLogger(PluginExecutor.class.getName());
    }

    public AbstractPlugin() {
        map = new HashMap<String, Object>();
        config = SkbConfig.getInstance();
    }

    public abstract MyDatamodel execute() throws ProcessorException;

    public abstract void persist(MyDatamodel model) throws ProcessorException;

    public Object getVar(String name) {
        return map.get(name);
    }

    public void setVar(String name, Object value) {
        map.put(name, value);
    }
}

