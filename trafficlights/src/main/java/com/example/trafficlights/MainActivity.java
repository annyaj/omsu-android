package com.example.trafficlights;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout = findViewById(R.id.root_layout);
        textView = findViewById(R.id.textView);

        Button redButton = findViewById(R.id.red_button);
        Button yellowButton = findViewById(R.id.yellow_button);
        Button greenButton = findViewById(R.id.green_button);
        redButton.setOnClickListener(this);
        yellowButton.setOnClickListener(this);
        greenButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int text;
        int color;
        switch (view.getId()) {
            case R.id.yellow_button:
                color = ContextCompat.getColor(this, R.color.yellow_color);
                text = R.string.yellow_button_text;
                break;
            case R.id.green_button:
                color = ContextCompat.getColor(this, R.color.green_color);
                text = R.string.red_button_text;
                break;
            default:
                color = ContextCompat.getColor(this, R.color.red_color);
                text = R.string.green_button_text;
                break;
        }
        constraintLayout.setBackgroundColor(color);
        textView.setText(text);
    }
}
