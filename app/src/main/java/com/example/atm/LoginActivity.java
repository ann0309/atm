package com.example.atm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = findViewById(R.id.inputName);
        password = findViewById(R.id.inputPassword);



        //從atm.xml設定檔中讀取資料出來
        String remember_user= getSharedPreferences("atm", MODE_PRIVATE)
                .getString("users","");
        String remember_password= getSharedPreferences("atm", MODE_PRIVATE)
                .getString("password","");
        name.setText(remember_user);
        password.setText(remember_password);

        //找到畫面上登入的按鈕
        Button loginbtn = findViewById(R.id.loginbtn);
        //button的點擊監聽事件
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = name.getText().toString();
                String passwd = password.getText().toString();
                //使用fb要連網路
                //返回Mainactivity的onActivityResult
                FirebaseDatabase.getInstance().getReference("users").child("ann").child("password")//取道firebase中，user下得ann的password值
                        .addListenerForSingleValueEvent(new ValueEventListener() {//addListenerForSingleValueEvent括號裡面叫做匿名類別
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                String pw = snapshot.getValue().toString();//option+enter來轉型為字串 ,或是用.toString

                                if (pw.equals(password.getText().toString())) {
                                    //寫入user
                                    Toast.makeText(LoginActivity.this, "登入成功", Toast.LENGTH_SHORT).show();

                                    //將資料寫進xml設定檔
                                    //創建一個SharedPreferences物件
                                    SharedPreferences pref = getSharedPreferences("atm", MODE_PRIVATE);
                                    //取得編輯器物件
                                    pref.edit()
                                            .putString("users",name.getText().toString())
                                            .putString("password",password.getText().toString())
                                            .commit();

                                    setResult(RESULT_OK);//activity內建的方法和常數
                                    finish();
                                } else {
                                    //alert dialog登入失敗
                                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                    builder.setTitle("登入失敗")
                                            .setMessage("是不是忘記了")
                                            .setPositiveButton("是", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    //關閉這個提示框
                                                    dialog.dismiss();
                                                }
                                            })
                                            .create().show();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });//從fb上讀取資料
                //listenetr是一個介面

            }


        });

    }
}