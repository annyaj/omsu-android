package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("MainActivity", "onCreate called");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("MainActivity", "onStart called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i("MainActivity", "onRestart called");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("MainActivity", "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("MainActivity", "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("MainActivity", "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("MainActivity", "onDestroy called");
    }
}
