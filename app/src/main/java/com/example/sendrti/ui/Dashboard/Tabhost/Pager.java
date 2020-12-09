package com.example.sendrti.ui.Dashboard.Tabhost;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

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
               ApplicationDeatils tab1 = new ApplicationDeatils();
                return tab1;
            case 1:
                Deatils_of_Rti tab2 = new Deatils_of_Rti();
                return tab2;
            case 2:
                Safe_Details tab3 = new Safe_Details();
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
