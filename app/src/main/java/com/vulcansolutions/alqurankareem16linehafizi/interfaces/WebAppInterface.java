package com.vulcansolutions.alqurankareem16linehafizi.interfaces;

import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import androidx.navigation.NavController;
import com.google.firebase.analytics.FirebaseAnalytics;


public class WebAppInterface {
    private final Context context;
    //private final NavController navController;

    public WebAppInterface(Context context,NavController navController){
        this.context = context;
        //this.navController = navController;
    }

    @JavascriptInterface
    public void showSuccessfulMessage(String message){

    }

    private void sendFacebookEvent(String event) {


    }

    /**
     * method to send report in firebase analytics
     * @param event Event performed.
     */
    public void sendFirebaseAnalytics(String event) {
        Bundle params = new Bundle();
        FirebaseAnalytics.getInstance(context.getApplicationContext()).logEvent(event, params);
    }

}
