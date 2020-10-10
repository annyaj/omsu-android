package com.example.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String WHERE_MY_MSG_ACTION = "com.example.action.NEW_MESSAGE";
    public static final String ALARM_MESSAGE = "Hello, my friends!";

    private MessageReceiver messageReceiver = new MessageReceiver();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerBroadcastReceiver();
    }

    public void sendMessage(View view) {
        Intent intent = new Intent();
        intent.setAction(WHERE_MY_MSG_ACTION);
        intent.putExtra("com.example.broadcast.Message", ALARM_MESSAGE);
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }

    public void registerBroadcastReceiver() {
        this.registerReceiver(messageReceiver, new IntentFilter(
                WHERE_MY_MSG_ACTION));
    }
}
