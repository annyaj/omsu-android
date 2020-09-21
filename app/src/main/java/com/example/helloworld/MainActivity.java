package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView fmTextView;
    private EditText fmEditText;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fmTextView = findViewById(R.id.textView);
        fmEditText = findViewById(R.id.editTextTextPersonName);
        Button buttonCounter = findViewById(R.id.buttonCounter);
        buttonCounter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fmTextView.setText(String.format("%s%d", getString(R.string.feed_cat), ++count));
                    }
                }
        );
    }

    public void onPressButton(View view) {
        if (fmEditText.getText().length() == 0) {
            fmTextView.setText(R.string.on_press_cat_text);
        } else {
            fmTextView.setText("Hello, " + fmEditText.getText());
        }
    }

    public void onSayHello(View view) {
        fmTextView.setText(R.string.say_meow_text);
    }
}