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
import androidx.recyclerview.widget.GridLayoutManager;

import com.vulcansolutions.alqurankareem16linehafizi.adapters.SelectionSurahAdapter;
import com.vulcansolutions.alqurankareem16linehafizi.databinding.FragmentSurahBinding;
import com.vulcansolutions.alqurankareem16linehafizi.repositories.SurahRepo;

public class SurahSelectionFragment extends Fragment implements SelectionSurahAdapter.OnMyOwnClickListener {

    private FragmentSurahBinding binding;
    NavController navController;
    SurahRepo repo;
    SelectionSurahAdapter adapter;

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
        repo = new SurahRepo(requireActivity().getApplication());
        repo.getSurahList().observe(getViewLifecycleOwner(),list->{
            adapter = new SelectionSurahAdapter(requireContext(),list,this);
            binding.rvSurah.setAdapter(adapter);
            binding.rvSurah.setLayoutManager(new GridLayoutManager(requireContext(),1));
        });
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
