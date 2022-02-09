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
import com.vulcansolutions.alqurankareem16linehafizi.adapters.SelectionBookmarkAdapter;
import com.vulcansolutions.alqurankareem16linehafizi.databinding.FragmentBookmarkBinding;
import com.vulcansolutions.alqurankareem16linehafizi.models.Selection;
import com.vulcansolutions.alqurankareem16linehafizi.repositories.BookmarkRepo;
import com.vulcansolutions.alqurankareem16linehafizi.room_model.BookmarkRoom;
import java.util.List;

public class BookmarkSelectionFragment extends Fragment implements SelectionBookmarkAdapter.OnMyOwnClickListener {

    private FragmentBookmarkBinding binding;
    NavController navController;
    BookmarkRepo repo;
    SelectionBookmarkAdapter adapter;
    List<BookmarkRoom> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentBookmarkBinding.inflate(inflater,container,false);

        binding.llToolbar.toolbarTitle.setText(getResources().getString(R.string.home_menu_bookmark));
        binding.llToolbar.imgBackArrow.setOnClickListener(e->navController.popBackStack());

        initialize();
        return binding.getRoot();
    }

    /**
     * method to initialize components
     */
    private void initialize() {
        repo = new BookmarkRepo(requireActivity().getApplication());
        repo.getBookmarkList().observe(getViewLifecycleOwner(),list->{
            this.list = list;
            adapter = new SelectionBookmarkAdapter(requireContext(),list,this);
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
        //BookmarkRoom obj = list.get(position);
        //Goto reading page..
        Selection sendToViewPage = new Selection();
        sendToViewPage.setPageNumber("-1");
        /*.sendToViewPage.setId(obj.getId());
        sendToViewPage.setArabicTitle(obj.getArabicTitle());
        sendToViewPage.setPageNumber(obj.getPageNumber());
        sendToViewPage.setDownAvailable(obj.getDownAvailable());
        sendToViewPage.setEnglishTitle(obj.getEnglishTitle());
        sendToViewPage.setIndexNumber(obj.getIndexNumber());*/

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
