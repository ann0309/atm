package com.example.atm;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;


public class WebViewActivity extends AppCompatActivity {
    public static WebView web_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        web_view = findViewById(R.id.webview);
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.loadUrl("https://www.tutorialspoint.com/get-the-size-of-an-arraylist-in-java");


    }
    public void onBackPressed() {
        if (web_view.canGoBack()) {
            web_view.goBack();
            return;
        }
        super.onBackPressed();//為什麼不加這行就不能返回？
    }
}