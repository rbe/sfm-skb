package de.sfhms.skb.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rbe
 */
public class MyDatamodel {

    private List<MyRow> rows;

    public MyDatamodel() {
        rows = new ArrayList<MyRow>();
    }

    public MyDatamodel(List<MyRow> rows) {
        this.rows = rows;
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
}
