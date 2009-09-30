package de.sfhms.skb.model.bean;

import java.util.ArrayList;

public class Abteilung {

    private ArrayList<AbteilungJahr> abteilungJahr;

    public Abteilung() {
    }

    public ArrayList<AbteilungJahr> getAbteilungJahr() {
        return abteilungJahr;
    }

    public void setAbteilungJahr(ArrayList<AbteilungJahr> val) {
        this.abteilungJahr = val;
    }
}

