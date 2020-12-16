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

public class SecondActivity extends AppCompatActivity {

    SharedPreferences mSaglabats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
    }


    public void firstActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    public void nolasit(View view) {

        mSaglabats = getSharedPreferences("prefID", Context.MODE_PRIVATE);
        String strText = mSaglabats.getString("nameKey", "");
        EditText text = (EditText) findViewById(R.id.textBox);
        text.setText(strText);

        if (strText == "") {
            Toast.makeText(getApplicationContext(), "Nothing found!", Toast.LENGTH_SHORT).show();
        }

        else{
            Toast.makeText(getApplicationContext(), "Successfully!", Toast.LENGTH_SHORT).show();
        }
    }
}