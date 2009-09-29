package de.sfhms.skb.processor;

import java.util.HashMap;
import java.util.Map;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.B3DDB1F4-44EA-B809-82FF-DB863B05126B]
// </editor-fold> 
public abstract class AbstractPlugin {

    Map<String, Object> map;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.351814F1-805D-49D7-42F5-6EAC2D6F04E6]
    // </editor-fold> 
    public AbstractPlugin() {
        map = new HashMap<String, Object>();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4F77962B-18A7-C412-3803-161F2DB22279]
    // </editor-fold> 
    public abstract void execute();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AA4F804B-9AC9-370A-4053-32CB114D1538]
    // </editor-fold> 
    public Object getVar(String name) {
        return map.get(name);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AAEA5793-96C3-0675-A960-EA21355E530A]
    // </editor-fold> 
    private void setVar(String name, Object value) {
        map.put(name, value);


    }
}

