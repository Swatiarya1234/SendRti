package com.example.sendrti.MyRTI.Pakage.tablayouts.tablayoutssubparts.AppliactionProgress;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sendrti.R;

public class ApplicationProgress extends Fragment {

    private ApplicationProgressViewModel mViewModel;

    public static ApplicationProgress newInstance() {
        return new ApplicationProgress();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.application_progress_fragment, container, false);
       return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ApplicationProgressViewModel.class);
        // TODO: Use the ViewModel
    }

}
