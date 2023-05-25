package com.example.atm;

import android.app.Activity;
import android.app.Application;


//要獲取context，需要額外定義class及function
//會在app一開始創建時建立
public class atm extends Application {
    private static atm instance;
    private Activity currentActivity;

    public static atm getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    //設置當前的activity
    public void setCurrentActivity(Activity activity) {
        currentActivity = activity;
    }

    //獲取當前的activity
    public Activity getCurrentActivity() {
        return currentActivity;
    }
}

