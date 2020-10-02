package com.example.referencebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Picture> pictureList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        // создаем адаптер
        DataAdapter adapter = new DataAdapter(this, pictureList);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }

    private void setInitialData() {

        pictureList.add(new Picture("Picture 1", "It's wonderful picture!!!", R.drawable.pic1));
        pictureList.add(new Picture("Picture 2", "It's amazing", R.drawable.pic2));
        pictureList.add(new Picture("Picture 3", "Perfect", R.drawable.pic3));
        pictureList.add(new Picture("Picture 4", "Good", R.drawable.pic4));

        pictureList.add(new Picture("Picture 1", "It's wonderful picture!!!", R.drawable.pic1));
        pictureList.add(new Picture("Picture 2", "It's amazing", R.drawable.pic2));
        pictureList.add(new Picture("Picture 3", "Perfect", R.drawable.pic3));
        pictureList.add(new Picture("Picture 4", "Good", R.drawable.pic4));

        pictureList.add(new Picture("Picture 1", "It's wonderful picture!!!", R.drawable.pic1));
        pictureList.add(new Picture("Picture 2", "It's amazing", R.drawable.pic2));
        pictureList.add(new Picture("Picture 3", "Perfect", R.drawable.pic3));
        pictureList.add(new Picture("Picture 4", "Good", R.drawable.pic4));
    }
}
