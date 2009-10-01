package de.sfhms.skb.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rbe
 */
public final class MyRow {

    private List<MyCell> cells;

    public MyRow() {
        cells = new ArrayList<MyCell>();
    }

    public MyRow(List<MyCell> cells) {
        this.cells = cells;
    }

    public List<MyCell> getCells() {
        return cells;
    }

    public void setCells(List<MyCell> cells) {
        this.cells = cells;
    }

    public void addCell(MyCell cell) {
        cells.add(cell);
    }

    public MyCell getCell(int index) {
        return cells.get(index);
    }

    public long getCellCount() {
        return cells.size();
    }

    public void setCell(MyCell cell, int index) {
        cells.set(index, cell);
    }

    public void removeCell(MyCell cell) {
        cells.remove(cell);
    }

    public void removeCell(int index) {
        cells.remove(index);
    }
}
