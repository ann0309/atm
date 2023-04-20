package com.example.atm;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atm.databinding.ActivityMainBinding;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private View inflater;
    boolean logon = false;
    private List<Function> functions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        if (!logon) {
//            Intent intent = new Intent(this, LoginActivity.class);
//            launcher.launch(intent);
//        }
        getSharedPreferences("atm", MODE_PRIVATE);



        setupFunctions();
        //建置RecycleView，連接adapter&RecycleView
        setupRecycleView();


    }

//    private FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);


    //建立RecycleView
    private void setupRecycleView() {
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);                                   //設定固定大小
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));//設定recycleView的顯示樣式
        //定義adapter
//        RecycleViewAdapter adapter=new RecycleViewAdapter(this);//建立物件時會去呼叫建構子
        IconAdapter adapter = new IconAdapter();

        //將recycleview和adapter關聯起來
        recyclerView.setAdapter(adapter);//給recyclerView一個adapter
    }



    //設定recycleView需要顯示的資料
    private void setupFunctions() {
        functions = new ArrayList<>();
        String[] funcs = getResources().getStringArray(R.array.functions);  //取得xml中的item
        functions.add(new Function(funcs[0], R.drawable.anya));            //把text和icon加入到List中
        functions.add(new Function(funcs[1], R.drawable.bear));
        functions.add(new Function(funcs[2], R.drawable.chicken));
        functions.add(new Function(funcs[3], R.drawable.oyster));
        functions.add(new Function(funcs[4], R.drawable.simpson));
        functions.add(new Function(funcs[5], R.drawable.arxan));
        functions.add(new Function(funcs[6], R.drawable.oyster));
        functions.add(new Function(funcs[7], R.drawable.simpson));
        functions.add(new Function(funcs[8], R.drawable.arxan));
        functions.add(new Function(funcs[9], R.drawable.oyster));
        functions.add(new Function(funcs[10], R.drawable.simpson));
        functions.add(new Function(funcs[11], R.drawable.arxan));
        functions.add(new Function(funcs[12], R.drawable.anya));
        functions.add(new Function(funcs[13], R.drawable.bear));
        functions.add(new Function(funcs[14], R.drawable.chicken));
        functions.add(new Function(funcs[15], R.drawable.oyster));
//        functions.add(new Function(funcs[16], R.drawable.simpson));
//        functions.add(new Function(funcs[17], R.drawable.arxan));
    }

    //<>裡面要的viewHolder是自己定義的ViewHolder名稱
    public class IconAdapter extends RecyclerView.Adapter<IconAdapter.IconHolder> {

        @NonNull
        @Override
        public IconHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                在MainActivity裡面不需要在呼叫Layoutinflater，直接呼叫getLayoutInflater即可
            View view = getLayoutInflater().inflate(R.layout.item_icon, parent, false);
            return new IconHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull IconHolder holder, int position) {
//                一格裡面要顯示什麼東西
            Function function = functions.get(position);
            holder.nameText.setText(function.getName());
            holder.iconImage.setImageResource(function.getIcon());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClicked(function);
                }
            });
        }

        @Override
        public int getItemCount() {
            return functions.size();
        }


        //IconHolder是我自己定義的RecycleView
        public class IconHolder extends RecyclerView.ViewHolder {
            ImageView iconImage;
            TextView nameText;

            public IconHolder(@NonNull View itemView) {//itemView想像他是holder裡面的其中一個東西
                super(itemView);
                iconImage = itemView.findViewById(R.id.itemIcon);
                nameText = itemView.findViewById(R.id.itemName);
            }
        }

    }

    //按下icon會做什麼事
    private void itemClicked(Function function) {

        switch (function.getName()) {
            case "交易紀錄":
                break;
            case "餘額查詢":
                break;
            case "投資理財":
                break;
            case "網路連接測試":
                break;
            case "webview":
                Intent webviewIntent=new Intent(this,WebViewActivity.class);
                startActivity(webviewIntent);
                break;
            case "guard開關":
                break;
            case "小工具":
                break;
            case "加密累":
                break;
            case "框架???":
                break;
            case "firebase crashlytics":
                Intent firebaseIntent=new Intent(this,FirebaseActivity.class);
                startActivity(firebaseIntent);
                break;
            case "危險權限":
                //透過Intent轉換至其他activity
                Intent permissionIntent=new Intent(this,PermissionActivity.class);
                startActivity(permissionIntent);
                break;
            case "json解析":
                Intent jsonIntent=new Intent(this,jsonActivity.class);
                startActivity(jsonIntent);
                break;
        }
    }




    //onActivityResult是指跳轉回來此activity時，intent會帶result資料回來
    //onActivityResult沒有跳轉的功能
    //一開始初始為MainActivity, 如果發現沒有登入，才跳轉到LoginActivity
    //登入完後跳轉到MainActivity
    //但是現在初始activity為loginActivity，登入後直接到MainActovity
    //所以不需要攜帶資料


//    ActivityResultLauncher<Intent> launcher = registerForActivityResult(//取代先前的startActivityResult
//            new ActivityResultContracts.StartActivityForResult(),
//            new ActivityResultCallback<ActivityResult>() {
//                @Override//複寫 control＋o  有複寫跟沒付寫一樣？
//                public void onActivityResult(ActivityResult result) {
//                    //如果正常登入
//                    if (result.getResultCode() == RESULT_OK) {
//                    }
//                    else{//如果登入不成功，按下返回鍵會結束當前activity
//                        finish();
////                        MainActivity.this.onDestroy();//閃退
////                        System.exit(0);
//                    }
//                }
//            }
//    );



}