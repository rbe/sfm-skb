package de.sfhms.skb.input;

import de.sfhms.skb.model.MyCell;
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
     * Convenience method: get cell by row, column. Use default value for sheet.
     * @param row
     * @param column
     * @return
     */
    public MyCell getCell(int row, int column);

    /**
     * Get row count for a certain sheet.
     * @param sheet
     * @return
     */
    public long getRowCount(int sheet);

    /**
     * Convenience method: get row count for default sheet.
     * @return
     */
    public long getRowCount();

    /**
     * Get column count for a certain sheet.
     * @param sheet
     * @return
     */
    public long getColumnCount(int sheet);

    /**
     * Convenience method: get column count for default sheet.
     * @return
     */
    public long getColumnCount();

    /**
     *
     * @param sheet
     * @param startRow
     * @param startColumn
     * @param endRow
     * @param endColumn
     * @return
     */
    public MyCell[][] getCellRange(int sheet, int startRow, int startColumn, int endRow, int endColumn);

    /**
     *
     * @param startRow
     * @param startColumn
     * @param endRow
     * @param endColumn
     * @return
     */
    public MyCell[][] getCellRange(int startRow, int startColumn, int endRow, int endColumn);
}
