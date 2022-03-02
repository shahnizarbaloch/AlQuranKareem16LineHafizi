package com.vs.alqurankareem16linehafizi.models;

public class Ayat {

    private int rowNumber;
    private String baseNumber;
    private String secondNumber;
    private boolean isSelected;

    public Ayat(int rowNumber,String baseNumber, String secondNumber) {
        this.rowNumber=rowNumber;
        this.baseNumber = baseNumber;
        this.secondNumber = secondNumber;
    }

    public String getBaseNumber() {
        return baseNumber;
    }

    public void setBaseNumber(String baseNumber) {
        this.baseNumber = baseNumber;
    }

    public String getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

}
