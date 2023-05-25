package com.example.atm;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;


public class utils {
    //存放轉換轉換至string的資料
    static String data="";


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
    public static String[] getJsonFromUrl() throws InterruptedException {

        // 另外開一個thread做事情
        // 創建線程並啟動
        MyThread myThread = new MyThread();
        Thread thread_getjson = new Thread(myThread);
        thread_getjson.start();

        // 等待線程執行完成
        thread_getjson.join();

        // 讀取返回值
        String[] result = myThread.getResult();

        return result;
    }

    //InputStream(Json Url資料) 轉字串
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
    }

    //拿到轉換成string型態的json資料後，轉換多筆資料的key的value
    public static ArrayList<HashMap<String, Object>> getJsonValue(String data) {
        //放多筆資料
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

        //把result裡面的東西轉成jsonobject
        try {

            //存放轉換成jsonArray和JsonObject的json字串
            JSONArray jsonArray = new JSONArray(data);
            //JSONObject jsonResult=new JSONObject(data);  //因為url格式為array，所以不能用object來做

            //取道一筆資料中的一個value
            for(int i=0;i<jsonArray.length();i++) {
                //放一筆資料中的多個key
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("id", jsonArray.getJSONObject(i).getString("sno"));
                map.put("name", jsonArray.getJSONObject(i).getString("sna"));
                map.put("area", jsonArray.getJSONObject(i).getString("sarea"));
                map.put("addr", jsonArray.getJSONObject(i).getString("ar"));
                list.add(map);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }






}

