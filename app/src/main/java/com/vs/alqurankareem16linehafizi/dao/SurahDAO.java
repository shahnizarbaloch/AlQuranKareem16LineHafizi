package com.vs.alqurankareem16linehafizi.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.vs.alqurankareem16linehafizi.room_model.SurahRoom;
import java.util.List;

@Dao
public interface SurahDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(SurahRoom surah);

    /*.@Delete
    void delete(SurahRoom surah);*/

    /*@Update
    void update(SurahRoom surah);*/


    @Query("SELECT * FROM quran_surah ORDER BY _id ASC")
    LiveData<List<SurahRoom>> listOfSurah();

    /*.@Query("SELECT * FROM quran_surah WHERE index_number = :id")
    LiveData<SurahRoom> getSurahByIndex(String id);

    @Query("SELECT * FROM quran_surah WHERE is_bookmarked = :bookmark")
    LiveData<List<SurahRoom>> getAllLikedSurah(Boolean bookmark);*/

    /*.@Query("")
    LiveData<Integer> getSelectedSurahAyatCount(String surahNo);*/

    /**
     * method to delete complete data from surah table
     */
    @Query("DELETE FROM quran_surah")
    void deleteCompleteTable();
}
