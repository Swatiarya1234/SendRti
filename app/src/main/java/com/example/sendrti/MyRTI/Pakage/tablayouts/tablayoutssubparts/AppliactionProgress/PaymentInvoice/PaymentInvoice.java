package com.example.sendrti.MyRTI.Pakage.tablayouts.tablayoutssubparts.AppliactionProgress.PaymentInvoice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sendrti.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentInvoice extends Fragment {

    public PaymentInvoice() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_payment_invoice, container, false);
        return view;
    }
}
