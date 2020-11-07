package com.example.sendrti.Home.Track;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.sendrti.R;

public class TrackFragmen extends Fragment {

    private TrackViewModel2 mViewModel;

    public static TrackFragmen newInstance() {
        return new TrackFragmen();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View View = inflater.inflate(R.layout.track_fragment2, container, false);
        return View;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TrackViewModel2.class);
        // TODO: Use the ViewModel
    }

}
