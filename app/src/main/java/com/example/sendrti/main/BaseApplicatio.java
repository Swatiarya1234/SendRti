package com.example.sendrti.main;

import android.app.Application;

import com.example.sendrti.PrefrenceUtil.PrefrenceUtil;
import com.sendbird.android.SendBird;

public class BaseApplicatio  extends Application {

        private static final String APP_ID = "85EDE223-00FF-44FB-8F32-BFE6D0DE953D"; // US-1 Demo
    public static final String VERSION = "3.0.40";

   
    @Override
    public void onCreate() {
      
        super.onCreate();
        PrefrenceUtil.init(getApplicationContext());

        SendBird.init(APP_ID, getApplicationContext());

        //PushUtils.registerPushHandler(new MyFirebaseMessagingService());
    }


}
