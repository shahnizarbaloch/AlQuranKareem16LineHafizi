package com.vulcansolutions.alqurankareem16linehafizi.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.vulcansolutions.alqurankareem16linehafizi.room_model.PageBookmark;

import java.util.List;

@Dao
public interface BookmarkDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(PageBookmark bookmark);

    @Query("DELETE FROM page_bookmark where title=:title")
    void delete(String title);

    @Update
    void update(PageBookmark bookmark);


    /*@Query("SELECT * FROM page_bookmark ORDER BY _id ASC")
    LiveData<List<PageBookmark>> listOfBookmark();*/

    @Query("SELECT * FROM page_bookmark where english_title=:title")
    boolean getIsBookmarked(String title);

    @Query("SELECT * FROM page_bookmark where bookmark_type=:bookmarkType ORDER BY _id ASC")
    LiveData<List<PageBookmark>> listOfSurah(String bookmarkType);



    /**
     * method to delete complete data from surah table
     */
    @Query("DELETE FROM page_bookmark")
    void deleteCompleteTable();
}
