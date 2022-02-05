package com.vulcansolutions.alqurankareem16linehafizi.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.vulcansolutions.alqurankareem16linehafizi.dao.BookmarkDAO;
import com.vulcansolutions.alqurankareem16linehafizi.dao.ParaDAO;
import com.vulcansolutions.alqurankareem16linehafizi.room_database.MyRoomDatabase;
import com.vulcansolutions.alqurankareem16linehafizi.room_model.BookmarkRoom;
import com.vulcansolutions.alqurankareem16linehafizi.room_model.ParaRoom;

import java.util.List;

/**
 * Singleton pattern
 */
public class BookmarkRepo {

    private final LiveData<List<BookmarkRoom>> bookmarkList;
    private static BookmarkDAO dao;


    public BookmarkRepo(Application application){
        MyRoomDatabase database = MyRoomDatabase.getInstance(application);
        dao = database.bookmarkDAO();
        bookmarkList = dao.listOfBookmark();
    }

    public LiveData<List<BookmarkRoom>> getBookmarkList(){
        return bookmarkList;
    }

    public void insertBookmark(BookmarkRoom paraRoom){
        dao.insert(paraRoom);
    }

    public void deleteBookmark(BookmarkRoom paraRoom){
        dao.delete(paraRoom);
    }

    public LiveData<BookmarkRoom> getBookmarkByIndex(String indexNumber){
        return dao.getBookmarkByIndex(indexNumber);
    }

    public LiveData<Integer> getSelectedSurahAyatCount(String surahNo){
        return dao.getSelectedSurahAyatCount(surahNo);
    }



}
