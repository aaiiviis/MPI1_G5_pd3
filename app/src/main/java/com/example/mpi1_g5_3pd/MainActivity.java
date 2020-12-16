package com.example.mpi1_g5_3pd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences mSaglabats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner themes = findViewById(R.id.spinner);

        themes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                    default:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                        break;
                    case 1:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        break;
                    case 2:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "Nothing here:", Toast.LENGTH_LONG).show();
            }
        });


        mSaglabats = getSharedPreferences("prefID", Context.MODE_PRIVATE);
        String strText = mSaglabats.getString("nameKey", "");
        EditText vards = (EditText) findViewById(R.id.textBox);
        vards.setText(strText);
    }


    public void secondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void saglabat(View view) {
        EditText text = (EditText) findViewById(R.id.textBox);

        mSaglabats = getSharedPreferences("prefID", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSaglabats.edit();
        String strText = text.getText().toString();
        editor.putString("nameKey", strText);
        editor.apply();

        if (strText.length() < 1) {
            Toast.makeText(getApplicationContext(), "Empty!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Saved!", Toast.LENGTH_SHORT).show();
        }
    }

}


