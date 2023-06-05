package com.example.atm;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;

import java.lang.ref.WeakReference;


//要獲取context，需要額外定義class及function
//會在app一開始創建時建立
public class atm extends Application {
    private static atm instance;
    private Activity currentActivity=null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initLifeCycle();
    }


    public static atm getInstance() {

        return instance;
    }


    /**
     * 公開方法，外部可通過 MyApplication.getInstance().getCurrentActivity() 獲取到當前最上層的 Activity
     */
    public Activity getCurrentActivity() {
        return currentActivity;
    }





private void initLifeCycle() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                currentActivity = activity;
//                atm.getInstance().setCurrentActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {
                currentActivity = activity;
//                atm.getInstance().setCurrentActivity(activity);
            }

            @Override
            public void onActivityResumed(Activity activity) {
//                atm.getInstance().setCurrentActivity(activity);
            }

            @Override
            public void onActivityPaused(Activity activity) {
//                atm.getInstance().setCurrentActivity(activity);
            }

            @Override
            public void onActivityStopped(Activity activity) {
//                atm.getInstance().setCurrentActivity(activity);
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
//                atm.getInstance().setCurrentActivity(activity);
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
            }
        });
    }

}

