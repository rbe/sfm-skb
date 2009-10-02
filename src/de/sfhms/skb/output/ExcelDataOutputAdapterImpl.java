package de.sfhms.skb.output;

import de.sfhms.skb.model.MyCell;
import de.sfhms.skb.processor.ProcessorException;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelDataOutputAdapterImpl implements DataOutputAdapter {

    private URL url;
    private Workbook workbook;

    public ExcelDataOutputAdapterImpl() {
    }

    public void open(URL url) {
        this.url = url;
    }

    public void open(String url) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void init() {
        workbook = new HSSFWorkbook();
    }

    public Sheet addSheet(String name) {
        return workbook.createSheet(name);
    }

    public Sheet getSheetByNumber(int index) {
        Sheet sheet = null;
        try {
            sheet = workbook.getSheetAt(index);
        } catch (IllegalArgumentException e) {
            sheet = addSheet("Tabelle" + index);
        }
        return sheet;
    }

    public Row addRow(int sheet, int row) {
        Sheet aSheet = getSheetByNumber(sheet);
        Row aRow = null;
        if (null != aSheet) {
            aRow = aSheet.createRow(row);
        }
        return aRow;
    }

    public void setCell(int sheet, int row, int col, Object value) {
        Row aRow = getSheetByNumber(sheet).getRow(row);
        if (null == aRow) {
            aRow = addRow(sheet, row);
        }
        if (value instanceof String) {
            aRow.createCell(col).setCellValue(workbook.getCreationHelper().createRichTextString("" + value));
        } else if (value instanceof Integer || value instanceof Float || value instanceof Double) {
            aRow.createCell(col).setCellValue(Double.valueOf("" + value));
        }
    }

    public void setCellRange(int sheet, int row, int col, MyCell[][] cells) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void close() throws ProcessorException {
        try {
            FileOutputStream out = new FileOutputStream(new File(url.toURI()));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            throw new ProcessorException("Could not save Excel file", e);
        }
    }
}
