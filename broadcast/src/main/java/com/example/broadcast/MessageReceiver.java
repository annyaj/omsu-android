package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MessageReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Receive new msg: " +
                        intent.getStringExtra("com.example.broadcast.Message"),
                Toast.LENGTH_LONG).show();
    }
}
