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
import androidx.recyclerview.widget.LinearLayoutManager;
import com.squareup.picasso.Picasso;
import com.vulcansolutions.alqurankareem16linehafizi.R;
import com.vulcansolutions.alqurankareem16linehafizi.adapters.BorderSelectionAdapter;
import com.vulcansolutions.alqurankareem16linehafizi.databinding.FragmentBorderSelectionBinding;
import com.vulcansolutions.alqurankareem16linehafizi.repositories.BorderSelectionRepo;

public class BorderSelectionFragment extends Fragment implements BorderSelectionAdapter.OnMyOwnClickListener {

    private FragmentBorderSelectionBinding binding;
    private NavController navController;
    BorderSelectionRepo repo;
    BorderSelectionAdapter adapter;

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
                    , LinearLayoutManager.HORIZONTAL, false));
            adapter = new BorderSelectionAdapter(requireContext(),borderList,this);
            binding.rvBorderSelection.setAdapter(adapter);
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    @Override
    public void onMyOwnClick(int position, View view) {
        switch (position){
            case 0:
                Picasso.get().load(R.drawable.border_1).into(binding.imgFull);
                break;
            case 1:
                Picasso.get().load(R.drawable.border_2).into(binding.imgFull);
                break;
            case 2:
                Picasso.get().load(R.drawable.border_3).into(binding.imgFull);
                break;
            case 3:
                Picasso.get().load(R.drawable.border_4).into(binding.imgFull);
                break;
        }
    }
}
