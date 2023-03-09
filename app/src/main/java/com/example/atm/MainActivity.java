package com.example.atm;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(!logon){
            Intent intent=new Intent(this,LoginActivity.class);
            launcher.launch(intent);
        }
        getSharedPreferences("atm", MODE_PRIVATE);

        //建立一個recycleview（viewholder，也就是放要顯示資料的地方）
        //定義adapter
        //將recycleview和adapter關聯起來



    }
        ActivityResultLauncher <Intent> launcher=registerForActivityResult(//取代先前的startActivityResult
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override//複寫 control＋o  有複寫跟沒付寫一樣？
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode()==RESULT_OK){            //如果正常登入
                            finish();//？？？
        //輸入logd +tab
                        }
            }
        }
);


}