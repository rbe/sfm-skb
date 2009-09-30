package de.sfhms.skb.model;

import java.util.ArrayList; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.47188303-C527-163E-E95A-31A891538247]
// </editor-fold> 
public class AbteilungJahr {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A0D5EAAA-487F-72AE-AEAF-3779E01476AD]
    // </editor-fold> 
    private int jahr;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.88C2D57A-593D-65E2-D500-B9003A0BC40B]
    // </editor-fold> 
    private ArrayList<Kostenart> kostenart;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.48008DBF-102C-4967-4EA0-92BD956A0871]
    // </editor-fold> 
    private ArrayList<Abteilung> abteilung;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A546EA55-717D-99DB-A7E3-8DC23CB0DB4A]
    // </editor-fold> 
    public AbteilungJahr () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6D6E21F3-BD98-11A8-37DC-F2D5B60E09A1]
    // </editor-fold> 
    public ArrayList<Abteilung> getAbteilung () {
        return abteilung;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1E77D3F0-F939-F2FE-4621-A9FB8353AFA2]
    // </editor-fold> 
    public void setAbteilung (ArrayList<Abteilung> val) {
        this.abteilung = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.7FEEC302-62E6-BBFD-9BB3-D285B92714E0]
    // </editor-fold> 
    public int getJahr () {
        return jahr;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.43F99DB3-E5BC-0128-C288-CD26A8CCB9A8]
    // </editor-fold> 
    public void setJahr (int jahr) {
        this.jahr = jahr;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3F688BAC-1D15-30AD-DC9F-2445766EA108]
    // </editor-fold> 
    public ArrayList<Kostenart> getKostenart () {
        return kostenart;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.0C9F9343-6CBF-D758-4EA9-BD1C8DC9C048]
    // </editor-fold> 
    public void setKostenart (ArrayList<Kostenart> val) {
        this.kostenart = val;
    }

}
