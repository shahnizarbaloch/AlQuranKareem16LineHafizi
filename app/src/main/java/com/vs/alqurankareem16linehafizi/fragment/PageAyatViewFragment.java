package com.vs.alqurankareem16linehafizi.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import com.vs.alqurankareem16linehafizi.R;
import com.vs.alqurankareem16linehafizi.adapters.ParaViewAdapter;
import com.vs.alqurankareem16linehafizi.databinding.FragmentPageViewParaBinding;
import com.vs.alqurankareem16linehafizi.models.Ayat;
import com.vs.alqurankareem16linehafizi.repositories.AyatRepo;

import java.util.ArrayList;
import java.util.List;

public class PageAyatViewFragment extends Fragment implements ParaViewAdapter.OnMyOwnClickListener {

    private FragmentPageViewParaBinding binding;
    private NavController navController;
    private List<Ayat> list;
    private ParaViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPageViewParaBinding.inflate(inflater, container, false);

        binding.llToolbar.toolbarTitle.setText(getResources().getString(R.string.app_name));
        binding.llToolbar.imgBackArrow.setOnClickListener(e -> navController.popBackStack());

        initialize();

        return binding.getRoot();
    }

    /**
     * method to initialize components
     */
    private void initialize() {
        list = new ArrayList<>();
        AyatRepo repo = new AyatRepo(requireContext());
        repo.setAyatList().observe(getViewLifecycleOwner(), list -> {
            this.list = list;
            adapter = new ParaViewAdapter(requireContext(), list, this);
            binding.rvAyat.setAdapter(adapter);
            binding.rvAyat.setLayoutManager(new GridLayoutManager(requireContext(), 1));
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onMyOwnClick(int position, View view) {
        Ayat obj = list.get(position);

        for (int i=0;i<list.size();i++){
            list.get(i).setSelected(false);
        }

        obj.setSelected((obj.getRowNumber() - 1) == position && !obj.isSelected());

        adapter.notifyDataSetChanged();
    }
}
