package com.rockscoder.lovesms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MessageActivity extends AppCompatActivity {
    private AdView mAdView;
    String appsTitle;
    String packageName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        adsInit();

        init();
    }

    public void init(){
        this.packageName = getApplication().getPackageName();
        this.appsTitle = getApplication().getString(R.string.app_name);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ItemAdapter adapter = new ItemAdapter(Constant.Data.getItemList());
        recyclerView.setAdapter(adapter);
    }

    public void adsInit(){
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("179FC4BC265DDDCA3F6A417898F00B8A").build();
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

    public void shareApp(){
        Intent share = new Intent("android.intent.action.SEND");
        share.setType("text/plain");
        share.putExtra("android.intent.extra.SUBJECT", this.appsTitle);
        share.putExtra("android.intent.extra.TEXT", this.appsTitle + " - এপ্সটি ডাউনলোড করতে নিচের লিংকে যান\n\n" + ("https://play.google.com/store/apps/details?id=" + this.packageName));
        startActivity(Intent.createChooser(share, "শেয়ার করুন"));
    }


}
