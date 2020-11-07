package com.example.sendrti.ui.statusfir;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.sendrti.R;

public class statusfir2 extends Fragment {

    private Statusfir2ViewModel mViewModel;

    public static statusfir2 newInstance() {
        return new statusfir2();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View View = inflater.inflate(R.layout.statusfir2_fragment, container, false);
        return View;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(Statusfir2ViewModel.class);
        // TODO: Use the ViewModel
    }

}
