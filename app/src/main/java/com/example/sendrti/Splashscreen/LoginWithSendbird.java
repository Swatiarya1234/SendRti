package com.example.sendrti.Splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sendrti.PrefrenceUtil.PrefrenceUtil;
import com.example.sendrti.PrefrenceUtil.PushUtils2;
import com.example.sendrti.R;
import com.example.sendrti.main.MainActivity;
import com.google.android.material.snackbar.Snackbar;
import com.sendbird.android.SendBird;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.User;

public class LoginWithSendbird extends AppCompatActivity {

    private EditText name;
    private EditText password,email;
    private Button btn;
    private static final String APP_ID ="85EDE223-00FF-44FB-8F32-BFE6D0DE953D";
    private static final int RC_SIGN_IN=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_bird);
        password = findViewById(R.id.password);
        name = findViewById(R.id.username);
        email = findViewById(R.id.email);
        btn = findViewById(R.id.sendbird);
        SendBird.init(APP_ID,getApplicationContext());
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View v) {
                if(!(email.getText().toString().equals("") && name.getText().toString().equals("") && password.getText().toString().equals(""))){

                    PrefrenceUtil.setUserId(email.getText().toString());
                    PrefrenceUtil.setNickname(name.getText().toString());
                    connectToSendBird(email.getText().toString(), name.getText().toString());
                }
                else
                {
                    Toast.makeText(getApplication(),"please enter the details",Toast.LENGTH_SHORT).show();
                }
            }
        });
        name.setSelectAllOnFocus(true);
        email.setSelectAllOnFocus(true);
    }

    private void connectToSendBird(final String userId, final String userNickname) {
        if (TextUtils.isEmpty(userId) || TextUtils.isEmpty(userNickname)) {
            return;
        }
        // Show the loading indicator
        showProgressBar(true);
        ConnectionManager.login(userId, new SendBird.ConnectHandler() {
            @Override
            public void onConnected(User user, SendBirdException e) {
                // Callback received; hide the progress bar.
                showProgressBar(false);

                if (e != null) {
                    // Error!
                    Toast.makeText(
                            getApplicationContext(), "Login to SendBird failed" + e.getCode() + ": " + e.getMessage(),
                            Toast.LENGTH_SHORT)
                            .show();

                    // Show login failure snackbar
                    showSnackbar("Login to SendBird failed");
                    return;
                }

                   PrefrenceUtil.setConnected(true);

                // Update the user's nickname
                  updateCurrentUserInfo(userNickname);
                //PushUtils2.registerPushHandler(new MyFirebaseMessagingService());
                 Intent intent = new Intent(getApplication(), MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("key", "Sendbirdtype");
                bundle.putString("nickname",userNickname);
                bundle.putString("email",userId);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }
        });
    }

    private void showSnackbar(String login_to_sendBird_failed) {
//        Snackbar snackbar = Snackbar.make(mLoginLayout, login_to_sendBird_failed, Snackbar.LENGTH_SHORT);
//        snackbar.show();
    }

    private void updateCurrentUserInfo(final String userNickname) {
        SendBird.updateCurrentUserInfo(userNickname, null, new SendBird.UserInfoUpdateHandler() {
            @Override
            public void onUpdated(SendBirdException e) {
                if (e != null) {
                    // Error!
                    Toast.makeText(
                            getApplication(), "" + e.getCode() + ":" + e.getMessage(),
                            Toast.LENGTH_SHORT)
                            .show();

                    // Show update failed snackbar
                    showSnackbar("Update user nickname failed");

                    return;
                }

                PrefrenceUtil.setNickname(userNickname);
            }
        });
    }
    private void showProgressBar(boolean show) {
        if (show) {
            WaitingDialog.show(this);
        } else {
            WaitingDialog.dismiss();
        }
    }
}
