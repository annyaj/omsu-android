package com.example.myappl;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myappl.data.HotelContract;
import com.example.myappl.data.HotelDbHelper;

import java.util.Objects;

public class SecondFragment extends Fragment {
    private EditText mNameEditText;
    private EditText mCityEditText;
    private EditText mAgeEditText;

    private Spinner mGenderSpinner;

    private int mGender = 2;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.fab2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        mNameEditText = (EditText) view.findViewById(R.id.edit_guest_name);
        mCityEditText = (EditText) view.findViewById(R.id.edit_guest_city);
        mAgeEditText = (EditText) view.findViewById(R.id.edit_guest_age);
        mGenderSpinner = (Spinner) view.findViewById(R.id.spinner_gender);

        Button saveButton = view.findViewById(R.id.button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertGuest();
            }
        });

        final Button deleteButton = view.findViewById(R.id.button2);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteGuest();
            }
        });

        setupSpinner();
    }


    private void setupSpinner() {
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.array_gender_options, android.R.layout.simple_spinner_item);

        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        mGenderSpinner.setAdapter(genderSpinnerAdapter);
        mGenderSpinner.setSelection(2);

        mGenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.gender_female))) {
                        mGender = HotelContract.GuestEntry.GENDER_FEMALE; // Female
                    } else if (selection.equals(getString(R.string.gender_male))) {
                        mGender = HotelContract.GuestEntry.GENDER_MALE; // Male
                    } else {
                        mGender = HotelContract.GuestEntry.GENDER_UNKNOWN; // unknown
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mGender = 2; // Unknown
            }
        });
    }

    public void insertGuest() {
        // Считываем данные из текстовых полей
        String name = mNameEditText.getText().toString().trim();
        String city = mCityEditText.getText().toString().trim();
        String ageString = mAgeEditText.getText().toString().trim();
        int age = Integer.parseInt(ageString);

        HotelDbHelper mDbHelper = new HotelDbHelper(getContext());

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HotelContract.GuestEntry.COLUMN_NAME, name);
        values.put(HotelContract.GuestEntry.COLUMN_CITY, city);
        values.put(HotelContract.GuestEntry.COLUMN_GENDER, mGender);
        values.put(HotelContract.GuestEntry.COLUMN_AGE, age);

        // Вставляем новый ряд в базу данных и запоминаем его идентификатор
        long newRowId = db.insert(HotelContract.GuestEntry.TABLE_NAME, null, values);

        // Выводим сообщение в успешном случае или при ошибке
        if (newRowId == -1) {
            // Если ID  -1, значит произошла ошибка
            Toast.makeText(getContext(), "Ошибка при заведении гостя", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Гость заведён под номером: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteGuest() {
        String name = mNameEditText.getText().toString().trim();
        HotelDbHelper mDbHelper = new HotelDbHelper(getContext());

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        db.delete(HotelContract.GuestEntry.TABLE_NAME,
                HotelContract.GuestEntry.COLUMN_NAME + "= ?", new String[]{name});

        Toast.makeText(getContext(), "Гость удален: " + name, Toast.LENGTH_SHORT).show();
    }
}
