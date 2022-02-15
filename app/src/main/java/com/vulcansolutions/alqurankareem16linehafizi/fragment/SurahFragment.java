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
import com.vulcansolutions.alqurankareem16linehafizi.room_model.PageBookmark;
import com.vulcansolutions.alqurankareem16linehafizi.room_model.SurahRoom;
import java.util.List;

public class SurahFragment extends Fragment implements SelectionSurahAdapter.OnMyOwnClickListener {

    private FragmentSurahBinding binding;
    private NavController navController;
    private SurahRepo repo;
    private BookmarkRepo bookmarkRepo;
    private SelectionSurahAdapter adapter;
    private List<SurahRoom> list;

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
        bookmarkRepo = new BookmarkRepo(requireContext());
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
        //Goto reading page.

        if(id==R.id.img_like){
            handleLikeButton(obj,position);
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

    /**
     * method to handle like button which is bookmark
     * @param obj surah obj
     * @param position position of the adapter
     */
    private void handleLikeButton(SurahRoom obj, int position) {

        PageBookmark bookmark = new PageBookmark();
        //bookmark.setId(obj.getId());
        bookmark.setArabicTitle(obj.getArabicTitle());
        bookmark.setDownAvailable(obj.getDownAvailable());
        bookmark.setEnglishTitle(obj.getEnglishTitle());
        bookmark.setPageNumber(obj.getPageNumber());
        bookmark.setIndexNumber(obj.getIndexNumber());
        bookmark.setBookmarkType(getString(R.string.surah));

        boolean isBookmarked = obj.isBookmarked();

        if (isBookmarked){
            obj.setBookmarked(false);
            bookmark.setBookmarked(false);
            bookmarkRepo.delete(bookmark);
        }
        else{
            obj.setBookmarked(true);
            bookmark.setBookmarked(true);
            bookmarkRepo.insertBookmark(bookmark);
        }

        adapter.notifyItemChanged(position);
    }
}
