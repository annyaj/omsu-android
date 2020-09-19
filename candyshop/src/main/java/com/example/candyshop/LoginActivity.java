package com.example.candyshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText editText = findViewById(R.id.editTextTextPersonName);
        Button login = findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, QuestionaryActivity.class);
                String username = editText.getText().toString();
                if ("".equals(username)) {
                    username = getString(R.string.fill_edit);
                }
                intent.putExtra("Username", username);
                startActivity(intent);
            }
        });
    }
}