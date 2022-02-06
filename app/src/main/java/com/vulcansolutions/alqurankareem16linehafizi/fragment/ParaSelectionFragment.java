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
import com.vulcansolutions.alqurankareem16linehafizi.adapters.SelectionParaAdapter;
import com.vulcansolutions.alqurankareem16linehafizi.databinding.FragmentParahBinding;
import com.vulcansolutions.alqurankareem16linehafizi.repositories.ParaRepo;
import com.vulcansolutions.alqurankareem16linehafizi.room_model.ParaRoom;
import java.util.List;

public class ParaSelectionFragment extends Fragment implements SelectionParaAdapter.OnMyOwnClickListener {

    private FragmentParahBinding binding;
    NavController navController;
    ParaRepo repo;
    SelectionParaAdapter adapter;
    List<ParaRoom> list;

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentParahBinding.inflate(inflater,container,false);

        initialize();
        return binding.getRoot();
    }

    /**
     * method to initialize components
     */
    private void initialize() {
        repo = new ParaRepo(requireActivity().getApplication());
        repo.getParaList().observe(getViewLifecycleOwner(),list->{
            this.list = list;
            adapter = new SelectionParaAdapter(requireContext(),list,this);
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
        ParaRoom obj = list.get(position);
        //Goto reading page..

    }
}
