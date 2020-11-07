package com.example.sendrti.ui.Dashboard.DetailsofRti;

import android.view.View;

import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.sendrti.R;

public class DeatilsofRtiViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    public void previous(View view){
        Navigation.findNavController(view).popBackStack();
    }
    public void next(View view){
        Navigation.findNavController(view).navigate(R.id.action_SafeDeatils);
    }
    public  void answerhseet(View view){
        Navigation.findNavController(view).navigate(R.id.action_answerheet);
    }
    public void marksheet(View view){
        Navigation.findNavController(view).navigate(R.id.action_Marksheet);
    }
    public void passport(View view){
        Navigation.findNavController(view).navigate(R.id.action_passport);
    }

    public void Incometax(View view){
        Navigation.findNavController(view).navigate(R.id.action_Incometax);
    }
    public void firstatus(View view){
        Navigation.findNavController(view).navigate(R.id.action_firstatus);
    }
    public void property(View view) {
        Navigation.findNavController(view).navigate(R.id.action_property);
    }
    public void epf(View view){

        Navigation.findNavController(view).navigate(R.id.action_epf);
    }
    public void pension(View view){

    }
    public void funds(View view){

    }
    public void Realstate(View view){

    }
    public void Road(View view){

    }
    public void Tender(View view){

    }
    public void gram(View view){

    }
    public void mla(View view){

    }
    public void Db(View view){

    }
    public void newRti(View view){

    }



}
