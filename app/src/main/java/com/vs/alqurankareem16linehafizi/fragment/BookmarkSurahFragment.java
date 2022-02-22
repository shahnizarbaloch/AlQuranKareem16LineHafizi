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
import com.vs.alqurankareem16linehafizi.adapters.BookmarkSurahAndParaAdapter;
import com.vs.alqurankareem16linehafizi.databinding.FragmentSubBookmarkBinding;
import com.vs.alqurankareem16linehafizi.models.Selection;
import com.vs.alqurankareem16linehafizi.repositories.BookmarkRepo;
import com.vs.alqurankareem16linehafizi.room_model.PageBookmark;
import java.util.List;

public class BookmarkSurahFragment extends Fragment implements BookmarkSurahAndParaAdapter.OnMyOwnClickListener {

    private FragmentSubBookmarkBinding binding;
    private NavController navController;
    private BookmarkSurahAndParaAdapter adapter;
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
        bookmarkRepo.getSurahBookmarkList().observe(getViewLifecycleOwner(), list->{
            this.list = list;
            adapter = new BookmarkSurahAndParaAdapter(requireContext(),list,this);
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

        if(id==R.id.img_like){
            //Handle like menu
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
    private void handleLikeButton(PageBookmark obj, int position) {
        boolean isBookmarked = obj.isBookmarked();

        if (isBookmarked){
            bookmarkRepo.delete(obj);
        }
        else{
            bookmarkRepo.insertBookmark(obj);
        }

        adapter.notifyItemChanged(position);
    }
}
