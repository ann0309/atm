package com.example.atm;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.atm.databinding.ActivityMainBinding;

import android.util.Log;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    boolean logon=false;
    private static final int REQUESTLOGIN=100;//static final ,使用大寫 之後不希望他改變值

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(!logon){
            Intent intent=new Intent(this,LoginActivity.class);
            launcher.launch(intent);
//            startActivity(intent);//若使用這個，岸上一頁一樣會回到登入畫面
        }
        getSharedPreferences("atm", MODE_PRIVATE);
    }
ActivityResultLauncher <Intent> launcher=registerForActivityResult(//取代先前的startActivityResult
        new ActivityResultContracts.StartActivityForResult(),
        new ActivityResultCallback<ActivityResult>() {
            @Override//複寫 control＋o  有複寫跟沒付寫一樣？
            public void onActivityResult(ActivityResult result) {//從loginactivity到MainActivity時會呼叫這個
                if(result.getResultCode()==RESULT_OK){//如果正常登入

//輸入logd +tab
                }
            }
        }
);


}