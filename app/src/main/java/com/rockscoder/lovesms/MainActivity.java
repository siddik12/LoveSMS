package com.rockscoder.lovesms;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
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



    public void share(View view) {
        shareApp();
    }

    public void shareApp(){
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

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
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
            mInterstitialAd.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice("179FC4BC265DDDCA3F6A417898F00B8A").build());
        }
        Intent intent = new Intent(MainActivity.this,MessageActivity.class);
        startActivity(intent);
        count++;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.shareButton:
                shareApp();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void adsInit(){
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("179FC4BC265DDDCA3F6A417898F00B8A")
                .build();
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

    private void initInterstitial(){
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));

        mInterstitialAd.setAdListener(new AdListener() {

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                mInterstitialAd.loadAd(new AdRequest.Builder()
                        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                        .addTestDevice("179FC4BC265DDDCA3F6A417898F00B8A")
                        .build());
            }

            @Override
            public void onAdClosed() {
                openApp();
            }

        });


    }

}
