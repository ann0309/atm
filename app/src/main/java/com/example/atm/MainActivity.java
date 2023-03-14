package com.example.atm;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atm.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private View inflater;
    boolean logon = false;
    private List<Function> functions;
    //    private String[] functions= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (!logon) {
            Intent intent = new Intent(this, LoginActivity.class);
            launcher.launch(intent);
        }
        getSharedPreferences("atm", MODE_PRIVATE);


        //設定recycleView需要顯示的資料
        setupFunctions();


//      Recycleview（viewholder，也就是放要顯示資料的地方）---------------------------------------------------------
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);                                   //設定固定大小
//        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //設定recycleView的顯示樣式
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        //定義adapter
//        RecycleViewAdapter adapter=new RecycleViewAdapter(this);//建立物件時會去呼叫建構子
        IconAdapter adapter = new IconAdapter();
        //將recycleview和adapter關聯起來
        recyclerView.setAdapter(adapter);//給recyclerView一個adapter
//        ------------------------------------------------------------------------------------------------------


    }

    private void setupFunctions() {
        functions = new ArrayList<>();
        String[] funcs = getResources().getStringArray(R.array.functions);  //取得xml中的item
        functions.add(new Function(funcs[0], R.drawable.anya));            //把text和items加入到List中
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
        functions.add(new Function(funcs[16], R.drawable.simpson));
        functions.add(new Function(funcs[17], R.drawable.arxan));
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

    private void itemClicked(Function function) {
        Log.d("logggg", "itemClicked: " + function.getName());
        switch (function.getIcon()) {
            case R.drawable.anya:
                break;
            case R.drawable.arxan:
                break;
            case R.drawable.bear:
                break;
            case R.drawable.simpson:
                break;
        }
    }


    //        LoginActivity轉換至MainActivity-------------------------------------------------------------------------
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(//取代先前的startActivityResult
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override//複寫 control＋o  有複寫跟沒付寫一樣？
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {            //如果正常登入
                    }
                }
            }
    );
//      ------------------------------------------------------------------------------------------------------


}