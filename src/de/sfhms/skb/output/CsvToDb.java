package de.sfhms.skb.output;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import de.sfhms.skb.model.MyCell;
import de.sfhms.skb.model.MyDatamodel;
import de.sfhms.skb.model.MyRow;
import de.sfhms.skb.model.bean.AkvdBean;
import java.util.List;

/**
 * @author rbe
 */
public class CsvToDb {

    public static <T> void akvd(Class<T> clazz, MyDatamodel model) {
        // Check arguments
        if (null == model || (null != model && model.getRowCount() == 0)) {
            throw new IllegalArgumentException("Null or empty argument");
        }
        //
        ColumnPositionMappingStrategy<T> strat = new ColumnPositionMappingStrategy<T>();
        strat.setType(clazz);
        // Get column names from first row
        List<MyCell> cell = model.getRow(0).getCells();
        String[] columns = new String[cell.size()];
        int i = 0;
        for (MyCell c : cell) {
            System.out.println("" + c.getName());
            columns[i++] = c.getName();
        }
        strat.setColumnMapping(columns);
        //
        CsvToBean<T> csv = new CsvToBean<T>();
        //List<AkvdBean> list = csv.parse(strat, new StringReader(s));
    }

    public static void main(String[] args) {
        MyCell cell = new MyCell("name", 1);
        MyRow row = new MyRow();
        row.addCell(cell);
        MyDatamodel model = new MyDatamodel();
        model.addRow(row);
        CsvToDb.<AkvdBean>akvd(AkvdBean.class, model);
    }
}
