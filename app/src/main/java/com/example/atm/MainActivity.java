package com.example.atm;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atm.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    boolean logon=false;
    private String[] functions= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(!logon){
            Intent intent=new Intent(this,LoginActivity.class);
            launcher.launch(intent);
        }
        getSharedPreferences("atm", MODE_PRIVATE);




//      Recycleview（viewholder，也就是放要顯示資料的地方）---------------------------------------------------------
        RecyclerView recyclerView= findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);                                   //設定固定大小
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //設定recycleView的顯示樣式

        //定義adapter
        RecycleViewAdapter adapter=new RecycleViewAdapter(this);//建立物件時會去呼叫建構子
        //將recycleview和adapter關聯起來
        recyclerView.setAdapter(adapter);//給recyclerView一個adapter
//        ------------------------------------------------------------------------------------------------------


    }



//        LoginActivity轉換至MainActivity-------------------------------------------------------------------------
        ActivityResultLauncher <Intent> launcher=registerForActivityResult(//取代先前的startActivityResult
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override//複寫 control＋o  有複寫跟沒付寫一樣？
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode()==RESULT_OK){            //如果正常登入
        //輸入logd +tab
                        }
            }
        }
        );
//      ------------------------------------------------------------------------------------------------------



}