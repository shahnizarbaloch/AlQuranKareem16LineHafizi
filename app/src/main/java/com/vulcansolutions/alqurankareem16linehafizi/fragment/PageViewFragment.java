package com.vulcansolutions.alqurankareem16linehafizi.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.vulcansolutions.alqurankareem16linehafizi.R;
import com.vulcansolutions.alqurankareem16linehafizi.adapters.CustomViewPager;
import com.vulcansolutions.alqurankareem16linehafizi.adapters.ViewPagerAdapter;
import com.vulcansolutions.alqurankareem16linehafizi.databinding.FragmentNewDemoBinding;
import com.vulcansolutions.alqurankareem16linehafizi.databinding.FragmentPageViewBinding;
import com.vulcansolutions.alqurankareem16linehafizi.usage.MovableFloatingActionButton;
import com.vulcansolutions.alqurankareem16linehafizi.usage.MySharedPreferences;

import java.util.ArrayList;
import java.util.Collections;

public class PageViewFragment extends Fragment {

    private FragmentPageViewBinding binding;
    private NavController navController;
    ViewPagerAdapter adapter;
    int totalPages = 549;
    private final String[] imageUrls = new String[totalPages];
    String pgNo="1";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPageViewBinding.inflate(inflater,container,false);

        binding.llToolbar.toolbarTitle.setText(getResources().getString(R.string.app_name));
        binding.llToolbar.imgBackArrow.setOnClickListener(e->navController.popBackStack());

        initialize();

        return binding.getRoot();
    }

    /**
     * method to initialize components
     */
    private void initialize() {
//        viewPager = findViewById(R.id.cviewpager);

//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            pgNo = extras.getString("PAGE_NO");
//        }else {
//            pgNo = SharedPrefManager.getmInstance(getApplicationContext()).getReadingPage();
//        }
        adapter = new ViewPagerAdapter(requireContext(), loadImagesListAssets());
        binding.cviewpager.setAdapter(adapter);

        screenAlwaysOn();

//        movableFloatingActionButton = findViewById(R.id.moveableFloatingBtn);
        binding.moveableFloatingBtn.setX(Float.parseFloat(MySharedPreferences.getStringValue(requireContext(),"POINT_X","10")));
        binding.moveableFloatingBtn.setY(Float.parseFloat(MySharedPreferences.getStringValue(requireContext(),"POINT_Y","10")));

        binding.cviewpager.setCurrentItem(totalPages-Integer.parseInt(pgNo));
        saveReadingPage();

    }
    private void screenAlwaysOn() {
        // If the Android version is lower than Jellybean, use this call to hide
        // the status bar.
        requireActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    private String[] loadImagesListAssets(){
        ArrayList<String> p = new ArrayList<>();
        for (int i = 0; i < imageUrls.length; i++){
            p.add("file:///android_asset/q8767K/al_quran_16_line ("+(i+1)+").jpg");
        }
        Collections.reverse(p);
        for (int j=0; j<imageUrls.length; j++){
            imageUrls[j]=p.get(j);
        }
        return imageUrls;
    }

    private void saveReadingPage(){
        MySharedPreferences.setStringValue(requireContext(), "PAGE_NO", (String.valueOf(totalPages-binding.cviewpager.getCurrentItem())));
        MySharedPreferences.setStringValue(requireContext(), "POINT_X", (String.valueOf(binding.moveableFloatingBtn.getX())));
        MySharedPreferences.setStringValue(requireContext(), "POINT_Y", (String.valueOf(binding.moveableFloatingBtn.getY())));
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

}
