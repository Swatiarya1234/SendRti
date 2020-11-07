package com.example.sendrti.ui.pricing;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.sendrti.ui.Dashboard.AppliactionDetails.ApplicationDetails;
import com.example.sendrti.ui.Dashboard.DetailsofRti.DeatilsofRti;
import com.example.sendrti.ui.Dashboard.SafeDetails.SafeDetails;
import com.example.sendrti.ui.pricing.Email.Email;
import com.example.sendrti.ui.pricing.Phone.Phone;

public class Pager2 extends FragmentStatePagerAdapter {

    int tabCount;
    public Pager2(@NonNull FragmentManager fm) {
        super(fm);

    }

    public Pager2(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.tabCount= behavior;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Email tab1 = new Email();
                return tab1;
            case 1:
                Phone tab2 = new Phone();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
