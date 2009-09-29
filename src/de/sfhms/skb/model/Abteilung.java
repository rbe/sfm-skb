package de.sfhms.skb.model;

import java.util.ArrayList; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.356730FE-268A-2AB3-24D5-8FB2F0C371B6]
// </editor-fold> 
public class Abteilung {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EC81A190-1DAD-2281-E991-A13A97514FA2]
    // </editor-fold> 
    private ArrayList<AbteilungJahr> abteilungJahr;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2A81C9E7-3BC9-8872-8276-773D20E07DB7]
    // </editor-fold> 
    public Abteilung () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.84FD3CA9-6C89-9DD7-D72E-8F126050293F]
    // </editor-fold> 
    public ArrayList<AbteilungJahr> getAbteilungJahr () {
        return abteilungJahr;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.45D5B1D5-34AC-DF4A-8B04-FDA50F8702EF]
    // </editor-fold> 
    public void setAbteilungJahr (ArrayList<AbteilungJahr> val) {
        this.abteilungJahr = val;
    }

}

