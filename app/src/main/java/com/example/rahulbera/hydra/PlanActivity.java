package com.example.rahulbera.hydra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Math.ceil;

public class PlanActivity extends AppCompatActivity {
    TextView textView7,fr,du;
    Button CD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        double lit = Double.parseDouble(MainActivity.liter);
        double serv = Double.parseDouble(MainActivity.serving_size);
        double wh = Double.parseDouble(MainActivity.work_hours);
        double f = ceil(lit*1000/serv);
        double d = ceil(wh*60/f);
        MainActivity.frequency = String.valueOf(String.format("%.0f",f));
        MainActivity.duration = String.valueOf(String.format("%.0f",d));
        textView7 = findViewById(R.id.textView7);
        fr = findViewById(R.id.tvFreq);
        du = findViewById(R.id.tvDur);
        CD = findViewById(R.id.CD);
        textView7.setText(MainActivity.liter);
        fr.setText(MainActivity.frequency);
        du.setText(MainActivity.duration);

        CD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(),DeviceList.class);
                startActivity(intent2);
            }
        });
    }

}


