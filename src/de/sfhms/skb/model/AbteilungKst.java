package de.sfhms.skb.model;

import java.util.ArrayList; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.95EACC86-EB6D-1E35-DB58-539119D625D2]
// </editor-fold> 
public class AbteilungKst {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1679881F-5FC1-AF7C-3E83-420296AE4B3A]
    // </editor-fold> 
    private ArrayList<Kostenstelle> kostenstelle;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.62EC206F-B208-18E8-AFB9-6312129DFB42]
    // </editor-fold> 
    private Abteilung abteilung;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.89033E80-B54E-DCC3-97F5-6746580BC4B5]
    // </editor-fold> 
    public AbteilungKst () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.AF5942A7-3360-E34E-4CB0-61D2BEF6DA5B]
    // </editor-fold> 
    public Abteilung getAbteilung () {
        return abteilung;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.788CFFDB-61EB-AA4D-1D08-B41AA88E1597]
    // </editor-fold> 
    public void setAbteilung (Abteilung val) {
        this.abteilung = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.BCE658BE-3FC5-9D90-000C-2D02E55A87E2]
    // </editor-fold> 
    public ArrayList<Kostenstelle> getKostenstelle () {
        return kostenstelle;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.390CA637-052B-9874-A24B-9587361030A4]
    // </editor-fold> 
    public void setKostenstelle (ArrayList<Kostenstelle> val) {
        this.kostenstelle = val;
    }

}

