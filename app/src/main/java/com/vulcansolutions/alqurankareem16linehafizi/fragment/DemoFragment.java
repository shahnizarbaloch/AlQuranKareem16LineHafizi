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
import com.vulcansolutions.alqurankareem16linehafizi.databinding.FragmentNewDemoBinding;

public class DemoFragment extends Fragment {

    private FragmentNewDemoBinding binding;
    private NavController navController;

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentNewDemoBinding.inflate(inflater,container,false);

        /*binding.customToolbar.title.setText(getResources().getString(R.string.change_text));
        binding.customToolbar.imgBackArrow.setOnClickListener(e-> navController.popBackStack());*/
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

}
