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
import com.vulcansolutions.alqurankareem16linehafizi.adapters.SelectionParaAdapter;
import com.vulcansolutions.alqurankareem16linehafizi.databinding.FragmentSubBookmarkBinding;
import com.vulcansolutions.alqurankareem16linehafizi.models.Selection;
import com.vulcansolutions.alqurankareem16linehafizi.repositories.ParaRepo;
import com.vulcansolutions.alqurankareem16linehafizi.room_model.ParaRoom;
import java.util.List;

public class BookmarkParaFragment extends Fragment implements SelectionParaAdapter.OnMyOwnClickListener {

    private FragmentSubBookmarkBinding binding;
    private NavController navController;
    private SelectionParaAdapter adapter;
    private ParaRepo repo;
    private List<ParaRoom> list;


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
        repo = new ParaRepo(requireActivity().getApplication());

        repo.getLikedParaList().observe(getViewLifecycleOwner(),list->{
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
        int id = view.getId();
        if(id==R.id.img_like){
            //Handle like menu
            boolean isBookmarked = obj.isBookmarked();
            obj.setBookmarked(!isBookmarked);
            repo.updatePara(obj);
            adapter.notifyItemChanged(position);

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
