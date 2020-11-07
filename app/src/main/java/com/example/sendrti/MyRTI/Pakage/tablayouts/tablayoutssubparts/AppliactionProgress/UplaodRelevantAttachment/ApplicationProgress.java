package com.example.sendrti.MyRTI.Pakage.tablayouts.tablayoutssubparts.AppliactionProgress.UplaodRelevantAttachment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.sendrti.R;

public class ApplicationProgress extends Fragment {

    private ApplicationProgressViewModel mViewModel;

    public static ApplicationProgress newInstance() {
        return new ApplicationProgress();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.application_progress_fragment2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProvideers.of(this).get(ApplicationProgressViewModel.class);
        // TODO: Use the ViewModel
    }

}
