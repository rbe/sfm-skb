package de.sfhms.skb.processor.plugin.output;

import java.util.Date;

/**
 *
 * @author rbe
 */
public class OutputHelper {

    private Date actualYear;
    private int actualRow;

    private static class Holder {

        private static final OutputHelper INSTANCE = new OutputHelper();
    }

    private OutputHelper() {
    }

    public static OutputHelper getInstance() {
        return Holder.INSTANCE;
    }

    public int getActualRow() {
        return actualRow;
    }

    public void setActualRow(int actualRow) {
        this.actualRow = actualRow;
    }

    public Date getActualYear() {
        return actualYear;
    }

    public void setActualYear(Date actualYear) {
        this.actualYear = actualYear;
    }
}
