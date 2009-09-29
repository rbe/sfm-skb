package de.sfhms.skb.model;

import java.util.ArrayList; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.851C19F6-D8EE-32DB-5345-5310473DA697]
// </editor-fold> 
public class Kostenart {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.61DCD44E-4E43-6A2E-0E9F-2CF89EDEA023]
    // </editor-fold> 
    private ArrayList<Kostenstelle> kostenstelle;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.75505577-D923-34F9-525F-1847B6D69C2B]
    // </editor-fold> 
    public Kostenart () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.BBC804E6-F777-A997-5D6D-02AF6CDB3333]
    // </editor-fold> 
    public ArrayList<Kostenstelle> getKostenstelle () {
        return kostenstelle;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.41C4A020-C39B-6B36-73DE-30797BF2C5EA]
    // </editor-fold> 
    public void setKostenstelle (ArrayList<Kostenstelle> val) {
        this.kostenstelle = val;
    }

}

