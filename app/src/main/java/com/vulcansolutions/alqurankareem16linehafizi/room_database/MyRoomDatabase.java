package com.vulcansolutions.alqurankareem16linehafizi.room_database;


/*@Database(entities = {FavContact.class, RecentCall.class, Profile.class, User.class, SipCredential.class},exportSchema = false, version = 4)
public abstract class MyRoomDatabase extends RoomDatabase {

    private static MyRoomDatabase instance;

    public abstract FavouriteContactDAO favContactDAO();

    public abstract RecentCallDAO recentCallDAO();

    public abstract ProfileDAO profileDAO();

    public static synchronized MyRoomDatabase getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MyRoomDatabase.class,"slick_call_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}*/
