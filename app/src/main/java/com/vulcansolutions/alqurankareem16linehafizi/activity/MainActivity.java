package com.vulcansolutions.alqurankareem16linehafizi.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.vulcansolutions.alqurankareem16linehafizi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initialize();
    }

    /**
     * method to initialize components
     */
    private void initialize() {
    }

}
