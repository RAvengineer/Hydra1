package com.example.rahulbera.hydra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PlanActivity extends AppCompatActivity {
    TextView textView7;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        textView7 = findViewById(R.id.textView7);



     final Intent i = getIntent();
        String str2 = i.getStringExtra("litre");
        double lit = Double.parseDouble(str2);
        String lid = String.valueOf(lit);
        textView7.setText(lid);
        }

    }

