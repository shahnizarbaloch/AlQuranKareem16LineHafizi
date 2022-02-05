package com.vulcansolutions.alqurankareem16linehafizi.repositories;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.vulcansolutions.alqurankareem16linehafizi.dao.SurahDAO;
import com.vulcansolutions.alqurankareem16linehafizi.room_database.MyRoomDatabase;
import com.vulcansolutions.alqurankareem16linehafizi.room_model.SurahRoom;
import java.util.List;

/**
 * Singleton pattern
 */
public class SurahRepo {

    private final LiveData<List<SurahRoom>> surahList;
    private static SurahDAO dao;


    public SurahRepo(Application application){
        MyRoomDatabase database = MyRoomDatabase.getInstance(application);
        dao = database.surahDAO();
        surahList = dao.listOfSurah();
    }


    public LiveData<List<SurahRoom>> getSurahList(){
        return surahList;
    }

    public void insertSurah(SurahRoom surahRoom){
        dao.insert(surahRoom);
    }

    public void deleteSurah(SurahRoom surahRoom){
        dao.delete(surahRoom);
    }

    public LiveData<SurahRoom> getSurahByIndex(String indexNumber){
        return dao.getSurahByIndex(indexNumber);
    }

    public LiveData<Integer> getSelectedSurahAyatCount(String surahNo){
        return dao.getSelectedSurahAyatCount(surahNo);
    }



}
