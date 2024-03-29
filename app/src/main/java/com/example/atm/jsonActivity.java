package com.example.atm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class jsonActivity extends AppCompatActivity {
    //設定ListView 資料
    private String[] jsonResult=new String[]{};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        //getJsonFromUrl必須是static
        //沒有建立物件之前，non static的東西並不存在，但是static會一直存在
        try {
            //之後修改為可以顯示多個屬性
            jsonResult= utils.getJsonFromUrl();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //顯示json資料
        ListView jsonListView=findViewById(R.id.jsonListView);
        //建立adapter，把資料放到ListView上面
        ArrayAdapter<String> adapter=
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,jsonResult);
        jsonListView.setAdapter(adapter);





    }


    //將json格式轉存到java物件中
//    public String getGsByFile(){
//        Guardspec gsContent=new Guardspec();
//        //拿到json裡面的資料，存成string
//        String jsonFileString = utils.getJsonFromAssets(getApplicationContext(), "guardspec.json");
//
//        //將取到的json字串，以指定的key拿到其value
//        try{
//            JSONObject jsonObject=new JSONObject(jsonFileString);
//            JSONObject guardsetting  = jsonObject.getJSONObject("guardConfiguration");
//
//            //key只可以是{}下面最外圍的
//            gsContent.setGuardConfiguration(jsonObject.getString("guardConfiguration"));
////            gsContent.setGuardConfiguration(guardsetting.getString("annotationEncryption"));
////            Log.d("loggggg",gsContent.guardConfiguration);
//
//        }catch (Exception e){
//            //印出錯誤訊息
//            e.printStackTrace();
//        }
//        return gsContent.guardConfiguration;
//    }
}