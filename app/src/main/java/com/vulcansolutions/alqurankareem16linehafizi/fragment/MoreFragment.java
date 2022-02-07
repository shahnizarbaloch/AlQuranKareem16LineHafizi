package com.vulcansolutions.alqurankareem16linehafizi.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
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
import com.vulcansolutions.alqurankareem16linehafizi.R;
import com.vulcansolutions.alqurankareem16linehafizi.adapters.MoreAdapter;
import com.vulcansolutions.alqurankareem16linehafizi.databinding.FragmentMoreBinding;
import com.vulcansolutions.alqurankareem16linehafizi.models.MoreMenu;
import com.vulcansolutions.alqurankareem16linehafizi.repositories.MoreRepo;
import com.vulcansolutions.alqurankareem16linehafizi.usage.DeviceInfo;
import java.util.ArrayList;
import java.util.List;

public class MoreFragment extends Fragment implements MoreAdapter.OnMyOwnClickListener {

    private FragmentMoreBinding binding;
    private NavController navController;
    MoreRepo repo;
    List<MoreMenu> list;
    private String versionName="1.0";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMoreBinding.inflate(inflater,container,false);

        binding.llToolbar.toolbarTitle.setText(getResources().getString(R.string.settings));
        binding.llToolbar.imgBackArrow.setOnClickListener(e->navController.popBackStack());

        initialize();

        return binding.getRoot();
    }

    /**
     * method to initialize components
     */
    @SuppressLint("SetTextI18n")
    private void initialize() {
        list = new ArrayList<>();
        repo = new MoreRepo(requireContext());
        repo.getMoreMenuItems().observe(getViewLifecycleOwner(),moreMenus -> {
            list = moreMenus;
            MoreAdapter adapter = new MoreAdapter(requireContext(),moreMenus,this);
            binding.rvMore.setAdapter(adapter);
            binding.rvMore.setLayoutManager(new GridLayoutManager(requireContext(),1));
        });

        int versionCode = 1;
        try{
            versionName = requireContext().getPackageManager()
                    .getPackageInfo(requireContext().getPackageName(), 0).versionName;

            versionCode = requireContext().getPackageManager()
                    .getPackageInfo(requireContext().getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        binding.tvAppVersion.setText("App version : "+versionName +" - Build "+versionCode);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    @Override
    public void onMyOwnClick(int position, View view) {
        MoreMenu obj = list.get(position);
        if (obj.getTitle().equalsIgnoreCase(getString(R.string.change_theme))){
            navController.navigate(R.id.action_moreFragment_to_borderSelectionFragment);
        }
        else if (obj.getTitle().equalsIgnoreCase(getString(R.string.contact_us))){
            composeEmail();
        }
        else if (obj.getTitle().equalsIgnoreCase(getString(R.string.home_menu_share))){
            shareApp(requireContext());
        }
        else if (obj.getTitle().equalsIgnoreCase(getString(R.string.feedback))){
            gotoPlayStore(requireContext());
        }
    }

    /**
     * method to go to play store link of the app
     */
    private void shareApp(Context context) {
        final String appPackageName = context.getPackageName();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Download "+getString(R.string.app_name)+"\n https://play.google.com/store/apps/details?id=" + appPackageName);
        sendIntent.setType("text/plain");
        context.startActivity(sendIntent);
    }

    private void gotoPlayStore(Context context){
        final String appPackageName = context.getPackageName(); // getPackageName() from Context or Activity object
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    /**
     * method to write email for contact with all the details of the device.
     */
    public void composeEmail() {
        Intent mailIntent = new Intent(Intent.ACTION_SENDTO);
        Uri data = Uri.parse("mailto:?subject="
                + "App Support Android (Version : "+versionName+")"
                + "&body=" + "\n\n"+new DeviceInfo().getDeviceDetails()
                + "&to=" + "app-support@vulcan_solution.com");
        mailIntent.setData(data);
        startActivity(Intent.createChooser(mailIntent, "Contact Us"));
    }
}
