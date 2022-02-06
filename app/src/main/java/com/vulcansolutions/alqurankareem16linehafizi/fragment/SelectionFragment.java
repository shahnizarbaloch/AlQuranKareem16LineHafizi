package com.vulcansolutions.alqurankareem16linehafizi.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.vulcansolutions.alqurankareem16linehafizi.R;
import com.vulcansolutions.alqurankareem16linehafizi.databinding.FragmentSelectionBinding;

public class SelectionFragment extends Fragment {

    private FragmentSelectionBinding binding;
    private NavController navController;

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSelectionBinding.inflate(inflater,container,false);

        binding.llToolbar.toolbarTitle.setText(getResources().getString(R.string.app_name));
        binding.llToolbar.imgBackArrow.setOnClickListener(e->navController.popBackStack());

        initialize();

        return binding.getRoot();
    }

    /**
     * method to initialize components
     */
    private void initialize() {
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getChildFragmentManager(), FragmentPagerItems.with(requireContext())
                .add(getString(R.string.menu_1_surah), SurahSelectionFragment.class)
                .add(getString(R.string.menu_2_para), ParaSelectionFragment.class)
                .add(getString(R.string.menu_3_sajda), HomeFragment.class)
                .add(getString(R.string.menu_4_manzil), HomeFragment.class)
                .create());

        binding.viewpager.setAdapter(adapter);

        binding.viewpagertab.setViewPager(binding.viewpager);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

}
