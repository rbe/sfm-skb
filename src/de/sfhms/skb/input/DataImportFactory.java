package de.sfhms.skb.input;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

// #[regen=yes,id=DCE.9C762A30-1D3C-3F85-B0E8-1CDD9F43AF75]
// </editor-fold> 
public class DataImportFactory {

    private static final Map<URL, DataImportAdapter> cache;

    static {
        cache = new HashMap<URL, DataImportAdapter>();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7CEB536A-D2F0-8C76-B438-B9B8716CC115]
    // </editor-fold> 
    private DataImportFactory() {
    }

//    // Initalization-on-demand-holder Idiom
//    private static class Holder {
//        private static final DataImportFactory INSTANCE = new DataImportFactory();
//    }
//    public static DataImportFactory getInstance() {
//        return Holder.INSTANCE;
//    }
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.57752219-D5C2-3585-4CDE-E8664BBAB8D6]
    // </editor-fold> 
    public synchronized static DataImportAdapter createCsvImportAdapter(URL url) {
        DataImportAdapter a = cache.get(url);
        if (null == a) {
            a = new CsvImportAdapterImpl();
            a.open(url);
            cache.put(url, a);
        }
        return a;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CFC47AB2-D20C-15AF-EC45-622737E4B5FE]
    // </editor-fold> 
    public synchronized static DataImportAdapter createExcelImportAdapter(URL url) {
        DataImportAdapter a = cache.get(url);
        if (null == a) {
            a = new ExcelImportAdapterImpl();
            a.open(url);
            cache.put(url, a);
        }
        return a;
    }
}

