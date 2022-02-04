package com.vulcansolutions.alqurankareem16linehafizi.usage;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {

    private static final String APP_SETTINGS = "com.vulcansolutions.quran16linehafizi";

    private MySharedPreferences() {}

    public static SharedPreferences getSharedPreferencesManager(Context context) {
        return context.getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);
    }

    /**
     * method to set string value
     * @param context context of the application
     * @param KEY key of the value
     * @param Value value
     */
    public static void setStringValue(Context context, String KEY, String Value){
        SharedPreferences.Editor editor = getSharedPreferencesManager(context).edit();
        editor.putString(KEY,Value);
        editor.apply();
    }

    /**
     * method to get the value from the following key
     * @param context context of the application
     * @param KEY key of the value
     * @param DefaultValue Default Value
     */
    public static String getStringValue(Context context,String KEY,String DefaultValue){
        return getSharedPreferencesManager(context).getString(KEY,DefaultValue);
    }

    /**
     * method to set values in the integer files of the applications..
     * @param context context of the application
     * @param KEY Key of the application
     * @param Value value of the application
     */
    public static void setIntegerValue(Context context, String KEY, int Value){
        SharedPreferences.Editor editor = getSharedPreferencesManager(context).edit();
        editor.putInt(KEY,Value);
        editor.apply();
    }

    /**
     * method to get the value from the following key
     * @param context context of the application
     * @param KEY key of the value
     * @param DefaultValue Default Value
     */
    public static boolean getBooleanValue(Context context,String KEY,boolean DefaultValue){
        return getSharedPreferencesManager(context).getBoolean(KEY,DefaultValue);
    }

    /**
     * method to set values in the integer files of the applications..
     * @param context context of the application
     * @param KEY Key of the application
     * @param Value value of the application
     */
    public static void setBooleanValue(Context context, String KEY, boolean Value){
        SharedPreferences.Editor editor = getSharedPreferencesManager(context).edit();
        editor.putBoolean(KEY,Value);
        editor.apply();
    }

    /**
     * method to get the value from the following key
     * @param context context of the application
     * @param KEY key of the value
     * @param DefaultValue Default Value
     */
    public static int getIntegerValue(Context context,String KEY,int DefaultValue){
        return getSharedPreferencesManager(context).getInt(KEY,DefaultValue);
    }



}
