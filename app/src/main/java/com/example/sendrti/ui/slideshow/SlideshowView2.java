package com.example.sendrti.ui.slideshow;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.sendrti.R;

public class SlideshowView2 extends Fragment {

    private SlideshowView2ViewModel mViewModel;

    public static SlideshowView2 newInstance() {
        return new SlideshowView2();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.slideshow_view2_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SlideshowView2ViewModel.class);
        // TODO: Use the ViewModel
    }

}
