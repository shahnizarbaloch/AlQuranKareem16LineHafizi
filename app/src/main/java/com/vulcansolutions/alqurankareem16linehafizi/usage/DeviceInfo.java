package com.vulcansolutions.alqurankareem16linehafizi.usage;

public class DeviceInfo {

    // get System info.
    public static String OS_NAME = System.getProperty("os.name");
    public static String OS_VERSION = System.getProperty("os.version");
    public static String RELEASE = android.os.Build.VERSION.RELEASE;
    public static String DEVICE = android.os.Build.DEVICE;
    public static String MODEL = android.os.Build.MODEL;
    public static String PRODUCT = android.os.Build.PRODUCT;
    public static String BRAND = android.os.Build.BRAND;
    public static String DISPLAY = android.os.Build.DISPLAY;
    public static String UNKNOWN = android.os.Build.UNKNOWN;
    public static String HARDWARE = android.os.Build.HARDWARE;
    public static String ID = android.os.Build.ID;
    public static String MANUFACTURER = android.os.Build.MANUFACTURER;
    public static String USER = android.os.Build.USER;
    public static String HOST = android.os.Build.HOST;


    public String getDeviceDetails(String MSISDN){
        String s="";
        s += "\n Contact: " + MSISDN;
        s += "\n OS Version: " + OS_VERSION + "(" + android.os.Build.VERSION.INCREMENTAL + ")";
        s += "\n OS Name: " + OS_NAME;
        s += "\n OS API Level: " + android.os.Build.VERSION.SDK_INT;
        s += "\n ID: " + ID;
        s += "\n Device: " + DEVICE;
        s += "\n Display: " + DISPLAY;
        s += "\n Unknown: " + UNKNOWN;
        s += "\n User: " + USER;
        s += "\n Manufacturer: " + MANUFACTURER;
        s += "\n Hardware: " + HARDWARE;
        s += "\n Host: " + HOST;
        s += "\n Release: " + RELEASE;
        s += "\n Brand: " + BRAND;
        s += "\n Model (and Product): " + MODEL + " ("+ PRODUCT + ")";
        return s;
    }
}
