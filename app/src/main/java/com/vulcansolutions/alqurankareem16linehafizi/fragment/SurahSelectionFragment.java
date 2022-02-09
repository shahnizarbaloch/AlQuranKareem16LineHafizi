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
import com.vulcansolutions.alqurankareem16linehafizi.adapters.SelectionSurahAdapter;
import com.vulcansolutions.alqurankareem16linehafizi.databinding.FragmentSurahBinding;
import com.vulcansolutions.alqurankareem16linehafizi.models.Selection;
import com.vulcansolutions.alqurankareem16linehafizi.repositories.BookmarkRepo;
import com.vulcansolutions.alqurankareem16linehafizi.repositories.SurahRepo;
import com.vulcansolutions.alqurankareem16linehafizi.room_model.BookmarkRoom;
import com.vulcansolutions.alqurankareem16linehafizi.room_model.SurahRoom;
import java.util.List;

public class SurahSelectionFragment extends Fragment implements SelectionSurahAdapter.OnMyOwnClickListener {

    private FragmentSurahBinding binding;
    NavController navController;
    SurahRepo repo;
    SelectionSurahAdapter adapter;
    List<SurahRoom> list;
    BookmarkRepo bookmarkRepo;

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
        bookmarkRepo = new BookmarkRepo(requireActivity().getApplication());
        repo.getSurahList().observe(getViewLifecycleOwner(),list->{
            if(list.isEmpty()){
                repo.deleteTableData();
                repo.insertSurah();
            }
            this.list = list;
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
        int id = view.getId();
        SurahRoom obj = list.get(position);
        //Goto reading page..


        if(id==R.id.img_like){
            //Handle like menu
            BookmarkRoom bookmarkObj = new BookmarkRoom();
            boolean isBookmarked = bookmarkObj.isBookmarked();
            bookmarkObj.setId(obj.getId());
            bookmarkObj.setArabicTitle(obj.getArabicTitle());
            bookmarkObj.setEnglishTitle(obj.getEnglishTitle());
            bookmarkObj.setDownAvailable(obj.getDownAvailable());
            bookmarkObj.setIndexNumber(obj.getIndexNumber());
            bookmarkObj.setPageNumber(obj.getPageNumber());
            if (isBookmarked){
                bookmarkObj.setBookmarked(false);
                bookmarkRepo.deleteBookmark(bookmarkObj);
            }
            else{
                bookmarkObj.setBookmarked(true);
                bookmarkRepo.insertBookmark(bookmarkObj);
            }
        }
        else{
            Selection sendToViewPage = new Selection();
            sendToViewPage.setId(obj.getId());
            sendToViewPage.setArabicTitle(obj.getArabicTitle());

            int page = Integer.parseInt(obj.getPageNumber());
            sendToViewPage.setPageNumber(String.valueOf(page+1));

            sendToViewPage.setDownAvailable(obj.getDownAvailable());
            sendToViewPage.setEnglishTitle(obj.getEnglishTitle());
            sendToViewPage.setIndexNumber(obj.getIndexNumber());
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
