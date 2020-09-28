package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private float convertParrotToMeter(float parrot) {
        return (float) (parrot / 7.6);
    }

    private float convertMeterToParrot(float meter) {
        return (float) (meter * 7.6);
    }

    public void onClick(View view) {
        RadioButton meterRadioButton = findViewById(R.id.radioButtonMeter);
        EditText inputEditText = findViewById(R.id.editText);

        if (inputEditText.getText().length() == 0) {
            Snackbar.make(view, "Введите длину кота", Snackbar.LENGTH_LONG).show();
            return;
        }

        float inputValue = Float.parseFloat(inputEditText.getText().toString());
        if (meterRadioButton.isChecked()) {
            inputEditText.setText(String
                    .valueOf(convertParrotToMeter(inputValue)));
        } else {
            inputEditText.setText(String
                    .valueOf(convertMeterToParrot(inputValue)));
        }
    }
}
