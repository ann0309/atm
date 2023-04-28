package com.example.atm;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class JsonUtils {
    //存放轉換轉換至string的資料
    static String data="";
    private static String[] result=new String[]{};
    static byte[] byteArray = new byte[1024];

    //從json檔案中取到字串
    static String getJsonFromAssets(Context context,String fileName){
        String jsonString;
        try{
            //由assets資料夾中取得json檔案
            InputStream input = context.getAssets().open(fileName);
            //得到可以讀取的字有多少
            int size = input.available();
            //建立一個大小為size的byte型態陣列
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();

            jsonString = new String(buffer, "UTF-8");

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return jsonString;
    }






    //從url中取到json資料
    public static void getJsonFromUrl(){

        //android不允許網路連線在mainthread執行
        //另外開一個thread做事情
        Thread thread = new Thread(new Runnable() {
            @Override public void run() {
                //json 資料的網址
                String urlString="https://tcgbusfs.blob.core.windows.net/dotapp/youbike/v2/youbike_immediate.json"; //以後用加密連線
                try {
                    URL url=new URL(urlString);
                    //建立和url的連接，尚未連接
                    HttpURLConnection conn=(HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    //開啟連接
                    conn.connect();

                    int responseCode=conn.getResponseCode();
                    Log.d("loggggg", "responseCode: "+ responseCode);

                    if(responseCode==HttpURLConnection.HTTP_OK){
                        InputStream inputStream=conn.getInputStream(); //????



                        //json url轉為String
                        data=convertStreamToString(inputStream);


                        //字串轉JsonObject或JsonArray，並透過key取道value
                        getJsonValue(data);
                        inputStream.close();
                    }
                }//若try裡執行到某一行出錯，會轉至做catch裡的事情
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }

    private static void getJsonValue(String data) {
        //建數個個動態陣列
//        ArrayList location = new ArrayList();
//        ArrayList area = new ArrayList();


        //把result裡面的東西轉成jsonobject
        try {
            //存放轉換成jsonArray和JsonObject的json字串
            JSONArray jsonArray = new JSONArray(data);
//            JSONObject jsonResult=new JSONObject(data);  //因為url格式為array，所以不能用object來做

            //取道json資料的第一筆
            JSONObject row=jsonArray.getJSONObject(0);

            //取道第一筆資料中的一個value
            Log.d("loggggg", "一筆資料：:"+row);

            String ID= row.getString("sno") ;
            String name= row.getString("sna") ;
            String area= row.getString("sarea") ;
            String addr= row.getString("sarea") ;
//            Date updateTime= row.getd("srcUpdateTime");

            Log.d("loggggg", "ID:"+row.getString("sno"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        把已經轉成jsonobject的資料存到YoubikeData裡個別的屬性
//                將個別的屬性存到動態陣列裡
    }


    //InputStream(Json Url資料) 轉string陣列
    //資料為JsonArray形式，數組
    //JsonArray裡有很多個JsonObject
    static String convertStreamToString(InputStream is) {

        //記錄buffer的長度
        int len= 0;

        //建立ByteArrayOutputStream
        ByteArrayOutputStream result = new ByteArrayOutputStream();

        //建立一個1024byte的陣列
        byte[] buffer = new byte[1024];
        try {
            //若讀到沒有更多資料了（-1）
            while ((len=is.read(buffer,0,buffer.length))!=-1){
                result.write(buffer,0,len);
            }
            //轉為位元陣列再轉字串
            data=new String(result.toByteArray(),"UTF-8" );
        } catch (IOException e) {
            e.printStackTrace();
        }



        return data;
    }}

