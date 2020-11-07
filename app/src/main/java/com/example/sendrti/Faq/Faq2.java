package com.example.sendrti.Faq;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.sendrti.R;

public class Faq2 extends Fragment implements View.OnClickListener {

    //later remove the class name
    private Faq2ViewModel mViewModel;
    private TextView getView;
    private ToggleButton plusbutton, Plusbutton2, plusbutton3, plusbutton4, plusbutton5;
    private TextView textView, textView2, textView3, textView4;

    public static Faq2 newInstance() {
        return new Faq2();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.faq2_fragment, container, false);
        getview(view);
        plusbutton.setOnClickListener(this);
        Plusbutton2.setOnClickListener(this);
        //    Plusbutton3.setOnClickListener(this);
        plusbutton3.setOnClickListener(this);
        plusbutton4.setOnClickListener(this);
        return view;
    }

    private void getview(View view) {

        plusbutton = view.findViewById(R.id.imagebtn);
        Plusbutton2 = view.findViewById(R.id.togglebutton2);
        // Plusbutton3 = view.findViewById(R.id.imagebtn2);
        plusbutton3 = view.findViewById(R.id.imagebtn2);
        plusbutton4 = view.findViewById(R.id.togglebtn7);
        textView = view.findViewById(R.id.plustext1);
        textView2 = view.findViewById(R.id.plustext2);
        textView3 = view.findViewById(R.id.plustext4);
        textView4 = view.findViewById(R.id.plustext9);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(Faq2ViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imagebtn:
                if (((ToggleButton) v).isChecked()) {
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("RTI stands for Right to Information which empowers every citizen to seek any information from the Government.");
                } else {
                    textView.setVisibility(View.GONE);
                }
                break;
            case R.id.togglebutton2:
                if (((ToggleButton) v).isChecked()) {
                    textView2.setVisibility(View.VISIBLE);
                    textView2.setText("The list of such information is very long but below are few examples which people usually ask under RTI:- 1. Students generally ask to provide them copies of answer sheets from any exam conducting board (Eg: GATE, IIM, UPSC etc) 2. People ask for status of passport, driving license, ration card, aadhar card applications 3. People ask about PF withdrawl and transfer status 4. Few people asked about Pension and IT refund status 5. Students sometimes apply for RTI to know whether a college or course is UGC Approved or not 6. People ask about MP/MLA fund usage and Gram Panchayat expenditure details");
                } else {
                    textView2.setVisibility(View.GONE);
                }
                break;

            case R.id.imagebtn2:

                if (((ToggleButton) v).isChecked()) {
                    textView3.setVisibility(View.VISIBLE);
                    textView3.setText("Sendrti.com is an online service for filing RTI application without any hassle. We draft your application as per the rules, find the correct PIO address, pay the fees using IPO or Demand Draft and send the application using speed post for you.");
                } else {
                    textView3.setVisibility(View.GONE);
                }
                break;

            case R.id.togglebtn7:

                if (((ToggleButton) v).isChecked()) {
                    textView4.setVisibility(View.VISIBLE);
                    textView4.setText("We will send you the registered post tracking link along with the soft copy of your application. As your application goes through different stages in our drafting process, you will get the notification of the progress through text messages and E-mails.");
                } else {
                    textView4.setVisibility(View.GONE);
                }
                break;

//            case R.id.togglebtn7:
//
//                if(((ToggleButton) v).isChecked()){
//                    textView4.setVisibility(View.VISIBLE);
//                    textView4.setText("We will send you the registered post tracking link along with the soft copy of your application. As your application goes through different stages in our drafting process, you will get the notification of the progress through text messages and E-mails.");
//                }
//                else {
//                    textView4.setVisibility(View.GONE);
//                }
//                break;

        }
    }
}
