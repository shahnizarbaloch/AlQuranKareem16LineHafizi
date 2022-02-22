package com.vs.alqurankareem16linehafizi.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.vs.alqurankareem16linehafizi.R;
import com.vs.alqurankareem16linehafizi.models.HomeMenu;

import java.util.ArrayList;
import java.util.List;

public class HomeRepo {

    private final Context context;
    public HomeRepo(Context context){
        this.context = context;
    }

    public LiveData<List<HomeMenu>> getHomeMenuItems(){
        MutableLiveData<List<HomeMenu>> settingItemList = new MutableLiveData<>();
        settingItemList.setValue(setHomeMenuItems());
        return settingItemList;
    }

    private List<HomeMenu> setHomeMenuItems(){
        List<HomeMenu> list = new ArrayList<>();
        list.add(new HomeMenu(context.getResources().getString(R.string.home_menu_continue_reciting),
                context.getResources().getString(R.string.last_page),
                R.drawable.ic_continue_recite
        ));

        list.add(new HomeMenu(context.getResources().getString(R.string.home_menu_quran),
                context.getResources().getString(R.string.start),
                R.drawable.ic_recite
                ));

        list.add(new HomeMenu(context.getResources().getString(R.string.home_menu_bookmark),
                context.getResources().getString(R.string.go_to),
                R.drawable.ic_bookmark
        ));

        list.add(new HomeMenu(context.getResources().getString(R.string.settings),
                context.getResources().getString(R.string.change),
                R.drawable.ic_setting
        ));
        return list;
    }
}
