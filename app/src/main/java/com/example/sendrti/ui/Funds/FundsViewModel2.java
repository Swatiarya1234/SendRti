package com.example.sendrti.ui.Funds;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FundsViewModel2 extends ViewModel {

    private MutableLiveData<String> mText;


    public FundsViewModel2() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
    // TODO: Implement the ViewModel
}
