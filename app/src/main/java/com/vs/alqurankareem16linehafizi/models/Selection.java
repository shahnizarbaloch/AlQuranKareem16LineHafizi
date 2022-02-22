package com.vs.alqurankareem16linehafizi.models;

import java.io.Serializable;

public class Selection implements Serializable {


    private int id;

    private String indexNumber;

    private String pageNumber;

    private String englishTitle;

    private String arabicTitle;

    private String downAvailable;

    public Selection() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getEnglishTitle() {
        return englishTitle;
    }

    public void setEnglishTitle(String englishTitle) {
        this.englishTitle = englishTitle;
    }

    public String getArabicTitle() {
        return arabicTitle;
    }

    public void setArabicTitle(String arabicTitle) {
        this.arabicTitle = arabicTitle;
    }

    public String getDownAvailable() {
        return downAvailable;
    }

    public void setDownAvailable(String downAvailable) {
        this.downAvailable = downAvailable;
    }


}
