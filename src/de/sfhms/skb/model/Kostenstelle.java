package de.sfhms.skb.model;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.20D2781C-5A62-0CB3-656E-50BB6A312252]
// </editor-fold> 
public class Kostenstelle {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9D031618-39F5-EB2C-C94F-C9A6FDAB4CC8]
    // </editor-fold> 
    private int kstnr;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EF0E9B07-D0DC-1965-B23C-F90A44CBADC7]
    // </editor-fold> 
    private String bezeichnung;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9323C2E9-9765-9267-8671-1E791762C6A0]
    // </editor-fold> 
    public Kostenstelle () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C069F976-12C5-7CB3-7FB2-23664E34292E]
    // </editor-fold> 
    public String getBezeichnung () {
        return bezeichnung;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.BF582CE7-5FFB-C9B2-0AB5-1E4BF72D8507]
    // </editor-fold> 
    public void setBezeichnung (String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.24838725-EA5B-E9A4-30AE-C299B6F8374C]
    // </editor-fold> 
    public int getKstnr () {
        return kstnr;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.4633F9CF-6B42-BFE4-CA75-A3EF94DD3D13]
    // </editor-fold> 
    public void setKstnr (int kstnr) {
        this.kstnr = kstnr;
    }

}

