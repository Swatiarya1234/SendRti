package com.example.sendrti.ui.Dashboard.Tabhost;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sendrti.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ApplicationDeatils extends Fragment {

    public ApplicationDeatils() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_application_details, container, false);
        return view;
    }
}
