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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PermissionActivity extends AppCompatActivity {
    protected final String PERMISSION_CAMERA = Manifest.permission.CAMERA;
    protected final String PERMISSION_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    protected final String PERMISSION_FILE = Manifest.permission.READ_EXTERNAL_STORAGE;     //讀取外部儲存空間
    protected final String PERMISSION_BLUETOOTH = Manifest.permission.BLUETOOTH;
    protected final String PERMISSION_INTERNET = Manifest.permission.INTERNET;
    private static final int REQUEST_PERMISSION = 100;
    TextView showResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);


        int[] checkList ={R.id.location,R.id.file,R.id.camera,R.id.bluetooth,R.id.internet};


        Button checkAll=findViewById(R.id.checkAll);

        checkAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean[] result={false,false,false,false,false};


                //迴圈存入勾選結果  打勾 沒打勾 全部都沒勾
                for(int i=0;i<checkList.length;i++){
                    CheckBox checkItem = findViewById(checkList[i]);

                    //判斷是否都沒勾選
                    if(checkItem.isChecked()){
                        result[i]=true;
                    }

                    if(result[i]==true){
                        getPermission(v,i,checkList[i],checkList);
                    }
                }

                //若全部都沒勾選
                if(result[0]==false&&result[1]==false&&result[2]==false&&result[3]==false&&result[4]==false){
                    showResult=findViewById(R.id.permission_result);
                    showResult.append("沒有打勾勾喔\n");
                }
            }
        });



    }

    private void getPermission(View view,int i,int checkedId,int[] checkList) {
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
                ScrollView scrollView=findViewById(R.id.scrollView);

//                TextView showResult=findViewById(R.id.permission_result);
                showResult=findViewById(R.id.permission_result);

                    switch (checkedId){
                        case R.id.internet:
                            showResult.append("已取得網路權限\n");
                            break;
                        case R.id.file:
                            showResult.append("已取得檔案權限\n");
                            break;
                        case R.id.location:
                            showResult.append("已取得位置權限\n");
                            break;
                        case R.id.camera:
                            showResult.append("已取得相機權限\n");
                            break;
                        case R.id.bluetooth:
                            showResult.append("已取得藍芽權限\n");
                            break;
                    }
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);

                //將權限取得結果顯示在畫面上


            }
            else {
                requestPermissions(new String[] { permissionList[i] }, REQUEST_PERMISSION);
            }

    }

}