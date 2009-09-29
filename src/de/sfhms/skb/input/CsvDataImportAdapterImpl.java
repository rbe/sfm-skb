package de.sfhms.skb.input;

import de.sfhms.skb.model.MyCell;
import java.net.URL;

public class CsvDataImportAdapterImpl implements DataImportAdapter {

    public CsvDataImportAdapterImpl() {
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

    public MyCell getCell(int sheet, int row, int column) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public long getRowCount(int sheet) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public long getColumnCount(int sheet, int row) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public MyCell[][] getCellRange(int sheet, int startRow, int startColumn, int endRow, int endColumn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

