package com.example.sendrti.PaymentGateway;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sendrti.R;

public class PaymentGateway extends Fragment {

    private PaymentGatewayViewModel mViewModel;

    public static PaymentGateway newInstance() {
        return new PaymentGateway();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View View = inflater.inflate(R.layout.payment_gateway_fragment, container, false);
        return View ;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PaymentGatewayViewModel.class);
        // TODO: Use the ViewModel
    }

}
