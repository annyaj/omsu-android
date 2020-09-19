package com.example.candyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class QuestionaryActivity extends AppCompatActivity {

    static final private int CHOOSE_CANDY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionary);

        TextView hello = findViewById(R.id.questionary_hello);
        hello.setText(hello.getText().toString().concat(Objects.requireNonNull(
                Objects.requireNonNull(getIntent().getExtras()).getString("Username"))));

        Button choose = findViewById(R.id.questionary_button_choose);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuestionaryActivity.this, ChooseCandyActivity.class);
                startActivityForResult(intent, CHOOSE_CANDY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView questionaryText = (TextView) findViewById(R.id.questionary_hello);

        if (requestCode == CHOOSE_CANDY) {
            if (resultCode == RESULT_OK) {
                String candy = data.getStringExtra(ChooseCandyActivity.CANDY);
                questionaryText.setText(getString(R.string.questionary_choosen_text).concat(candy));
            } else {
                questionaryText.setText(R.string.qyestionary_no_choosen);
            }
        }
    }
}