package com.example.sendrti.ui.Dashboard;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import com.example.sendrti.R;
import com.example.sendrti.ui.Dashboard.Tabhost.Pager;
import com.google.android.material.tabs.TabLayout;

public class DashboardFragment extends Fragment implements TabLayout.OnTabSelectedListener{

    private DashboardViewModel dashboardViewModel;
    private TextView textView;
    TabHost TabHostWindow;
    NavController navController;
    private ImageButton Markssheet,incometax,statusfir,passport,property,funds,answersheet,connotfind;
    //This is our tablayout
    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        textView = root.findViewById(R.id.txt_image);


 //       textView = root.findViewById(R.id.continueasguest);
//        Markssheet = root.findViewById(R.id.markssheet);
//        statusfir = root.findViewById(R.id.firstatus);
//        passport = root.findViewById(R.id.passport);
//        incometax = root.findViewById(R.id.incometax);
//        property = root.findViewById(R.id.property);
//        funds = root.findViewById(R.id.funds);
//        answersheet = root.findViewById(R.id.answersheet);ab
//        connotfind = root.findViewById(R.id.cannotfind);

//Initializing the tablayout
        tabLayout = (TabLayout) root.findViewById(R.id.tabLayout);

      //   tabLayout.addTab(tabLayout.newTab().setText("Application Details"))
        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Application Details"));
        tabLayout.addTab(tabLayout.newTab().setText("Details of RTI"));
        tabLayout.addTab(tabLayout.newTab().setText("Safe Payments"));


        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        int orange = Color.rgb(255, 165, 0);
        tabLayout.setTabTextColors(ColorStateList.valueOf(orange));

        //Initializing viewPager
        viewPager = (ViewPager) root.findViewById(R.id.pager);


        //Creating our pager adapter
        Pager adapter = new Pager(getFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);






//        Markssheet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                 Navigation.findNavController(root).navigate(R.id.action_Funds);
//            }
//        });
//        statusfir.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(root).navigate(R.id.action_stausfir);
//            }
//        });
//        incometax.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(root).navigate(R.id.action_incometax);
//            }
//        });
//        passport.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(root).navigate(R.id.action_passport);
//            }
//        });
//        answersheet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(root).navigate(R.id.action_answersheet);
//            }
//        });
//        funds.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(root).navigate(R.id.action_Funds);
//            }
//        });
//        property.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(root).navigate(R.id.action_property);
//            }
//        });
//        connotfind.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(root).navigate(R.id.action_cannotfind);
//            }
//        });





//        statusfir.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(root).navigate(R.id.action_answersheet);
//            }
//        });
//        passport.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(root).navigate(R.id.action_answer);
//            }
//        });


        getObserver(dashboardViewModel);


//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                textView.setText(s);
//            }
//        });

        return root;
    }

    private void getObserver(DashboardViewModel dashboardViewModel) {


    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
