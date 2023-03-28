package com.example.atm;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonUtils {


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
                String urlString="https://apiservice.mol.gov.tw/OdService/rest/datastore/A17000000J-030245-4Ml";//以後需要用加密連線
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

                        String result=convertStreamToString(inputStream);
                        Log.d("loggggg", result);
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

    //InputStream轉string
    static String convertStreamToString(InputStream is) {
        //存放轉換轉換至string的資料
        String data="";

        //建立ByteArrayOutputStream
        ByteArrayOutputStream result = new ByteArrayOutputStream();

        //建立一個1024byte的陣列
        byte[] buffer = new byte[1024];
        try {
            for (int length; (length = is.read(buffer)) != -1; ) {
                result.write(buffer, 0, length);
            }
            data  = result.toString("UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

}
