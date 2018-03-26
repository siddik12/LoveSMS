package com.rockscoder.lovesms;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    String appsTitle;
    String packageName;
    static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.packageName = getApplication().getPackageName();
        this.appsTitle = getApplication().getString(R.string.app_name);
        adsInit();
        initInterstitial();

    }

    public void adsInit(){
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                mAdView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                mAdView.setVisibility(View.GONE);
            }
        });
    }

    public void share(View view) {
        Intent share = new Intent("android.intent.action.SEND");
        share.setType("text/plain");
        share.putExtra("android.intent.extra.SUBJECT", this.appsTitle);
        share.putExtra("android.intent.extra.TEXT", this.appsTitle + " - এপ্সটি ডাউনলোড করতে নিচের লিংকে যান\n\n" + ("https://play.google.com/store/apps/details?id=" + this.packageName));
        startActivity(Intent.createChooser(share, "শেয়ার করুন"));
    }

    public void rateUs(View view) {
        Intent intent;
        try {
            intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=" + MainActivity.this.packageName));
            MainActivity.this.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://play.google.com/store/apps/developer?id=" + MainActivity.this.packageName));
            MainActivity.this.startActivity(intent);
        }
    }

    public void moreApps(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://play.google.com/store/apps/developer?id=AppsRocks"));
        MainActivity.this.startActivity(intent);
    }

    public void startApp(View view) {

        showInterstitial();

    }

    private void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and restart the activity.
        if (mInterstitialAd != null && mInterstitialAd.isLoaded() && count % 10 == 1) {
            mInterstitialAd.show();
        } else {
            openApp();
        }
    }

    public void openApp(){
        if (!mInterstitialAd.isLoading() && !mInterstitialAd.isLoaded()) {
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
        }
        Intent intent = new Intent(MainActivity.this,MessageActivity.class);
        startActivity(intent);
        count++;
    }



    private void initInterstitial(){
        MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        mInterstitialAd.setAdListener(new AdListener() {

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

            @Override
            public void onAdClosed() {
                openApp();
            }

        });


    }

}
