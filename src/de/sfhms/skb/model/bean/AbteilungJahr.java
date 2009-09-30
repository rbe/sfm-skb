package de.sfhms.skb.model.bean;

import java.util.ArrayList;

public class AbteilungJahr {

    private int jahr;
    private ArrayList<Kostenart> kostenart;
    private ArrayList<Abteilung> abteilung;

    public AbteilungJahr() {
    }

    public ArrayList<Abteilung> getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(ArrayList<Abteilung> val) {
        this.abteilung = val;
    }

    public int getJahr() {
        return jahr;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

    public ArrayList<Kostenart> getKostenart() {
        return kostenart;
    }

    public void setKostenart(ArrayList<Kostenart> val) {
        this.kostenart = val;
    }
}

