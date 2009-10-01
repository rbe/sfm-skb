package de.sfhms.skb.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rbe
 */
public class MyDatamodel {

    private String name;
    private List<MyRow> rows;

    public MyDatamodel() {
        rows = new ArrayList<MyRow>();
    }

    public MyDatamodel(List<MyRow> rows) {
        this.rows = rows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MyRow> getRows() {
        return rows;
    }

    public MyRow getRow(int index) {
        return rows.get(index);
    }

    public void setRows(List<MyRow> row) {
        this.rows = row;
    }

    public void setRow(MyRow row, int index) {
        rows.set(index, row);
    }

    public void addRow(MyRow row) {
        rows.add(row);
    }

    public long getRowCount() {
        return rows.size();
    }

    public MyRow[] findRowByValue(Object value, String... columnName) {
        // Check arguments
        if (null == value) {
            throw new IllegalArgumentException("Null argument!");
        }
        //
        List<MyRow> list = new ArrayList<MyRow>();
        for (MyRow row : rows) {
            for (MyCell cell : row.getCells()) {
                boolean b = cell.getValue().equals(value);
                if (null != columnName && columnName.length > 0) {
                    for (String n : columnName) {
                        if (cell.getName().equals(n)) {
                            list.add(row);
                            break;
                        }
                    }
                } else if (b) {
                    list.add(row);
                    break;
                }
            }
        }
        //
        return list.toArray(new MyRow[list.size()]);
    }
}
