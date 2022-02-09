package com.vulcansolutions.alqurankareem16linehafizi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import com.vulcansolutions.alqurankareem16linehafizi.R;
import com.vulcansolutions.alqurankareem16linehafizi.adapters.HomeAdapterNew;
import com.vulcansolutions.alqurankareem16linehafizi.databinding.FragmentHomeBinding;
import com.vulcansolutions.alqurankareem16linehafizi.models.HomeMenu;
import com.vulcansolutions.alqurankareem16linehafizi.models.Selection;
import com.vulcansolutions.alqurankareem16linehafizi.repositories.HomeRepo;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements HomeAdapterNew.OnMyOwnClickListener {

    private FragmentHomeBinding binding;
    NavController navController;
    HomeRepo repo;
    HomeAdapterNew adapter;
    List<HomeMenu> list;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);

        binding.toolbarTitle.setText(getResources().getString(R.string.app_name));

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
        list = new ArrayList<>();
        repo = new HomeRepo(requireContext());
        repo.getHomeMenuItems().observe(requireActivity(),menuItems->{
            list = menuItems;
            adapter = new HomeAdapterNew(requireContext(),menuItems,this);
            binding.rvHomeMenu.setAdapter(adapter);
            GridLayoutManager layoutManager = new GridLayoutManager(requireContext(), 1);
            /*.layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if(adapter.getItemViewType(position)==0){
                        return 2;
                    }
                    else{
                        return 1;
                    }
                }
            });*/
            binding.rvHomeMenu.setLayoutManager(layoutManager);

        });

        binding.imgMenu.setOnClickListener(e->navController.navigate(R.id.action_homeFragment_to_moreFragment));
    }

    @Override
    public void onMyOwnClick(int position, View view) {
        //HomeMenu obj = list.get(position);

        if (position==0){
            Selection sendToViewPage = new Selection();

            sendToViewPage.setPageNumber("-1");

            Bundle bundle=new Bundle();
            bundle.putSerializable("obj",sendToViewPage);

            PageViewFragment fragment = new PageViewFragment();
            fragment.setArguments(bundle);

            NavOptions.Builder navBuilder =  new NavOptions.Builder();
            navBuilder.setEnterAnim(R.anim.enter).setExitAnim(R.anim.exit).setPopEnterAnim(R.anim.pop_enter).setPopExitAnim(R.anim.pop_exit);

            navController.navigate(R.id.pageViewFragment,bundle, navBuilder.build());
        }

        else if (position==1){
            navController.navigate(R.id.action_homeFragment_to_selectionFragment);
        }
        else if(position==2){
            navController.navigate(R.id.action_homeFragment_to_bookmarkSelectionFragment);
        }
        else if (position==3){
            navController.navigate(R.id.action_homeFragment_to_moreFragment);
        }

    }
}
