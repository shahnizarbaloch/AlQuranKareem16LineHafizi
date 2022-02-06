package com.vulcansolutions.alqurankareem16linehafizi.fragment;

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
import androidx.recyclerview.widget.LinearLayoutManager;

import com.vulcansolutions.alqurankareem16linehafizi.R;
import com.vulcansolutions.alqurankareem16linehafizi.databinding.FragmentBorderSelectionBinding;
import com.vulcansolutions.alqurankareem16linehafizi.repositories.BorderSelectionRepo;

public class BorderSelectionFragment extends Fragment {

    private FragmentBorderSelectionBinding binding;
    private NavController navController;
    BorderSelectionRepo repo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentBorderSelectionBinding.inflate(inflater,container,false);

        binding.llToolbar.toolbarTitle.setText(getResources().getString(R.string.select_border));
        binding.llToolbar.imgBackArrow.setOnClickListener(e->navController.popBackStack());

        initialize();

        return binding.getRoot();
    }

    /**
     * method to initialize components.
     */
    private void initialize() {
        repo = new BorderSelectionRepo();
        repo.getBorderList().observe(getViewLifecycleOwner(),borderList->{
            binding.rvBorderSelection.setLayoutManager(new LinearLayoutManager(requireContext()
                    , LinearLayoutManager.HORIZONTAL, true));

        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

}
