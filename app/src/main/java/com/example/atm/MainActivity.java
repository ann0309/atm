package com.example.atm;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atm.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_PERMISSION = 100;
    protected final String PERMISSION_NAME = Manifest.permission.CAMERA;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private View inflater;
    boolean logon = false;
    private List<Function> functions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);








        if (!logon) {
            Intent intent = new Intent(this, LoginActivity.class);
            launcher.launch(intent);
        }
        getSharedPreferences("atm", MODE_PRIVATE);


        //??????recycleView?????????????????????
        setupFunctions();
        //??????RecycleView?????????adapter&RecycleView
        setupRecycleView();


    }




    private void setupRecycleView() {
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);                                   //??????????????????
//        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //??????recycleView???????????????
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        //??????adapter
//        RecycleViewAdapter adapter=new RecycleViewAdapter(this);//????????????????????????????????????
        IconAdapter adapter = new IconAdapter();
        //???recycleview???adapter????????????
        recyclerView.setAdapter(adapter);//???recyclerView??????adapter
    }

    private void setupFunctions() {
        functions = new ArrayList<>();
        String[] funcs = getResources().getStringArray(R.array.functions);  //??????xml??????item
        functions.add(new Function(funcs[0], R.drawable.anya));            //???text???items?????????List???
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

    //<>????????????viewHolder??????????????????ViewHolder??????
    public class IconAdapter extends RecyclerView.Adapter<IconAdapter.IconHolder> {


        @NonNull
        @Override
        public IconHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                ???MainActivity????????????????????????Layoutinflater???????????????getLayoutInflater??????
            View view = getLayoutInflater().inflate(R.layout.item_icon, parent, false);
            return new IconHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull IconHolder holder, int position) {
//                ?????????????????????????????????
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


        //IconHolder?????????????????????RecycleView
        public class IconHolder extends RecyclerView.ViewHolder {
            ImageView iconImage;
            TextView nameText;

            public IconHolder(@NonNull View itemView) {//itemView????????????holder???????????????????????????
                super(itemView);
                iconImage = itemView.findViewById(R.id.itemIcon);
                nameText = itemView.findViewById(R.id.itemName);
            }
        }

    }

    private void itemClicked(Function function) {

        switch (function.getName()) {
            case "????????????":
                break;
            case "????????????":
                break;
            case "????????????":
                break;
            case "??????????????????":
                break;
            case "webview":
                break;
            case "guard??????":
                break;
            case "?????????":
                break;
            case "?????????"://?????????
                break;
            case "?????????"://??????
                break;
            case "????????????":
//                Log.d("logggg", "itemClicked: " + function.getName());
                Intent intent=new Intent();
                startActivity(intent);
                checkPermission();
                break;
        }
    }

    //????????????????????????
    private void checkPermission() {
        int permission=ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        //???????????????????????????
        if(permission== PackageManager.PERMISSION_GRANTED){//PERMISSION_GRANTED?????????????????????
            //??????????????????
            Toast.makeText(this, "?????????????????????", Toast.LENGTH_SHORT).show();
        }
        else {//?????????????????????
            //????????????
            requestPermissions(new String[] { PERMISSION_NAME }, REQUEST_PERMISSION);
        }
    }


    //        LoginActivity?????????MainActivity-------------------------------------------------------------------------
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(//???????????????startActivityResult
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override//?????? control???o  ??????????????????????????????
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {            //??????????????????
                    }
                }
            }
    );



}