package com.example.atm.arxan;


import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;

import com.example.atm.atm;

public class TamperAction {

    //在app任何地方偵測到異常時的反應動作
    public static void showAlert(String msg) {
        //取得目前所在Activity 的context

        Activity currentActivity = atm.getInstance().getCurrentActivity();

        if(currentActivity!=null){//在mainThread上面執行
            currentActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    new AlertDialog
                            .Builder(currentActivity)
                            .setTitle("Tamper lah!")
                            .setMessage(msg)
                            .setCancelable(false)
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    System.exit(0);
                                }

                            }).create().show();

                }
            });
        }
        else {
            Log.d("loggggg", "currentActivity 為空");
        }

    }
    public static void rdgTamper(){
        showAlert("root detected!!");
    }

    public static void hdgTamper(){
        showAlert("hook detected!!");
    }
    public static void fdgTamper(){
        showAlert("frida detected!!");
    }
    public static void scgTamper(){
        showAlert("signature changed");
    }
    public static void vdgTamper(){
        showAlert("virtualization environment detected!!");
    }
    public static void vcdgTamper(){
        showAlert("virtual control detected!!");
    }
    public static void ddgTamper(){
        showAlert("debugger detected!!");
    }
    public static void edgTamper(){
        showAlert("emulator detected!!");
    }




    //



}
