package com.example.sendrti.Home.ApplyNow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.sendrti.R;

public class Applynow2 extends Fragment {

    private Applynow2ViewModel mViewModel;

    public static Applynow2 newInstance() {
        return new Applynow2();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.applynow2_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(Applynow2ViewModel.class);
        // TODO: Use the ViewModel
    }

}
