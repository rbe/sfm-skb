package de.sfhms.skb.input;

import de.sfhms.skb.model.MyCell;
import java.net.URL;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.126CD7B1-25C5-EDEE-6CE4-9523E0CC713A]
// </editor-fold> 
public interface DataImportAdapter {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EB77521D-0DFF-8125-BFF3-79A3EFCEF6E6]
    // </editor-fold> 
    public void open(URL url);

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F7E98273-E063-522A-8023-6D60F241E0C7]
    // </editor-fold> 
    public void getCell(int row, int col, Class type);

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.84DCC9F2-CE6C-5FD5-295F-E8451E52D35F]
    // </editor-fold> 
    public int getRowCount();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6AD4068C-266D-8F70-5EFC-8182C3D001F8]
    // </editor-fold> 
    public int getColumnCount();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BDBC9A2F-CC7D-316D-55E8-F14CD374BF8C]
    // </editor-fold> 
    public MyCell[][] getCellRange();
}

