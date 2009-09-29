package de.sfhms.skb.output;

import de.sfhms.skb.model.MyCell;
import java.net.URL;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.33B71A36-AED7-26CE-856E-551B503321D5]
// </editor-fold> 
public interface DataOutputAdapter {

    public void open(URL url);

    public void setCell(int row, int col, Class type);

    public void setRowCount();

    public void setColmunCount();

    public MyCell [][] setCellRange ();
    
}

