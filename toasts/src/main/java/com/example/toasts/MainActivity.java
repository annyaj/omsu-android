package com.example.toasts;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.toast_bitton);
        button.setOnClickListener(view -> runOnUiThread(() -> {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Hello, my dear friend!", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP, 0, 200);

            LinearLayout toastContainer = (LinearLayout) toast.getView();
            toastContainer.setBackgroundColor(Color.TRANSPARENT);
            ImageView image = new ImageView(getApplicationContext());
            image.setImageResource(R.drawable.koshka);
            toastContainer.addView(image, 0);

            toast.show();
        }));

        Button customToastButton = findViewById(R.id.custom_toast_button);
        customToastButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_toast,
                        (ViewGroup) findViewById(R.id.custom_toast_container));

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.TOP, 0, 200);
                toast.setView(layout);

//                toast.addCallback(new Toast.Callback() {
//                    @Override
//                    public void onToastShown() {
//                        super.onToastShown();
//                        Log.d("Toast", "shown");
//                    }
//
//                    @Override
//                    public void onToastHidden() {
//                        super.onToastHidden();
//                        Log.d("Toast", "hidden");
//                    }
//                });

                toast.show();
            }
        });
    }
}
