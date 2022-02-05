package com.vulcansolutions.alqurankareem16linehafizi.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.vulcansolutions.alqurankareem16linehafizi.room_model.SurahRoom;
import java.util.List;

@Dao
public interface SurahDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(SurahRoom surah);

    @Delete
    void delete(SurahRoom surah);

    @Update
    void update(SurahRoom surah);


    @Query("SELECT * FROM quran_surah ORDER BY _id ASC")
    LiveData<List<SurahRoom>> listOfSurah();

    @Query("SELECT * FROM quran_surah WHERE index_number = :id")
    LiveData<SurahRoom> getSurahByIndex(String id);

    @Query("")
    LiveData<Integer> getSelectedSurahAyatCount(String surahNo);

}
