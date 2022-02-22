package com.vs.alqurankareem16linehafizi.fragment;

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
import com.vs.alqurankareem16linehafizi.R;
import com.vs.alqurankareem16linehafizi.adapters.BookmarkPageAdapter;
import com.vs.alqurankareem16linehafizi.databinding.FragmentSubBookmarkBinding;
import com.vs.alqurankareem16linehafizi.models.Selection;
import com.vs.alqurankareem16linehafizi.repositories.BookmarkRepo;
import com.vs.alqurankareem16linehafizi.room_model.PageBookmark;
import java.util.List;

public class BookmarkPageFragment extends Fragment implements BookmarkPageAdapter.OnMyOwnClickListener {

    private FragmentSubBookmarkBinding binding;
    private NavController navController;
    private BookmarkPageAdapter adapter;
    private BookmarkRepo bookmarkRepo;
    private List<PageBookmark> list;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSubBookmarkBinding.inflate(inflater,container,false);

        initialize();
        return binding.getRoot();
    }

    /**
     * method to initialize components
     */
    private void initialize() {
        bookmarkRepo = new BookmarkRepo(requireContext());
        bookmarkRepo.getPageList().observe(getViewLifecycleOwner(), list->{
            this.list = list;
            adapter = new BookmarkPageAdapter(requireContext(),list,this);
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
        int id = view.getId();
        PageBookmark obj = list.get(position);
        //Goto reading page.

        if(id==R.id.img_delete){
            //Handle like menu
            bookmarkRepo.delete(obj);
        }
        else{
            Selection sendToViewPage = new Selection();
            sendToViewPage.setId(obj.getId());

            int page = Integer.parseInt(obj.getPageNumber());
            sendToViewPage.setPageNumber(String.valueOf(page+1));

            Bundle bundle=new Bundle();
            bundle.putSerializable("obj",sendToViewPage);

            PageViewFragment fragment = new PageViewFragment();
            fragment.setArguments(bundle);

            NavOptions.Builder navBuilder =  new NavOptions.Builder();
            navBuilder.setEnterAnim(R.anim.enter).setExitAnim(R.anim.exit).setPopEnterAnim(R.anim.pop_enter).setPopExitAnim(R.anim.pop_exit);

            /*navController.navigate(RateFragmentDirections.actionRateAndPackageFragmentToRateCountryDetailsFragment(obj));*/
            navController.navigate(R.id.pageViewFragment,bundle, navBuilder.build());
        }

    }
}
