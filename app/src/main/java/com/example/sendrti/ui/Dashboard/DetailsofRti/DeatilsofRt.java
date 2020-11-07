package com.example.sendrti.ui.Dashboard.DetailsofRti;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.sendrti.R;

public class DeatilsofRt extends Fragment {

    private DeatilsofRtViewModel mViewModel;

    public static DeatilsofRt newInstance() {
        return new DeatilsofRt();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.deatilsof_rt_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DeatilsofRtViewModel.class);
        // TODO: Use the ViewModel
    }

}
