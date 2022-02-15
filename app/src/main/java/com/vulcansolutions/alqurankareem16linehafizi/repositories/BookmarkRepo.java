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
    private final LiveData<List<PageBookmark>> pageList;
    private static BookmarkDAO dao;


    public BookmarkRepo(Context application){
        MyRoomDatabase database = MyRoomDatabase.getInstance(application);
        dao = database.bookmarkDAO();
        surahBookmarkList = dao.listOfSurah(application.getString(R.string.surah));
        paraBookmarkList = dao.listOfSurah(application.getString(R.string.para));
        pageList = dao.listOfSurah(application.getString(R.string.page));
    }


    public LiveData<List<PageBookmark>> getSurahBookmarkList(){
        return surahBookmarkList;
    }

    public LiveData<List<PageBookmark>> getParaBookmarkList(){
        return paraBookmarkList;
    }

    public LiveData<List<PageBookmark>> getPageList(){
        return pageList;
    }

    public void delete(PageBookmark pageBookmark){
        dao.delete(pageBookmark.getTitle());
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
