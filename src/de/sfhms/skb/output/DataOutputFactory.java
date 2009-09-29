package de.sfhms.skb.output;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.1C479E19-AC30-99F9-AF18-6A4A9BD3382A]
// </editor-fold> 
public class DataOutputFactory {


    private static final Map<URL,DataOutputAdapter>cache;

    static {
        cache = new HashMap<URL,DataOutputAdapter>();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.94EAE46B-F518-7C8B-F7F9-3B1CF716E6EF]
    // </editor-fold> 
    public DataOutputFactory () {
    }


    public synchronized static DataOutputAdapter SqlOutputAdapterImpl(URL url){
        DataOutputAdapter a = cache.get(url);
        if(null == a){
            a = new SqlOutputAdapterImpl();
            a.open(url);
            cache.put(url, a);
        }

        return a;
    }


    public synchronized static DataOutputAdapter OOoOutputAdapterImpl(URL url){
        DataOutputAdapter a = cache.get(url);
        if(null == a){
            a = new OOoOutputAdapterImpl();
            a.open(url);
            cache.put(url, a);
        }

        return a;
    }

    
}

