package com.rockscoder.lovesms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity {
    private AdView mAdView;
    private MessageAdapter adapter;
    private RecyclerView recyclerView;
    private List<Message> messageList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        mAdView = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        messageList  = new ArrayList<>();

        messageList.add(new Message("এক পৃথিবীতে চেয়েছি তোমাকে, এক সাগর ভালবাসা রয়েছে এ বুকে , যদি কাছে আসতে দাও, যদি ভালবাসতে দাও, এক জনম নয় লক্ষ জনম ভালবাসব তোমাকে.",0,0));
        messageList.add(new Message("এক পৃথিবীতে চেয়েছি তোমাকে, এক সাগর ভালবাসা রয়েছে এ বুকে , যদি কাছে আসতে দাও, যদি ভালবাসতে দাও, এক জনম নয় লক্ষ জনম ভালবাসব তোমাকে.",0,0));
        messageList.add(new Message("এক পৃথিবীতে চেয়েছি তোমাকে, এক সাগর ভালবাসা রয়েছে এ বুকে , যদি কাছে আসতে দাও, যদি ভালবাসতে দাও, এক জনম নয় লক্ষ জনম ভালবাসব তোমাকে.",0,0));
        messageList.add(new Message("এক পৃথিবীতে চেয়েছি তোমাকে, এক সাগর ভালবাসা রয়েছে এ বুকে , যদি কাছে আসতে দাও, যদি ভালবাসতে দাও, এক জনম নয় লক্ষ জনম ভালবাসব তোমাকে.",0,0));
        messageList.add(new Message("এক পৃথিবীতে চেয়েছি তোমাকে, এক সাগর ভালবাসা রয়েছে এ বুকে , যদি কাছে আসতে দাও, যদি ভালবাসতে দাও, এক জনম নয় লক্ষ জনম ভালবাসব তোমাকে.",0,0));
        messageList.add(new Message("এক পৃথিবীতে চেয়েছি তোমাকে, এক সাগর ভালবাসা রয়েছে এ বুকে , যদি কাছে আসতে দাও, যদি ভালবাসতে দাও, এক জনম নয় লক্ষ জনম ভালবাসব তোমাকে.",0,0));
        messageList.add(new Message("এক পৃথিবীতে চেয়েছি তোমাকে, এক সাগর ভালবাসা রয়েছে এ বুকে , যদি কাছে আসতে দাও, যদি ভালবাসতে দাও, এক জনম নয় লক্ষ জনম ভালবাসব তোমাকে.",0,0));
        messageList.add(new Message("এক পৃথিবীতে চেয়েছি তোমাকে, এক সাগর ভালবাসা রয়েছে এ বুকে , যদি কাছে আসতে দাও, যদি ভালবাসতে দাও, এক জনম নয় লক্ষ জনম ভালবাসব তোমাকে.",0,0));
        messageList.add(new Message("এক পৃথিবীতে চেয়েছি তোমাকে, এক সাগর ভালবাসা রয়েছে এ বুকে , যদি কাছে আসতে দাও, যদি ভালবাসতে দাও, এক জনম নয় লক্ষ জনম ভালবাসব তোমাকে.",0,0));
        messageList.add(new Message("এক পৃথিবীতে চেয়েছি তোমাকে, এক সাগর ভালবাসা রয়েছে এ বুকে , যদি কাছে আসতে দাও, যদি ভালবাসতে দাও, এক জনম নয় লক্ষ জনম ভালবাসব তোমাকে.",0,0));
        messageList.add(new Message("এক পৃথিবীতে চেয়েছি তোমাকে, এক সাগর ভালবাসা রয়েছে এ বুকে , যদি কাছে আসতে দাও, যদি ভালবাসতে দাও, এক জনম নয় লক্ষ জনম ভালবাসব তোমাকে.",0,0));
        messageList.add(new Message("এক পৃথিবীতে চেয়েছি তোমাকে, এক সাগর ভালবাসা রয়েছে এ বুকে , যদি কাছে আসতে দাও, যদি ভালবাসতে দাও, এক জনম নয় লক্ষ জনম ভালবাসব তোমাকে.",0,0));
        messageList.add(new Message("এক পৃথিবীতে চেয়েছি তোমাকে, এক সাগর ভালবাসা রয়েছে এ বুকে , যদি কাছে আসতে দাও, যদি ভালবাসতে দাও, এক জনম নয় লক্ষ জনম ভালবাসব তোমাকে.",0,0));
        messageList.add(new Message("এক পৃথিবীতে চেয়েছি তোমাকে, এক সাগর ভালবাসা রয়েছে এ বুকে , যদি কাছে আসতে দাও, যদি ভালবাসতে দাও, এক জনম নয় লক্ষ জনম ভালবাসব তোমাকে.",0,0));
        messageList.add(new Message("এক পৃথিবীতে চেয়েছি তোমাকে, এক সাগর ভালবাসা রয়েছে এ বুকে , যদি কাছে আসতে দাও, যদি ভালবাসতে দাও, এক জনম নয় লক্ষ জনম ভালবাসব তোমাকে.",0,0));
        messageList.add(new Message("এক পৃথিবীতে চেয়েছি তোমাকে, এক সাগর ভালবাসা রয়েছে এ বুকে , যদি কাছে আসতে দাও, যদি ভালবাসতে দাও, এক জনম নয় লক্ষ জনম ভালবাসব তোমাকে.",0,0));
        messageList.add(new Message("এক পৃথিবীতে চেয়েছি তোমাকে, এক সাগর ভালবাসা রয়েছে এ বুকে , যদি কাছে আসতে দাও, যদি ভালবাসতে দাও, এক জনম নয় লক্ষ জনম ভালবাসব তোমাকে.",0,0));

        adapter = new MessageAdapter(messageList);
        recyclerView.setAdapter(adapter);
    }
}
