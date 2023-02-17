package com.codewithdevesh.osproject.Models;

public class TableModel {
    String type;
    String inputs;

    public TableModel(String type, String inputs) {
        this.type = type;
        this.inputs = inputs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInputs() {
        return inputs;
    }

    public void setInputs(String inputs) {
        this.inputs = inputs;
    }
}
