package com.example.atm;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class LoginActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private CheckBox remember_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = findViewById(R.id.inputName);
        password = findViewById(R.id.inputPassword);
        remember_input=findViewById(R.id.rem_input);

            //從atm.xml設定檔中讀取資料出來
            //若沒有從檔案中讀到東西，則預設輸入為null
            String remember_user = getSharedPreferences("atm", MODE_PRIVATE)
                    .getString("users", "");
            String remember_password = getSharedPreferences("atm", MODE_PRIVATE)
                    .getString("password", "");
            name.setText(remember_user);
            password.setText(remember_password);




        //找到畫面上登入的按鈕
        Button login = findViewById(R.id.loginbtn);

        //button的點擊監聽事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = name.getText().toString();
                String passwd = password.getText().toString();



          //option+enter來轉型為字串 ,或是用.toString
                if (user.equals("ann")&&passwd.equals("309")) {
                    if(remember_input.isChecked()){
                        //將資料寫進xml設定檔
                        SharedPreferences pref = getSharedPreferences("atm", MODE_PRIVATE);//創建一個SharedPreferences物件
                        //取得編輯器物件
                        pref.edit()
                                .putString("users", name.getText().toString())
                                .putString("password", password.getText().toString())
                                .commit();
                    }
                    Toast.makeText(LoginActivity.this, "登入ya", Toast.LENGTH_SHORT).show();
//                                    setResult(RESULT_OK);//activity內建的方法和常數

                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    //alert dialog登入失敗
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                            builder.setTitle("登入失敗")
                                    .setMessage("是不是忘記了，老娘不讓你登入！")
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
        });
    }
}