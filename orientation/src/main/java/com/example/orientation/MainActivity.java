package com.example.orientation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private final String EDIT_TEXT_KEY = "edit_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Toast.makeText(MainActivity.this,
                        "onTextChanged: " + s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);

        final Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                } else {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
            }
        });

        TextView textView = findViewById(R.id.text_orientation);
        if (savedInstanceState != null) {
            textView.setText(savedInstanceState.getString(EDIT_TEXT_KEY, ":("));
        }
    }

    @Override
    public void onClick(View view) {
        int rotate = getWindowManager().getDefaultDisplay().getRotation();
        String rotation;
        switch (rotate) {
            case Surface.ROTATION_0:
                rotation = "Не поворачивали";
                break;
            case Surface.ROTATION_90:
                rotation = "Повернули на 90 градусов по часовой стрелке";
                break;
            case Surface.ROTATION_180:
                rotation = "Повернули на 180 градусов";
                break;
            case Surface.ROTATION_270:
                rotation = "Повернули на 90 градусов против часовой стрелки";
                break;
            default:
                rotation = "Не понятно";
        }
        editText.setText(rotation);
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(EDIT_TEXT_KEY, editText.getText().toString());
    }
}
