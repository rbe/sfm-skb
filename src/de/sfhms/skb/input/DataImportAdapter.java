package de.sfhms.skb.input;

import de.sfhms.skb.model.MyCell;
import de.sfhms.skb.model.MyDatamodel;
import java.net.URL;

public interface DataImportAdapter {

    /**
     * Open a datasource.
     * @param url
     */
    public void open(URL url);

    /**
     * Open a datasource.
     * @param url
     */
    public void open(String url);

    /**
     * Initialization for concrete file after opening/loading.
     */
    public void init();

    /**
     * Get cell value by sheet, row and column.
     * @param sheet
     * @param row
     * @param column
     * @param type
     */
    public MyCell getCell(int sheet, int row, int column);

    /**
     * Get row count for a certain sheet.
     * @param sheet
     * @return
     */
    public int getRowCount(int sheet);

    /**
     * Get column count for a certain sheet/certain row.
     * @param sheet
     * @return
     */
    public int getColumnCount(int sheet, int row);

    /**
     *
     * @param sheet
     * @param startRow
     * @param startColumn
     * @param endRow
     * @param endColumn
     * @return
     */
    public MyDatamodel getCellRange(int sheet, int startRow, int startColumn, int endRow, int endColumn);

    /**
     * 
     * @param sheetNumber
     * @return
     */
    public MyDatamodel getMyDatamodel(int sheet);
}
