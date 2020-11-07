package com.example.sendrti.ui.Dashboard.SafeDetails;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.sendrti.R;
import com.example.sendrti.ui.Dashboard.SafeDetails.safepayemtssubfragment.Safedetailssubfragment;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class SafeDetails extends Fragment implements  View.OnClickListener{

    public SafeDetailsViewModel safeDetailsViewModel;
    public CheckBox checkBoxemail,checkboxphone;
    public TextView cost,savepayments,clickme;
    public FrameLayout frameLayout;


    public static SafeDetails newInstance() {
        return new SafeDetails();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_safe_details, container, false);
        getId(view);

        checkBoxemail.setOnClickListener(this);
        checkboxphone.setOnClickListener(this);

       // int selectedId = radioGroupemail.getCheckedRadioButtonId();


        return view;

    }

    private void getId(View view) {
        checkBoxemail = view.findViewById(R.id.checkboxbyemail);
        cost = view.findViewById(R.id.cost);
        clickme = view.findViewById(R.id.clickme);
        savepayments = view.findViewById(R.id.savepayemts);
        checkboxphone = view.findViewById(R.id.checkboxphone);
        frameLayout = view.findViewById(R.id.framelayout);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        // TODO: Use the ViewModel
        super.onActivityCreated(savedInstanceState);
       // safeDetailsViewModel = ViewModelProviders.of(this).get(SafeDetailsViewModel)
        safeDetailsViewModel = ViewModelProviders.of(this).get(SafeDetailsViewModel.class);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.checkboxbyemail:
                boolean checked = ((CheckBox) v).isChecked();
                if(checked) {
                    cost.setText("Rs 299");
                    clickme.setVisibility(View.GONE);
                    savepayments.setVisibility(View.GONE);
                    frameLayout.setVisibility(View.VISIBLE);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.framelayout, new Safedetailssubfragment());
                    transaction.addToBackStack(null);
                    transaction.commit();

                }
                else
                {

                    cost.setText("Rs 0");
                    frameLayout.setVisibility(View.GONE);


                }

                break;

            case R.id.checkboxphone:

                boolean checked2 = ((CheckBox) v).isChecked();
                if(checked2) {

                    cost.setText("Rs 499");
                    frameLayout.setVisibility(View.VISIBLE);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.framelayout, new Safedetailssubfragment());
                    transaction.addToBackStack(null);
                    transaction.commit();

                }
                else
                {

                    cost.setText("Rs 0");
                    frameLayout.setVisibility(View.GONE);

                }

                break;
        }

    }
}
