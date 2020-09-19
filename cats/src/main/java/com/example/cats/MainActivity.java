package com.example.cats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView2 = findViewById(R.id.second_text_view);
        final TextView textView3 = findViewById(R.id.third_text_view);
        final TextView textView4 = findViewById(R.id.forth_text_view);
        ImageView orangeCat = findViewById(R.id.image_orange_cat);

        orangeCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] phrases = {"Meow",
                        "We want to eat!",
                        "Already 6 am",
                        "Don't sleep!!!!",
                        "The clock is ticking",
                        "I want a cat food",
                        "Get up",
                        "Wake up!!!!"};

                shuffleArray(phrases);

                textView2.setText(phrases[0]);
                textView3.setText(phrases[1]);
                textView4.setText(phrases[2]);
            }
        });
    }

    private void shuffleArray(String[] array) {
        Random random = new Random();
        String temp;
        int index;
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
