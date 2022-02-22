package com.vs.alqurankareem16linehafizi.room_database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.vs.alqurankareem16linehafizi.dao.BookmarkDAO;
import com.vs.alqurankareem16linehafizi.dao.ParaDAO;
import com.vs.alqurankareem16linehafizi.dao.SurahDAO;
import com.vs.alqurankareem16linehafizi.room_model.PageBookmark;
import com.vs.alqurankareem16linehafizi.room_model.ParaRoom;
import com.vs.alqurankareem16linehafizi.room_model.SurahRoom;

@Database(entities = {ParaRoom.class, SurahRoom.class, PageBookmark.class},exportSchema = false, version = 1)
public abstract class MyRoomDatabase extends RoomDatabase {

    private static MyRoomDatabase instance;

    public abstract SurahDAO surahDAO();

    public abstract ParaDAO paraDAO();

    public abstract BookmarkDAO bookmarkDAO();

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