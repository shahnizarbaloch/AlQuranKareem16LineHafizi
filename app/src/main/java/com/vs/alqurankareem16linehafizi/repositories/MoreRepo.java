package com.vs.alqurankareem16linehafizi.repositories;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.vs.alqurankareem16linehafizi.R;
import com.vs.alqurankareem16linehafizi.models.MoreMenu;
import java.util.ArrayList;
import java.util.List;

public class MoreRepo {

    private final Context context;
    public MoreRepo(Context context){
        this.context = context;
    }

    public LiveData<List<MoreMenu>> getMoreMenuItems(){
        MutableLiveData<List<MoreMenu>> settingItemList = new MutableLiveData<>();
        settingItemList.setValue(setMoreMenuItems());
        return settingItemList;
    }

    private List<MoreMenu> setMoreMenuItems(){
        List<MoreMenu> list = new ArrayList<>();

        list.add(new MoreMenu(context.getResources().getString(R.string.remove_ads),
                R.drawable.ic_ads_remove
        ));

        list.add(new MoreMenu(context.getResources().getString(R.string.change_theme),
                R.drawable.ic_theme_change
        ));

        /*.list.add(new MoreMenu(context.getResources().getString(R.string.notifications),
                R.drawable.ic_notification
        ));*/

        list.add(new MoreMenu(context.getResources().getString(R.string.home_menu_share),
                R.drawable.ic_share
        ));

        list.add(new MoreMenu(context.getResources().getString(R.string.feedback),
                R.drawable.feedback
        ));

        list.add(new MoreMenu(context.getResources().getString(R.string.contact_us),
                R.drawable.ic_contact_us
        ));

        list.add(new MoreMenu(context.getResources().getString(R.string.privacy_policy),
                R.drawable.ic_privacy_policy
        ));



        return list;
    }
}
