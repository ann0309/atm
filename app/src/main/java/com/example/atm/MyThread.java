//Thread
//需要用這裡的Thread的時候： thread.start()


package com.example.atm;

import static com.example.atm.JsonUtils.convertStreamToString;
import static com.example.atm.JsonUtils.data;
import static com.example.atm.JsonUtils.returnData;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class MyThread implements Runnable {


    private String[] result;

    // 在這裡執行需要在線程中完成的工作
    public void run() {
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

                //getJsonValue回傳陣列
                returnData=JsonUtils.getJsonValue(data);
                Log.d("loggggg", "returnData: "+returnData);


                inputStream.close();
            }
        }
        //若try裡執行到某一行出錯，會轉至做catch裡的事情
        catch (IOException e) {
            e.printStackTrace();
        }

        // 設置返回值
        result = returnData;
    }


    //透過此function從其他class取得thread的回傳值
    public String[] getResult() {
        return result;
    }
}



