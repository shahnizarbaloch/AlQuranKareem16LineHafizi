package com.vulcansolutions.alqurankareem16linehafizi.room_model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "quran_bookmark")
public class BookmarkRoom {

    public void setId(int id) {
        this.id = id;
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private int id;

    @ColumnInfo(name = "index_number")
    private String indexNumber;

    @ColumnInfo(name = "page_number")
    private String pageNumber;

    @ColumnInfo(name = "english_title")
    private String englishTitle;

    @ColumnInfo(name = "arabic_title")
    private String arabicTitle;

    @ColumnInfo(name = "down_available")
    private String downAvailable;

    public BookmarkRoom() {
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
