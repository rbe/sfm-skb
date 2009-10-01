package de.sfhms.skb.input;

import de.sfhms.skb.model.MyCell;
import de.sfhms.skb.model.MyDatamodel;
import de.sfhms.skb.model.MyRow;
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

    @Override
    public void open(URL url) {
        try {
            workbook = WorkbookFactory.create(new POIFSFileSystem(url.openStream()));
        } catch (IOException ex) {
            Logger.getLogger(ExcelDataImportAdapterImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void open(String url) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void init() {
    }

    @Override
    public MyCell getCell(int sheet, int row, int column) {
        Sheet wbSheet = workbook.getSheetAt(sheet);
        Row wbRow = wbSheet.getRow(row);
        Cell cell = wbRow.getCell(column);
        MyCell myCell = null;
        if (null != cell) {
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
            myCell = new MyCell(sheet + "$" + row + column, obj);
        } else {
            myCell = new MyCell(sheet + "$" + row + column, null);
        }
        return myCell;
    }

    @Override
    public int getRowCount(int sheet) {
        return workbook.getSheetAt(sheet).getLastRowNum() + 1;
    }

    @Override
    public int getColumnCount(int sheet, int row) {
        Sheet wbSheet = workbook.getSheetAt(sheet);
        Row wbRow = wbSheet.getRow(row);
        if (null != wbRow) {
            return wbRow.getLastCellNum();
        } else {
            return 0;
        }
    }

    @Override
    public MyDatamodel getCellRange(int sheet, int startRow, int startColumn, int endRow, int endColumn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public MyDatamodel getMyDatamodel(int sheet) {
        // Check arguments
        if (sheet < 0) {
            throw new IllegalArgumentException("negative index!");
        }
        //
        int rows = getRowCount(sheet);
        MyDatamodel model = new MyDatamodel();
        for (int r = 0; r < rows; r++) {
            MyRow row = new MyRow();
            int cnt = getColumnCount(sheet, r);
            if (cnt > 0) {
                for (int col = 0; col < cnt; col++) {
                    row.addCell(getCell(sheet, r, col));
                }
                model.addRow(row);
            } else {
                model.addRow(new MyRow());
            }
        }
        return model;
    }
}
