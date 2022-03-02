package com.vs.alqurankareem16linehafizi.repositories;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.vs.alqurankareem16linehafizi.models.Ayat;
import java.util.ArrayList;
import java.util.List;

public class AyatRepo {

    private final Context context;
    public AyatRepo(Context context){
        this.context = context;
    }

    public LiveData<List<Ayat>> setAyatList(){
        MutableLiveData<List<Ayat>> ayatList = new MutableLiveData<>();
        ayatList.setValue(setAyatItems());
        return ayatList;
    }

    private List<Ayat> setAyatItems(){
        List<Ayat> list = new ArrayList<>();
        list.add(new Ayat(1,"1","1"));
        list.add(new Ayat(2,"1","2"));
        list.add(new Ayat(3,"1","3"));
        list.add(new Ayat(4,"1","4"));
        list.add(new Ayat(5,"1","5"));
        list.add(new Ayat(6,"1","6"));
        list.add(new Ayat(7,"1","7"));
        list.add(new Ayat(8,"1","8"));
        list.add(new Ayat(9,"1","9"));

        list.add(new Ayat(10,"2","1"));
        list.add(new Ayat(11,"2","2"));
        list.add(new Ayat(12,"2","3"));
        list.add(new Ayat(13,"2","4"));
        list.add(new Ayat(14,"2","5"));
        list.add(new Ayat(15,"2","6"));
        list.add(new Ayat(16,"2","7"));

        return list;
    }
}
