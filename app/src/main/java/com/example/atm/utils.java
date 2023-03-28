package com.example.atm;

import android.content.Context;

import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.io.InputStream;

public class utils {


    //從json檔案中取到字串
    static String getJsonFromAssets(Context context,String fileName){
        String jsonString;
        try{
            InputStream input = context.getAssets().open(fileName);//由assets資料夾中取得json檔案

            int size = input.available();//得到可以讀取的字有多少
            byte[] buffer = new byte[size];//建立一個大小為size的byte型態陣列
            input.read(buffer);
            input.close();

            jsonString = new String(buffer, "UTF-8");

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return jsonString;
    }

    //從url中取到字串
//    getJsonFromUrl(){
//
//    }


}
