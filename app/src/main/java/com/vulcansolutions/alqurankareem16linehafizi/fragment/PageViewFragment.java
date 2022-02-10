package com.vulcansolutions.alqurankareem16linehafizi.fragment;

import android.annotation.SuppressLint;
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
import com.squareup.picasso.Picasso;
import com.vulcansolutions.alqurankareem16linehafizi.R;
import com.vulcansolutions.alqurankareem16linehafizi.adapters.ViewPagerAdapter;
import com.vulcansolutions.alqurankareem16linehafizi.databinding.FragmentPageViewBinding;
import com.vulcansolutions.alqurankareem16linehafizi.models.Selection;
import com.vulcansolutions.alqurankareem16linehafizi.usage.ConstantVariables;
import com.vulcansolutions.alqurankareem16linehafizi.usage.MySharedPreferences;
import java.util.ArrayList;
import java.util.Collections;

public class PageViewFragment extends Fragment{

    private FragmentPageViewBinding binding;
    private NavController navController;
    int totalPages = 549;
    private final String[] imageUrls = new String[totalPages];
    String pageNumber ="1";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPageViewBinding.inflate(inflater,container,false);

        binding.llToolbar.toolbarTitle.setText(getResources().getString(R.string.app_name));
        binding.llToolbar.imgBackArrow.setOnClickListener(e->{
            saveReadingPage();
            navController.popBackStack();
        });

        initialize();

        return binding.getRoot();
    }

    /**
     * method to initialize components
     */
    private void initialize() {

        checkAndSetValues();

        ViewPagerAdapter adapter = new ViewPagerAdapter(requireContext(), loadImagesListAssets());
        binding.cviewpager.setAdapter(adapter);

        screenAlwaysOn();
        setBorder();

        binding.moveableFloatingBtn.setX(Float.parseFloat(MySharedPreferences.getStringValue(requireContext(), ConstantVariables.VALUE_POINT_X,"10")));
        binding.moveableFloatingBtn.setY(Float.parseFloat(MySharedPreferences.getStringValue(requireContext(),ConstantVariables.VALUE_POINT_Y,"10")));

        binding.cviewpager.setCurrentItem(totalPages-Integer.parseInt(pageNumber));
        saveReadingPage();

    }

    /**
     * method to set save image in full imageview.
     */
    private void setBorder() {
        int selectedBorder = MySharedPreferences.getIntegerValue(requireContext(),ConstantVariables.SETTING_SELECTED_BORDER,1);
        switch (selectedBorder){
            case 1:
                Picasso.get().load(R.drawable.border_1).into(binding.imgBorder);
                break;
            case 2:
                Picasso.get().load(R.drawable.border_2).into(binding.imgBorder);
                break;
            case 3:
                Picasso.get().load(R.drawable.border_3).into(binding.imgBorder);
                break;
            case 4:
                Picasso.get().load(R.drawable.border_4).into(binding.imgBorder);
                break;
        }
    }

    /**
     * method to get the object values and set them into components.
     */
    @SuppressLint("SetTextI18n")
    private void checkAndSetValues() {
        if (getArguments() != null) {
            Selection obj = (Selection) getArguments().getSerializable("obj");
            pageNumber = obj.getPageNumber();
            try {
                int pageNumberInt = Integer.parseInt(pageNumber);
                if(pageNumberInt==-1){
                    pageNumber = MySharedPreferences.getStringValue(requireContext(),ConstantVariables.VALUE_PAGE_NO,"1");
                }
            }catch (Exception ignored){

            }

        }
    }


    private void screenAlwaysOn() {
        // If the Android version is lower than Jellybean, use this call to hide
        // the status bar.
        requireActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    /**
     * method to load images from assets folder
     * @return array of pages.
     */
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
        MySharedPreferences.setStringValue(requireContext(), ConstantVariables.VALUE_PAGE_NO, (String.valueOf(totalPages-binding.cviewpager.getCurrentItem())));
        MySharedPreferences.setStringValue(requireContext(), ConstantVariables.VALUE_POINT_X, (String.valueOf(binding.moveableFloatingBtn.getX())));
        MySharedPreferences.setStringValue(requireContext(), ConstantVariables.VALUE_POINT_Y, (String.valueOf(binding.moveableFloatingBtn.getY())));
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        /*navController.addOnDestinationChangedListener((navController, navDestination, bundle) -> saveReadingPage());*/
    }



}
