package de.sfhms.skb.input;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DataImportFactory {

    private static final Map<URL, DataImportAdapter> cache;

    static {
        cache = new HashMap<URL, DataImportAdapter>();
    }

    private DataImportFactory() {
    }

    public synchronized static DataImportAdapter createCsvImportAdapter(URL url) {
        DataImportAdapter a = cache.get(url);
        if (null == a) {
            a = new CsvDataImportAdapterImpl();
            a.open(url);
            a.init();
            cache.put(url, a);
        }
        return a;
    }

    public synchronized static DataImportAdapter createExcelImportAdapter(URL url) {
        DataImportAdapter a = cache.get(url);
        if (null == a) {
            a = new ExcelDataImportAdapterImpl();
            a.open(url);
            a.init();
            cache.put(url, a);
        }
        return a;
    }
}
