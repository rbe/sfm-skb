package de.sfhms.skb.model.bean;

public class Kostenstelle {

    private int kstnr;
    private String bezeichnung;

    public Kostenstelle() {
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getKstnr() {
        return kstnr;
    }

    public void setKstnr(int kstnr) {
        this.kstnr = kstnr;
    }
}

