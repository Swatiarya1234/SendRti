package com.example.sendrti.ui.Dashboard.Tabhost;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sendrti.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Deatils_of_Rti extends Fragment implements View.OnClickListener{
    private Button previous;
    private Pager pager;
    private Button next;

    public Deatils_of_Rti() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.deatilsof_rt_fragment, container, false);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.previous:


                break;
            case R.id.next:
                break;
        }
    }
}
