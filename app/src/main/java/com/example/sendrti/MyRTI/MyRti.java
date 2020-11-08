package com.example.sendrti.MyRTI;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.sendrti.Adapter.MyRtiAdapter;
import com.example.sendrti.ModelClass.RtiModel;
import com.example.sendrti.R;

import java.util.ArrayList;
import java.util.List;

public class MyRti extends Fragment implements View.OnClickListener{

    private MyRtiViewModel mViewModel;
    private ArrayList<RtiModel> rtiModels = new ArrayList<>();
    private MyRtiAdapter studentAdapter;
    private RecyclerView recyclerView;

    public static MyRti newInstance() {
        return new MyRti();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_rti_fragment, container, false);
        Reciver();
        studentAdapter = new MyRtiAdapter(rtiModels,getContext());
        getView(view);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(studentAdapter);


        return view;
    }

    private void getView(View view) {
        recyclerView = view.findViewById(R.id.recyclerview2);
    }

    private void Reciver() {
        RtiModel data = new RtiModel("23456","Delivered","1","Sep 2020");
        rtiModels.add(data);
        data = new RtiModel("23456","Delivered","1","Sep 2020");
        rtiModels.add(data);
        data = new RtiModel("23456","Delivered","1","Sep 2020");
        rtiModels.add(data);
        data = new RtiModel("23456","Delivered","1","Sep 2020");
        rtiModels.add(data);



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MyRtiViewModel.class);

        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {

    }
}
