package com.vulcansolutions.alqurankareem16linehafizi.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import com.vulcansolutions.alqurankareem16linehafizi.dao.ParaDAO;
import com.vulcansolutions.alqurankareem16linehafizi.room_database.MyRoomDatabase;
import com.vulcansolutions.alqurankareem16linehafizi.room_model.ParaRoom;
import java.util.List;

/**
 * Singleton pattern
 */
public class ParaRepo {

    private final LiveData<List<ParaRoom>> surahList;
    private static ParaDAO dao;


    public ParaRepo(Application application){
        MyRoomDatabase database = MyRoomDatabase.getInstance(application);
        dao = database.paraDAO();
        surahList = dao.listOfPara();
    }


    public LiveData<List<ParaRoom>> getSurahList(){
        return surahList;
    }

    public void insertSurah(ParaRoom paraRoom){
        dao.insert(paraRoom);
    }

    public void deleteSurah(ParaRoom paraRoom){
        dao.delete(paraRoom);
    }

    public LiveData<ParaRoom> getParaByIndex(String indexNumber){
        return dao.getParaByIndex(indexNumber);
    }

    public LiveData<Integer> getSelectedSurahAyatCount(String surahNo){
        return dao.getSelectedSurahAyatCount(surahNo);
    }



}
