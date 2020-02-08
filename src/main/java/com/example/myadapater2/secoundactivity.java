package com.example.myadapater2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.language.MainActivity;
import com.example.language.R;
import com.example.language.SplashScreen;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class secoundactivity extends AppCompatActivity {
    WebView webView;
    ProgressBar progressBar;
    InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secoundactivity);

        webView=findViewById(R.id.web);
        progressBar=findViewById(R.id.progress);

        mInterstitialAd = new InterstitialAd(secoundactivity.this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1933566840368745/6717996910");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener()

                                      {
                                          @Override
                                          public void onAdClosed() {
                                              super.onAdClosed();

                                              startActivity(new Intent());

                                          }
                                      }

        );

       // webView.loadUrl("https://www.tutorialspoint.com/cprogramming/index.htm");

        Intent intent = getIntent();
        Intent intent1 = getIntent();
        Intent intent2 = getIntent();
        Intent intent3 = getIntent();
        Intent intent4 = getIntent();
        Intent intent5 = getIntent();
        Intent intent6 = getIntent();
        Intent intent7 = getIntent();
        Intent intent8 = getIntent();
        Intent intent9 = getIntent();
        Intent intent10 = getIntent();
        Intent intent11 = getIntent();

        webView.loadUrl(intent.getStringExtra("c"));
        webView.loadUrl(intent1.getStringExtra("cplus"));
        webView.loadUrl(intent2.getStringExtra("java"));
        webView.loadUrl(intent3.getStringExtra("html"));
        webView.loadUrl(intent4.getStringExtra("css"));
        webView.loadUrl(intent5.getStringExtra("javascript"));
        webView.loadUrl(intent6.getStringExtra("python"));
        webView.loadUrl(intent7.getStringExtra("R_language"));
        webView.loadUrl(intent8.getStringExtra("swift"));
        webView.loadUrl(intent9.getStringExtra("php"));
        webView.loadUrl(intent10.getStringExtra("ccs"));
        webView.loadUrl(intent11.getStringExtra("Rubby"));

        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient()
        {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(newProgress);

                if (newProgress == 100)
                {
                    progressBar.setVisibility(View.GONE);
                }
                super.onProgressChanged(view,newProgress);
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        if(mInterstitialAd.isLoaded())
        {
            mInterstitialAd.show();
        }
        else
        {

        }
        if (webView.canGoBack())
        {
            webView.goBack();
        }
        else
            super.onBackPressed();
    }
}
