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

import com.vulcansolutions.alqurankareem16linehafizi.adapters.HomeAdapter;
import com.vulcansolutions.alqurankareem16linehafizi.databinding.FragmentHomeBinding;
import com.vulcansolutions.alqurankareem16linehafizi.repositories.HomeRepo;

public class HomeFragment extends Fragment implements HomeAdapter.OnMyOwnClickListener {

    private FragmentHomeBinding binding;
    NavController navController;
    HomeRepo repo;
    HomeAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);

        /*binding.customToolbar.title.setText(getResources().getString(R.string.change_text));
        binding.customToolbar.imgBackArrow.setOnClickListener(e-> navController.popBackStack());*/

        initialize();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    /**
     * method to initialize components
     */
    private void initialize(){
        repo = new HomeRepo(requireContext());
        repo.getHomeMenuItems().observe(requireActivity(),menuItems->{
            adapter = new HomeAdapter(menuItems,requireContext(),this);
            binding.rvHomeMenu.setAdapter(adapter);
            GridLayoutManager layoutManager = new GridLayoutManager(requireContext(), 2);
            layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if(adapter.getItemViewType(position)==0){
                        return 2;
                    }
                    else{
                        return 1;
                    }
                }
            });
            binding.rvHomeMenu.setLayoutManager(layoutManager);

        });
    }

    @Override
    public void onMyOwnClick(int position, View view) {

    }
}
