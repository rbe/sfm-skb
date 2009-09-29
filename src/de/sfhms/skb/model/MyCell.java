package de.sfhms.skb.model;

public class MyCell {

    private String name;
    private Object value;

    public MyCell(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public Integer getValueAsInteger() {
        return (Integer) value;
    }

    public Long getValueAsLong() {
        return (Long) value;
    }

    public Double getValueAsDouble() {
        return (Double) value;
    }

    public String getValueAsString() {
        return "" + value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}

