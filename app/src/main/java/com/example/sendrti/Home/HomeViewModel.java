package com.example.sendrti.Home;

import android.view.View;

import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.sendrti.R;

public class HomeViewModel extends ViewModel {

    //On click listner
    public void naviagteApply(View view){
        Navigation.findNavController(view).navigate(R.id.action_Apply);
    }
    public void naviagteTrack(View view){
        Navigation.findNavController(view).navigate(R.id.action_Track2);
    }
    public  void naviagtecontactus(View view){
        Navigation.findNavController(view).navigate(R.id.action_contact);
    }
    public void navigatehelp(View view){
        Navigation.findNavController(view).navigate(R.id.action_help);
    }


    // TODO: Implement the ViewModel
}
