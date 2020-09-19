package com.example.candyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class ChooseCandyActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_candy);
        RadioButton sweets = findViewById(R.id.choose_sweets);
        RadioButton cupcake = findViewById(R.id.choose_cupcake);
        RadioButton biscuits = findViewById(R.id.choose_biscuits);
        sweets.setOnClickListener(this);
        cupcake.setOnClickListener(this);
        biscuits.setOnClickListener(this);
    }

    public final static String CANDY = "com.example.candyshop.CANDY";

    @Override
    public void onClick(View v) {
        Intent answerIntent = new Intent();

        switch (v.getId()) {
            case R.id.choose_biscuits:
                answerIntent.putExtra(CANDY, getText(R.string.choose_biscuits_radio));
                break;
            case R.id.choose_cupcake:
                answerIntent.putExtra(CANDY, getText(R.string.choose_cupcake_radio));
                break;
            case R.id.choose_sweets:
                answerIntent.putExtra(CANDY, getText(R.string.choose_sweets_radio));
                break;

            default:
                break;
        }

        setResult(RESULT_OK, answerIntent);
        finish();
    }
}