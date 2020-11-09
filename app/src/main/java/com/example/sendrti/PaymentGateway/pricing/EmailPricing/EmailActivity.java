package com.example.sendrti.PaymentGateway.pricing.EmailPricing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sendrti.R;

public class EmailActivity extends AppCompatActivity {


    Button btn_appl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        btn_appl = findViewById(R.id.btn_apply);
        btn_appl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payUsingUpi("Swati arya", "arya.swati1991@okaxis",
                      "google payment", "1");
            }
        });
    }

    private void payUsingUpi(String swati_arya, String s, String google_payment, String s1) {

    }
}
