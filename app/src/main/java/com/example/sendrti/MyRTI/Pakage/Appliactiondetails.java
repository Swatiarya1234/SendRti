package com.example.sendrti.MyRTI.Pakage;

import androidx.lifecycle.ViewModelProviders;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.sendrti.Adapter.AppliactiondetailsAdapter;
import com.example.sendrti.Adapter.ChatAdapter2;
import com.example.sendrti.ModelClass.AppliactionDetailsModel;
import com.example.sendrti.ModelClass.RtiModel;
import com.example.sendrti.R;
import com.example.sendrti.ui.Dashboard.Tabhost.Pager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Appliactiondetails extends Fragment implements View.OnClickListener{

    private AppliactiondetailsViewModel mViewModel;
    public List< AppliactionDetailsModel> appliactionDetailsModels= new ArrayList<>();
    AppliactiondetailsAdapter appliactiondetailsAdapter;
    private RecyclerView recyclerView;
    //This is our tablayout

    //This is our viewPager
    private ViewPager viewPager;
    public static Appliactiondetails newInstance() {
        return new Appliactiondetails();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.appliactiondetails_fragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerview2);

        appliactiondetails();

        appliactiondetailsAdapter = new AppliactiondetailsAdapter(appliactionDetailsModels,getActivity());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(appliactiondetailsAdapter);


//        //Adding the tabs using addTab() method
//        tabLayout.addTab(tabLayout.newTab().setText("Application Progress"));
//        tabLayout.addTab(tabLayout.newTab().setText("Appliaction Status"));
//        tabLayout.addTab(tabLayout.newTab().setText("My Rti Application"));
//        tabLayout.addTab(tabLayout.newTab().setText("Edit your profile"));
//        tabLayout.addTab(tabLayout.newTab().setText("Download your Rti"));
//        tabLayout.addTab(tabLayout.newTab().setText("Upload your Relevant Attachement"));
//        tabLayout.addTab(tabLayout.newTab().setText("Payment Invoice"));
//
//
//        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//
//        int orange = Color.rgb(255, 165, 0);
//        tabLayout.setTabTextColors(ColorStateList.valueOf(orange));
//
//        //Initializing viewPager
//        viewPager = (ViewPager) view.findViewById(R.id.pager);
//
//
//        //Creating our pager adapter
//        Pager adapter = new Pager(getFragmentManager(), tabLayout.getTabCount());
//
//        //Adding adapter to pager
//        viewPager.setAdapter(adapter);
//
//        //Adding onTabSelectedListener to swipe views
//        tabLayout.setOnTabSelectedListener(this);

        return view;
    }

    private void appliactiondetails() {

        AppliactionDetailsModel data = new AppliactionDetailsModel("Appliaction Details");
        appliactionDetailsModels.add(data);
        data = new AppliactionDetailsModel("Appliaction Status");
        appliactionDetailsModels.add(data);
        data = new AppliactionDetailsModel("My Rti Application");
        appliactionDetailsModels.add(data);
        data = new AppliactionDetailsModel("Edit your profile");
        appliactionDetailsModels.add(data);
        data = new AppliactionDetailsModel("Download your Rti");
        appliactionDetailsModels.add(data);
        data = new AppliactionDetailsModel("Upload Relevant Attachment");
        appliactionDetailsModels.add(data);
        data = new AppliactionDetailsModel("Payment Invoice");
        appliactionDetailsModels.add(data);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AppliactiondetailsViewModel.class);
        // TODO: Use the ViewModel
    }


    @Override
    public void onClick(View v) {

    }
}
