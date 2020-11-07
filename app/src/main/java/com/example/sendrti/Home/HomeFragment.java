package com.example.sendrti.Home;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.sendrti.R;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private HomeViewModel mViewModel;
    private ImageButton apply,track,contactus,help;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.home_fragment, container, false);
        getView(view);
        apply.setOnClickListener(this);
        track.setOnClickListener(this);
        contactus.setOnClickListener(this);
        help.setOnClickListener(this);
        return view;
    }

    private void getView(View view) {
        apply = view.findViewById(R.id.Apply);
        track = view.findViewById(R.id.trackicon);
        help = view.findViewById(R.id.help);
        contactus = view.findViewById(R.id.contactus);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.Apply:
                mViewModel.naviagteApply(v);
                break;

            case R.id.trackicon:
                mViewModel.naviagteTrack(v);
                break;

            case R.id.contactus:
                mViewModel.naviagtecontactus(v);
                break;

            case R.id.help:
                mViewModel.navigatehelp(v);
                break;


        }
    }
}
