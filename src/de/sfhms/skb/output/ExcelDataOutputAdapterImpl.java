package de.sfhms.skb.output;

import de.sfhms.skb.model.MyCell;
import java.net.URL;

public class ExcelDataOutputAdapterImpl implements DataOutputAdapter {

    public ExcelDataOutputAdapterImpl() {
    }

    public void open(URL url) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void open(String url) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void init() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setCell(int row, int col, Class type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setRowCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setColmunCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public MyCell[][] setCellRange() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
