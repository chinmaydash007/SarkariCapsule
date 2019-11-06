package com.example.sarkaricapsule;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       final ActionBar actionBar=getSupportActionBar();



        setContentView(R.layout.activity_main);
        webView=findViewById(R.id.webview);
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress)
            {
                //Make the bar disappear after URL is loaded, and changes string to Loading...
                actionBar.setTitle("Loading...");

                if(progress == 100)
                    actionBar.setTitle(R.string.app_name);
            }
        });
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://sarkaricapsule.com");
        WebSettings webSettings=webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        webView.clearCache(true);

        webView.reload();
        webView.loadUrl("about:blank");
        webView.loadUrl("https://sarkaricapsule.com");

    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        super.onBackPressed();

    }
}
