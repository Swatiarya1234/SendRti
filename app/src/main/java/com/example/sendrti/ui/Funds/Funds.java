package com.example.sendrti.ui.Funds;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sendrti.R;
import com.example.sendrti.ui.gallery.GalleryViewModel;

public class Funds extends Fragment {

    private FundsViewModel2 mViewModel;

    public static Funds newInstance() {
        return new Funds();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.funds_fragment, container, false);
        mViewModel =
                ViewModelProviders.of(this).get(FundsViewModel2.class);



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FundsViewModel2.class);

        // TODO: Use the ViewModel
    }

}
