package com.vulcansolutions.alqurankareem16linehafizi.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.vulcansolutions.alqurankareem16linehafizi.R;
import com.vulcansolutions.alqurankareem16linehafizi.dao.BookmarkDAO;
import com.vulcansolutions.alqurankareem16linehafizi.room_database.MyRoomDatabase;
import com.vulcansolutions.alqurankareem16linehafizi.room_model.PageBookmark;

import java.util.List;

/**
 * Singleton pattern
 */
public class BookmarkRepo {


    private final LiveData<List<PageBookmark>> surahBookmarkList;
    private final LiveData<List<PageBookmark>> paraBookmarkList;
    private static BookmarkDAO dao;


    public BookmarkRepo(Context application){
        MyRoomDatabase database = MyRoomDatabase.getInstance(application);
        dao = database.bookmarkDAO();
        surahBookmarkList = dao.listOfSurah(application.getString(R.string.surah));
        paraBookmarkList = dao.listOfSurah(application.getString(R.string.para));
    }


    public LiveData<List<PageBookmark>> getSurahBookmarkList(){
        return surahBookmarkList;
    }

    public LiveData<List<PageBookmark>> getParaBookmarkList(){
        return paraBookmarkList;
    }

    public void delete(PageBookmark pageBookmark){
        dao.delete(pageBookmark.getEnglishTitle());
    }

    public boolean checkIfAvailableInBookmark(String title){
        return dao.getIsBookmarked(title);
    }


    /*.public void updateSurah(PageBookmark pageBookmark){
        dao.update(pageBookmark);
    }*/

    public void insertBookmark(PageBookmark pageBookmark){
        dao.insert(pageBookmark);
    };


    public void deleteTableData(){
        dao.deleteCompleteTable();
    }

    /*public LiveData<Integer> getSelectedSurahAyatCount(String surahNo){
        return dao.getSelectedSurahAyatCount(surahNo);
    }*/



}
