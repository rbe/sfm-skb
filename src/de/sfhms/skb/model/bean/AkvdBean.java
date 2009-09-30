package de.sfhms.skb.model.bean;

/**
 *
 * @author rbe
 */
public class AkvdBean {

    private String fab;
    private double punkteNachVwd;
    private double punkteNachAkvd;
    private double fallzahlNachVwd;
    private double fallZahlNachAkv;

    public String getFab() {
        return fab;
    }

    public void setFab(String fab) {
        this.fab = fab;
    }

    public double getFallZahlNachAkv() {
        return fallZahlNachAkv;
    }

    public void setFallZahlNachAkv(double fallZahlNachAkv) {
        this.fallZahlNachAkv = fallZahlNachAkv;
    }

    public double getFallzahlNachVwd() {
        return fallzahlNachVwd;
    }

    public void setFallzahlNachVwd(double fallzahlNachVwd) {
        this.fallzahlNachVwd = fallzahlNachVwd;
    }

    public double getPunkteNachAkvd() {
        return punkteNachAkvd;
    }

    public void setPunkteNachAkvd(double punkteNachAkvd) {
        this.punkteNachAkvd = punkteNachAkvd;
    }

    public double getPunkteNachVwd() {
        return punkteNachVwd;
    }

    public void setPunkteNachVwd(double punkteNachVwd) {
        this.punkteNachVwd = punkteNachVwd;
    }
}
