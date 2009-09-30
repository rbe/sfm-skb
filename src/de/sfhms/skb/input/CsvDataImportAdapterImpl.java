package de.sfhms.skb.input;

import au.com.bytecode.opencsv.CSVReader;
import de.sfhms.skb.model.MyCell;
import de.sfhms.skb.model.MyDatamodel;
import de.sfhms.skb.model.MyRow;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CsvDataImportAdapterImpl implements DataImportAdapter {

    private CSVReader reader;

    public CsvDataImportAdapterImpl() {
    }

    @Override
    public void open(URL url) {
        try {
            reader = new CSVReader(new FileReader(new File(url.toURI())), ';');
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CsvDataImportAdapterImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(CsvDataImportAdapterImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getRowCount(int sheet) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getColumnCount(int sheet, int row) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public MyDatamodel getCellRange(int sheet, int startRow, int startColumn, int endRow, int endColumn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public MyDatamodel getMyDatamodel(int sheet) {
        MyDatamodel model = new MyDatamodel();
        String[] line = null;
        try {
            // TODO Read first line for header names?
            while ((line = reader.readNext()) != null) {
                MyRow row = new MyRow();
                for (int col = 0; col < line.length; col++) {
                    MyCell cell = new MyCell(null, line[col]);
                    row.addCell(cell);
                }
                model.addRow(row);
            }
        } catch (IOException ex) {
            Logger.getLogger(CsvDataImportAdapterImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
}
