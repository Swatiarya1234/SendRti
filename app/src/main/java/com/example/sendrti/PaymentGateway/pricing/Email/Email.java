package com.example.sendrti.PaymentGateway.pricing.Email;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.sendrti.PaymentGateway.pricing.EmailPricing.EmailActivity;
import com.example.sendrti.R;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class Email extends Fragment  implements   View.OnClickListener{

    private EmailViewModel mViewModel;
    private Button paymentbutton;
    final int UPI_PAYMENT = 0;

    public static Email newInstance() {
        return new Email();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.email_fragment, container, false);
        paymentbutton = view.findViewById(R.id.btn_apply);
        paymentbutton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EmailViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_apply:

                Intent intent = new Intent(getContext(),EmailActivity.class);
                startActivity(intent);

//                payUsingUpi("Swati arya", "arya.swati1991@okaxis",
//                        "google payment", "1");

                break;
        }
    }
    public void payUsingUpi(String name, String s, String google_payment, String s1){
//        Uri uri = Uri.parse("upi://pay").buildUpon()
//                .appendQueryParameter("pa", s)
//                .appendQueryParameter("pn", name)
//                //.appendQueryParameter("mc", "")
//                //.appendQueryParameter("tid", "02125412")
//                //.appendQueryParameter("tr", "25584584")
//                .appendQueryParameter("tn", google_payment)
//                .appendQueryParameter("am", s1)
//                .appendQueryParameter("cu", "INR")
//                //.appendQueryParameter("refUrl", "blueapp")
//                .build();
//        Intent upiPayIntent = new Intent(Intent.ACTION_VIEW);
//        upiPayIntent.setData(uri);
//        // will always show a dialog to user to choose an app
//        Intent chooser = Intent.createChooser(upiPayIntent, "Pay with");
//        // check if intent resolves
//        if(null != chooser.resolveActivity(getActivity().getPackageManager())) {
//            startActivityForResult(chooser, UPI_PAYMENT);
//        } else {
//            Toast.makeText(getActivity(),"No UPI app found, please install one to continue",Toast.LENGTH_SHORT).show();
//        }

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        Log.e("main ", "response "+resultCode );
//        /*
//       E/main: response -1
//       E/UPI: onActivityResult: txnId=AXI4a3428ee58654a938811812c72c0df45&responseCode=00&Status=SUCCESS&txnRef=922118921612
//       E/UPIPAY: upiPaymentDataOperation: txnId=AXI4a3428ee58654a938811812c72c0df45&responseCode=00&Status=SUCCESS&txnRef=922118921612
//       E/UPI: payment successfull: 922118921612
//         */
//        switch (requestCode) {
//            case UPI_PAYMENT:
//                if ((RESULT_OK == resultCode) || (resultCode == 11)) {
//                    if (data != null) {
//                        String trxt = data.getStringExtra("response");
//                        Log.e("UPI", "onActivityResult: " + trxt);
//                        ArrayList<String> dataList = new ArrayList<>();
//                        dataList.add(trxt);
//                        upiPaymentDataOperation(dataList);
//                    } else {
//                        Log.e("UPI", "onActivityResult: " + "Return data is null");
//                        ArrayList<String> dataList = new ArrayList<>();
//                        dataList.add("nothing");
//                        upiPaymentDataOperation(dataList);
//                    }
//                } else {
//                    //when user simply back without payment
//                    Log.e("UPI", "onActivityResult: " + "Return data is null");
//                    ArrayList<String> dataList = new ArrayList<>();
//                    dataList.add("nothing");
//                    upiPaymentDataOperation(dataList);
//                }
//                break;
       // }
    }

    private void upiPaymentDataOperation(ArrayList<String> dataList) {
//        if (isConnectionAvailable(getActivity())) {
//            String str = dataList.get(0);
//            Log.e("UPIPAY", "upiPaymentDataOperation: "+str);
//            String paymentCancel = "";
//            if(str == null) str = "discard";
//            String status = "";
//            String approvalRefNo = "";
//            String response[] = str.split("&");
//            for (int i = 0; i < response.length; i++) {
//                String equalStr[] = response[i].split("=");
//                if(equalStr.length >= 2) {
//                    if (equalStr[0].toLowerCase().equals("Status".toLowerCase())) {
//                        status = equalStr[1].toLowerCase();
//                    }
//                    else if (equalStr[0].toLowerCase().equals("ApprovalRefNo".toLowerCase()) || equalStr[0].toLowerCase().equals("txnRef".toLowerCase())) {
//                        approvalRefNo = equalStr[1];
//                    }
//                }
//                else {
//                    paymentCancel = "Payment cancelled by user.";
//                }
//            }
//            if (status.equals("success")) {
//                //Code to handle successful transaction here.
//                Toast.makeText(getActivity(), "Transaction successful.", Toast.LENGTH_SHORT).show();
//                Log.e("UPI", "payment successfull: "+approvalRefNo);
//            }
//            else if("Payment cancelled by user.".equals(paymentCancel)) {
//                Toast.makeText(getActivity(), "Payment cancelled by user.", Toast.LENGTH_SHORT).show();
//                Log.e("UPI", "Cancelled by user: "+approvalRefNo);
//            }
//            else {
//                Toast.makeText(getActivity(), "Transaction failed.Please try again", Toast.LENGTH_SHORT).show();
//                Log.e("UPI", "failed payment: "+approvalRefNo);
//            }
//        } else {
//            Log.e("UPI", "Internet issue: ");
//            Toast.makeText(getActivity(), "Internet connection is not available. Please check and try again", Toast.LENGTH_SHORT).show();
//        }
    }
  //  public static boolean isConnectionAvailable(Context context) {
//        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        if (connectivityManager != null) {
//            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
//            if (netInfo != null && netInfo.isConnected()
//                    && netInfo.isConnectedOrConnecting()
//                    && netInfo.isAvailable()) {
//                return true;
//            }
//        }
//        return false;
    //}
}
