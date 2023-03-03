package com.example.atm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = findViewById(R.id.inputName);
        password = findViewById(R.id.inputPassword);

        //找到畫面上登入的按鈕
        Button login = findViewById(R.id.loginbtn);

        //button的點擊監聽事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = name.getText().toString();

                if ("Ann".equals(user)) {
                    //返回Mainactivity的onActivityResult
                    setResult(RESULT_OK);//activity內建的方法和常數
                    finish();
                }
            }


        });

    }
}