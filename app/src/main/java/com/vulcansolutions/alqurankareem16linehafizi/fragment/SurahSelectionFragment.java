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
import com.vulcansolutions.alqurankareem16linehafizi.adapters.SelectionAdapter;
import com.vulcansolutions.alqurankareem16linehafizi.databinding.FragmentSurahBinding;

public class SurahSelectionFragment extends Fragment implements SelectionAdapter.OnMyOwnClickListener {

    private FragmentSurahBinding binding;
    private NavController navController;

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSurahBinding.inflate(inflater,container,false);

        initialize();
        return binding.getRoot();
    }

    /**
     * method to initialize components
     */
    private void initialize() {
        SelectionAdapter adapter = new SelectionAdapter(requireContext(),null,this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    @Override
    public void onMyOwnClick(int position, View view) {

    }
}
