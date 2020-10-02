package com.example.mybrowser;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        InputMethodSubtype ims = imm.getCurrentInputMethodSubtype();
        String localeString = ims.getLocale();
        Locale locale = new Locale(localeString);
        String currentLanguage = locale.getDisplayLanguage();
        EditText languageEditText = findViewById(R.id.etNewItem);
        Toast.makeText(getApplicationContext(), currentLanguage, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse(languageEditText.getText() == null ? "https://www.google.com/" :
                        languageEditText.getText().toString()));
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        openQuitDialog();
    }

    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(MainActivity.this);
        quitDialog.setTitle("Exit: Are you sure?");

        quitDialog.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        quitDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        quitDialog.show();
    }

    @Override
    protected void onUserLeaveHint() {
        Toast toast = Toast.makeText(getApplicationContext(), "Clicked button HOME", Toast.LENGTH_SHORT);
        toast.show();
        super.onUserLeaveHint();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_MENU:
                Toast.makeText(this, "Pressed button MENU", Toast.LENGTH_SHORT)
                        .show();
                return true;
            case KeyEvent.KEYCODE_SEARCH:
                Toast.makeText(this, "Pressed button SEARCH", Toast.LENGTH_SHORT)
                        .show();
                return true;
            case KeyEvent.KEYCODE_BACK:
                onBackPressed();
                return true;
            case KeyEvent.KEYCODE_VOLUME_UP:
                event.startTracking();
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                Toast.makeText(this, "Pressed button VOLUME", Toast.LENGTH_SHORT)
                        .show();
                return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
