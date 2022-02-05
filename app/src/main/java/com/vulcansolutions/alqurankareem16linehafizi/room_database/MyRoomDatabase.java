package com.vulcansolutions.alqurankareem16linehafizi.room_database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.vulcansolutions.alqurankareem16linehafizi.room_model.BookmarkRoom;
import com.vulcansolutions.alqurankareem16linehafizi.room_model.ParaRoom;
import com.vulcansolutions.alqurankareem16linehafizi.room_model.SurahRoom;

@Database(entities = {ParaRoom.class, SurahRoom.class, BookmarkRoom.class},exportSchema = false, version = 1)
public abstract class MyRoomDatabase extends RoomDatabase {

    private static MyRoomDatabase instance;

    /*public abstract FavouriteContactDAO favContactDAO();

    public abstract RecentCallDAO recentCallDAO();

    public abstract ProfileDAO profileDAO();*/

    public static synchronized MyRoomDatabase getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MyRoomDatabase.class,"vs_quran_16line_db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
