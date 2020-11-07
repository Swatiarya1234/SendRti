package com.example.sendrti.ui.Dashboard.Tabhost;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.sendrti.ui.Dashboard.AppliactionDetails.ApplicationDetails;
import com.example.sendrti.ui.Dashboard.DetailsofRti.DeatilsofRti;
import com.example.sendrti.ui.Dashboard.SafeDetails.SafeDetails;

public class Pager extends FragmentStatePagerAdapter {

    int tabCount;
    public Pager(@NonNull FragmentManager fm) {
        super(fm);

    }

    public Pager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.tabCount= behavior;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ApplicationDetails tab1 = new ApplicationDetails();
                return tab1;
            case 1:
                DeatilsofRti tab2 = new DeatilsofRti();
                return tab2;
            case 2:
                SafeDetails tab3 = new SafeDetails();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
