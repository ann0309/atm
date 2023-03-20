package com.example.atm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PermissionActivity extends AppCompatActivity {
    protected final String PERMISSION_CAMERA = Manifest.permission.CAMERA;
    protected final String PERMISSION_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    protected final String PERMISSION_FILE = Manifest.permission.READ_EXTERNAL_STORAGE; //讀取外部儲存空間
    protected final String PERMISSION_BLUETOOTH = Manifest.permission.BLUETOOTH;
    protected final String PERMISSION_INTERNET = Manifest.permission.INTERNET;
    private static final int REQUEST_PERMISSION = 100;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        int[] checkList ={R.id.location,R.id.file,R.id.camera,R.id.bluetooth,R.id.internet};


        Button checkAll=findViewById(R.id.checkAll);

        checkAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //迴圈檢查checkbox是否有勾選
                for(int i=0;i<checkList.length;i++){
                    CheckBox checkItem = findViewById(checkList[i]);

                    // 若有被選取
                    if(checkItem.isChecked())
                        getPermission(v,i,checkList[i]);
                }
            }
        });
    }

    private void getPermission(View view,int i,int checkedId) {
        String[] permissionList={PERMISSION_LOCATION,PERMISSION_FILE,PERMISSION_CAMERA,PERMISSION_BLUETOOTH,PERMISSION_INTERNET};
            int permission=0;

                //根據勾選的項目，放入相對應要獲取的權限
                switch (checkedId){
                    case R.id.internet:
                        permission= ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);
                        break;
                    case R.id.file:
                        permission= ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
                        break;
                    case R.id.location:
                        permission= ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
                        break;
                    case R.id.camera:
                        permission= ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
                        break;
                    case R.id.bluetooth:
                        permission= ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH);
                        break;
                }

            //若已取得權限
            if(permission==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(PermissionActivity.this,"已取得權限",Toast.LENGTH_SHORT).show();

                //將權限取得結果顯示在畫面上


            }
            else {
                requestPermissions(new String[] { permissionList[i] }, REQUEST_PERMISSION);
            }

    }

}