package de.sfhms.skb.input;

import de.sfhms.skb.model.MyCell;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataImportAdapterImpl implements DataImportAdapter {

    private Workbook workbook;

    public ExcelDataImportAdapterImpl() {
    }

    public void open(URL url) {
        try {
            workbook = WorkbookFactory.create(new POIFSFileSystem(url.openStream()));
        } catch (IOException ex) {
            Logger.getLogger(ExcelDataImportAdapterImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void open(String url) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void init() {
    }

    public MyCell getCell(int sheet, int row, int column) {
        Sheet wbSheet = workbook.getSheetAt(sheet);
        Row wbRow = wbSheet.getRow(row);
        Cell cell = wbRow.getCell(column);
        int cellType = cell.getCellType();
        Object obj = null;
        switch (cellType) {
            case Cell.CELL_TYPE_NUMERIC:
                obj = cell.getNumericCellValue();
                break;
            case Cell.CELL_TYPE_STRING:
                obj = cell.getStringCellValue();
                break;
        }
        return new MyCell(sheet + "$" + row + column, obj);
    }

    public long getRowCount(int sheet) {
        return workbook.getSheetAt(sheet).getLastRowNum() + 1;
    }

    public long getColumnCount(int sheet, int row) {
        Sheet wbSheet = workbook.getSheetAt(sheet);
        return wbSheet.getRow(wbSheet.getLastRowNum()).getLastCellNum();
    }

    public MyCell[][] getCellRange(int sheet, int startRow, int startColumn, int endRow, int endColumn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

