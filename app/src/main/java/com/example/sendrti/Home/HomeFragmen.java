package com.example.sendrti.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.sendrti.R;

public class HomeFragmen extends Fragment {

    private HomeViewModel2 mViewModel;

    public static HomeFragmen newInstance() {
        return new HomeFragmen();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel2.class);
        // TODO: Use the ViewModel
    }

}
