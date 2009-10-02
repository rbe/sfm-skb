package de.sfhms.skb.output;

import de.sfhms.skb.model.MyCell;
import de.sfhms.skb.processor.ProcessorException;
import java.net.URL;
import org.apache.poi.ss.usermodel.Sheet;

public interface DataOutputAdapter {

    void open(URL url);

    void open(String url);

    void init();

    Sheet addSheet(String name);

    Sheet getSheetByNumber(int index);

    void setCell(int sheet, int row, int col, Object value);

    void setCellRange(int sheet, int row, int col, MyCell[][] cells);

    void close() throws ProcessorException;
}
