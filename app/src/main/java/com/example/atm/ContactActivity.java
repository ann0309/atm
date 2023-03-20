package com.example.atm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class ContactActivity extends AppCompatActivity {

    private static final int REQUEST_CONTACTS = 80;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        int permission= ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
        if(permission== PackageManager.PERMISSION_GRANTED){
            readContacts();
        }
        else {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},REQUEST_CONTACTS);
        }
    }

    //讀取聯絡人
    private void readContacts() {

    }
}
