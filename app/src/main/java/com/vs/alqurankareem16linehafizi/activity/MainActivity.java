package com.vs.alqurankareem16linehafizi.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.vs.alqurankareem16linehafizi.BuildConfig;
import com.vs.alqurankareem16linehafizi.databinding.ActivityMainBinding;
import com.vs.alqurankareem16linehafizi.usage.ConstantVariables;
import com.vs.alqurankareem16linehafizi.usage.MySharedPreferences;

import java.util.Locale;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class MainActivity extends AppCompatActivity {

    /**
     * This method is for font
     * @param newBase it is Context
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/Seravek.ttf")
                                .setFontAttrId(io.github.inflationx.calligraphy3.R.attr.fontPath)
                                .build()))
                .build());



        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        changeLanguage(MySharedPreferences.getStringValue(this, ConstantVariables.APP_LANG,"en"));

        initialize();
    }

    /**
     * method to change language to user default language.
     * @param selectedLanguage selected language
     */
    private void changeLanguage(String selectedLanguage) {
        Locale locale = new Locale(selectedLanguage);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        config.setLayoutDirection(Locale.ENGLISH);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }

    /**
     * method to initialize components
     */
    private void initialize() {
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(BuildConfig.AD_ID);
    }




}
