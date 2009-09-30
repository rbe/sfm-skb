package de.sfhms.skb.model.bean;

import java.util.ArrayList;

public class AbteilungKst {

    private ArrayList<Kostenstelle> kostenstelle;
    private Abteilung abteilung;

    public AbteilungKst() {
    }

    public Abteilung getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(Abteilung val) {
        this.abteilung = val;
    }

    public ArrayList<Kostenstelle> getKostenstelle() {
        return kostenstelle;
    }

    public void setKostenstelle(ArrayList<Kostenstelle> val) {
        this.kostenstelle = val;
    }
}

