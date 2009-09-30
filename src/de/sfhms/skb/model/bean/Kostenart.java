package de.sfhms.skb.model.bean;

import java.util.ArrayList; 

public class Kostenart {

    private ArrayList<Kostenstelle> kostenstelle;

    public Kostenart () {
    }

    public ArrayList<Kostenstelle> getKostenstelle () {
        return kostenstelle;
    }

    public void setKostenstelle (ArrayList<Kostenstelle> val) {
        this.kostenstelle = val;
    }

}

