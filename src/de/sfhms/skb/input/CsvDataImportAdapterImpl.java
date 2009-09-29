package de.sfhms.skb.input;

import au.com.bytecode.opencsv.CSVReader;
import de.sfhms.skb.model.MyCell;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CsvDataImportAdapterImpl implements DataImportAdapter {

    CSVReader reader = null;

    public CsvDataImportAdapterImpl() {
    }

    public void open(URL url) {
        try {
            reader = new CSVReader(new FileReader(new File(url.toURI())), ';');
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CsvDataImportAdapterImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(CsvDataImportAdapterImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void open(String url) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void init() {
        String[] nextLine;
        try {
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                System.out.println(nextLine.length);
            }
        } catch (IOException ex) {
            Logger.getLogger(CsvDataImportAdapterImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
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

