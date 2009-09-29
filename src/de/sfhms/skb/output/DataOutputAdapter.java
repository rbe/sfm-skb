package de.sfhms.skb.output;

import de.sfhms.skb.model.MyCell;
import java.net.URL;

public interface DataOutputAdapter {

    public void open(URL url);

    public void open(String url);

    public void init();

    public void setCell(int row, int col, Class type);

    public void setRowCount();

    public void setColmunCount();

    public MyCell[][] setCellRange();
}
