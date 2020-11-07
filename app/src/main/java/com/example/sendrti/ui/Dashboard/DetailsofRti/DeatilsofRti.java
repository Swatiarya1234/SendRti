package com.example.sendrti.ui.Dashboard.DetailsofRti;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.sendrti.R;

public class DeatilsofRti extends Fragment implements View.OnClickListener{

    private DeatilsofRtiViewModel mViewModel;
    private Button previous,next;
    private ImageButton answersheet,Marksheet,Passport,Incometax,Firstatus,property,epf,pension,funds,realstate,road,Tender,Gram,mla,Db,newrti;

    public static DeatilsofRti newInstance() {
        return new DeatilsofRti();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.deatilsof_rti_fragment, container, false);
        getView(view);
        return view;
    }

    private void getView(View view) {
        previous = view.findViewById(R.id.previous);
        next = view.findViewById(R.id.next);
        answersheet = view.findViewById(R.id.answersheet);
        Marksheet = view.findViewById(R.id.markssheet);
        Passport = view.findViewById(R.id.iconpassport);
        Incometax = view.findViewById(R.id.incometax);
        Firstatus  = view.findViewById(R.id.firstatus);
        property = view.findViewById(R.id.property);
        epf = view.findViewById(R.id.epf2);
        pension = view.findViewById(R.id.pension);
        funds = view.findViewById(R.id.funds);
        realstate = view.findViewById(R.id.realstate);
        road = view.findViewById(R.id.road);
        Tender = view.findViewById(R.id.tender);
        Gram = view.findViewById(R.id.gram);
        mla = view.findViewById(R.id.mla);
        Db = view.findViewById(R.id.db);
        newrti = view.findViewById(R.id.new_rti);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DeatilsofRtiViewModel.class);
        previous.setOnClickListener(this);
        next.setOnClickListener(this);
        answersheet.setOnClickListener(this);
        Marksheet.setOnClickListener(this);
        Passport.setOnClickListener(this);
        Incometax.setOnClickListener(this);
        Firstatus.setOnClickListener(this);
        property.setOnClickListener(this);
        epf.setOnClickListener(this);
        pension.setOnClickListener(this);
        funds.setOnClickListener(this);
        realstate.setOnClickListener(this);
        road.setOnClickListener(this);
        Tender.setOnClickListener(this);
        Gram.setOnClickListener(this);
        mla.setOnClickListener(this);
        Db.setOnClickListener(this);
        newrti.setOnClickListener(this);
    // TODO: Use the ViewModel
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.previous:
                mViewModel.previous(v);
                break;

            case R.id.next:
                mViewModel.next(v);
                break;

            case R.id.answersheet:
                mViewModel.answerhseet(v);
                break;

            case R.id.markssheet:
                mViewModel.marksheet(v);
                break;

            case R.id. iconpassport:
                mViewModel.passport(v);
                break;

            case R.id.incometax:
                mViewModel.Incometax(v);
                break;

            case R.id.firstatus:
                mViewModel.firstatus(v);
                break;

            case R.id.property:
                mViewModel.property(v);
                break;

            case R.id.epf2:
                mViewModel.epf(v);
                break;
            case R.id.pension:
                mViewModel.pension(v);
                break;

        }
    }
}