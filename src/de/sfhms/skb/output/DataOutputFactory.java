package de.sfhms.skb.output;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DataOutputFactory {

    private static final Map<URL, DataOutputAdapter> cache;

    static {
        cache = new HashMap<URL, DataOutputAdapter>();
    }

    public DataOutputFactory() {
    }

    public synchronized static DataOutputAdapter createExcelOutputAdapterImpl(URL url) {
        DataOutputAdapter a = cache.get(url);
        if (null == a) {
            a = new ExcelDataOutputAdapterImpl();
            a.open(url);
            a.init();
            cache.put(url, a);
        }
        return a;
    }

    public synchronized static DataOutputAdapter createOOoOutputAdapterImpl(URL url) {
        DataOutputAdapter a = cache.get(url);
        if (null == a) {
            a = new OOoDataOutputAdapterImpl();
            a.open(url);
            a.init();
            cache.put(url, a);
        }
        return a;
    }
}

