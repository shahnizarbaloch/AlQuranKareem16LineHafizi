package com.vs.alqurankareem16linehafizi.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.squareup.picasso.Picasso;
import com.vs.alqurankareem16linehafizi.R;
import com.vs.alqurankareem16linehafizi.adapters.ViewPagerAdapter;
import com.vs.alqurankareem16linehafizi.databinding.DialogBookmarkPageBinding;
import com.vs.alqurankareem16linehafizi.databinding.FragmentPageViewBinding;
import com.vs.alqurankareem16linehafizi.models.Selection;
import com.vs.alqurankareem16linehafizi.repositories.BookmarkRepo;
import com.vs.alqurankareem16linehafizi.room_model.PageBookmark;
import com.vs.alqurankareem16linehafizi.usage.ConstantVariables;
import com.vs.alqurankareem16linehafizi.usage.MySharedPreferences;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class PageViewFragment extends Fragment{

    private FragmentPageViewBinding binding;
    private NavController navController;
    int totalPages = 557;
    private final String[] imageUrls = new String[totalPages];
    private String pageNumber ="1";
    private BookmarkRepo repo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPageViewBinding.inflate(inflater,container,false);

        binding.llToolbar.toolbarTitle.setText(getResources().getString(R.string.app_name));
        binding.llToolbar.imgBackArrow.setOnClickListener(e-> navController.popBackStack());

        initialize();

        return binding.getRoot();
    }

    @Override
    public void onStop() {
        super.onStop();
        saveReadingPage();
    }

    /**
     * method to initialize components
     */
    private void initialize() {
        repo = new BookmarkRepo(requireContext());
        checkAndSetValues();

        ViewPagerAdapter adapter = new ViewPagerAdapter(requireContext(), loadImagesListAssets());
        binding.cviewpager.setAdapter(adapter);

        screenAlwaysOn();
        setBorder();

        binding.moveableFloatingBtn.setX(Float.parseFloat(MySharedPreferences.getStringValue(requireContext(), ConstantVariables.VALUE_POINT_X,"10")));
        binding.moveableFloatingBtn.setY(Float.parseFloat(MySharedPreferences.getStringValue(requireContext(),ConstantVariables.VALUE_POINT_Y,"10")));

        binding.imgBookmark.setOnClickListener(e->showSaveDialog());

        binding.cviewpager.setCurrentItem(totalPages-Integer.parseInt(pageNumber));
        saveReadingPage();

    }

    /**
     * method to show save dialog
     */
    private void showSaveDialog() {
        final Dialog dialog = new Dialog(requireContext(),R.style.Dialog);
        DialogBookmarkPageBinding dialogBinding = DialogBookmarkPageBinding.inflate(LayoutInflater.from(requireContext()));
        dialog.setContentView(dialogBinding.getRoot());

        dialogBinding.btnSave.setOnClickListener(e->{
            String title = Objects.requireNonNull(dialogBinding.etTitle.getText()).toString();
            String description = Objects.requireNonNull(dialogBinding.etDescription.getText()).toString();

            if(title.isEmpty() || description.isEmpty()){
                Toast.makeText(requireContext(), R.string.empty_text_not_allowed, Toast.LENGTH_SHORT).show();
            }
            else{
                PageBookmark obj = new PageBookmark();
                obj.setPageNumber(pageNumber);
                obj.setTitle(title);
                obj.setDescription(description);
                obj.setBookmarkType(getString(R.string.page));
                repo.insertBookmark(obj);
                Toast.makeText(requireContext(), R.string.successfull, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.setCancelable(true);

        dialog.show();
    }

    /**
     * method to set save image in full imageview.
     */
    private void setBorder() {
        int selectedBorder = MySharedPreferences.getIntegerValue(requireContext(),ConstantVariables.SETTING_SELECTED_BORDER,1);
        switch (selectedBorder){
            case 1:
                Picasso.get().load(R.drawable.border_1).fit().into(binding.imgBorder);
                break;
            case 2:
                Picasso.get().load(R.drawable.border_2).fit().into(binding.imgBorder);
                break;
            case 3:
                Picasso.get().load(R.drawable.border_3).fit().into(binding.imgBorder);
                break;
            case 4:
                Picasso.get().load(R.drawable.border_4).fit().into(binding.imgBorder);
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
