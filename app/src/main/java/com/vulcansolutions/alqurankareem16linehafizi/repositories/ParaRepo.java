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

    private final LiveData<List<ParaRoom>> paraList;
    private static ParaDAO dao;


    public ParaRepo(Application application){
        MyRoomDatabase database = MyRoomDatabase.getInstance(application);
        dao = database.paraDAO();
        paraList = dao.listOfPara();
    }


    public LiveData<List<ParaRoom>> getParaList(){
        return paraList;
    }

    public void insertPara(ParaRoom paraRoom){
        dao.insert(paraRoom);
    }

    public void deletePara(ParaRoom paraRoom){
        dao.delete(paraRoom);
    }

    public LiveData<ParaRoom> getParaByIndex(String indexNumber){
        return dao.getParaByIndex(indexNumber);
    }

    /*public LiveData<Integer> getSelectedSurahAyatCount(String surahNo){
        return dao.getSelectedSurahAyatCount(surahNo);
    }*/



}
