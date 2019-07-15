package com.polotechnologies.alc40phase1;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class AboutALCActivity extends AppCompatActivity {

    WebView aboutALCWebView;
    ProgressBar aboutALCProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        aboutALCWebView = findViewById(R.id.about_alc_web_view);
        aboutALCProgressBar = findViewById(R.id.progressBarAboutALC);

        aboutALCWebView.animate();
        WebSettings webSettings  = aboutALCWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);

        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setSupportZoom(true);

        webSettings.setAppCacheEnabled(true);
        webSettings.setDatabaseEnabled(true);

        aboutALCWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){
                aboutALCProgressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Log.d("Failure Url :" , failingUrl);
                Log.d("Failure Url :" , description);

            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                Log.d("Ssl Error:",handler.toString() + "error:" +  error);
                handler.proceed();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                Toast.makeText(AboutALCActivity.this, "End of Page", Toast.LENGTH_SHORT).show();
            }
        });

        aboutALCWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                aboutALCProgressBar.setProgress(newProgress);
                if(newProgress==100){
                    aboutALCProgressBar.setVisibility(View.GONE);
                }
            }


        });
        aboutALCWebView.loadUrl("https://andela.com/alc/");

    }

}
