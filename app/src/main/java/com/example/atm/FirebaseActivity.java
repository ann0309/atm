package com.example.atm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FirebaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);





        Button crashButton = new Button(this);
        crashButton.setText("Test Crash");
        crashButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                throw new RuntimeException("Test Crash"); // Force a crash
            }
        });

        addContentView(crashButton, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));


    }
}