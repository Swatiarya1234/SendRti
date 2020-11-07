package com.example.sendrti.ui.pricing;

import androidx.lifecycle.ViewModelProviders;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sendrti.R;
import com.example.sendrti.ui.Dashboard.Tabhost.Pager;
import com.google.android.material.tabs.TabLayout;

public class pricing extends Fragment implements TabLayout.OnTabSelectedListener {

    private PricingViewModel mViewModel;
    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;


    public static pricing newInstance() {
        return new pricing();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pricing_fragment, container, false);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("EMAIL"));
        tabLayout.addTab(tabLayout.newTab().setText("PHONE"));
        viewPager = (ViewPager) view.findViewById(R.id.pager);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        int orange = Color.rgb(255, 165, 0);
        tabLayout.setTabTextColors(ColorStateList.valueOf(orange));


        Pager2 adapter = new Pager2(getFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);

        viewPager.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PricingViewModel.class);
        // TODO: Use the ViewModel
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
