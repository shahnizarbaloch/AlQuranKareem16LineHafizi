package com.vulcansolutions.alqurankareem16linehafizi.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.vulcansolutions.alqurankareem16linehafizi.room_model.BookmarkRoom;
import com.vulcansolutions.alqurankareem16linehafizi.room_model.SurahRoom;
import java.util.List;

@Dao
public interface BookmarkDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(BookmarkRoom bookmark);

    @Delete
    void delete(BookmarkRoom bookmark);

    @Update
    void update(BookmarkRoom bookmark);


    @Query("SELECT * FROM quran_bookmark ORDER BY _id ASC")
    LiveData<List<BookmarkRoom>> listOfBookmark();

    @Query("SELECT * FROM quran_bookmark WHERE index_number = :id")
    LiveData<BookmarkRoom> getBookmarkByIndex(String id);

   /* @Query("")
    LiveData<Integer> getSelectedSurahAyatCount(String surahNo);*/

}
