package de.sfhms.skb.output;

import de.sfhms.skb.model.MyDatamodel;

/**
 * @author rbe
 */
public class MyOutput {

    public static void toDatabase(MyDatamodel model) {
    }

    /*
    public static <T> void toDatabase(Class<T> clazz, MyDatamodel model) {
    // Check arguments
    if (null == model || (null != model && model.getRowCount() == 0)) {
    throw new IllegalArgumentException("Null or empty argument");
    }
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
    List<T> list = csv.parse(strat, new StringReader(s));
    }
     */
}
