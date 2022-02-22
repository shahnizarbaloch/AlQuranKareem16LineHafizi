package com.vs.alqurankareem16linehafizi.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.vs.alqurankareem16linehafizi.room_model.ParaRoom;
import java.util.List;

@Dao
public interface ParaDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ParaRoom para);

    @Delete
    void delete(ParaRoom para);

    @Update
    void update(ParaRoom para);


    @Query("SELECT * FROM quran_para ORDER BY _id ASC")
    LiveData<List<ParaRoom>> listOfPara();

    /*.@Query("SELECT * FROM quran_para WHERE index_number = :id")
    LiveData<ParaRoom> getParaByIndex(String id);

    @Query("SELECT * FROM quran_para WHERE is_bookmarked = :bookmark")
    LiveData<List<ParaRoom>> getAllLikedPara(Boolean bookmark);*/

    /*.@Query("")
    LiveData<Integer> getSelectedSurahAyatCount(String surahNo);*/

    @Query("DELETE FROM quran_para")
    void deleteCompleteTable();
}
