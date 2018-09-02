package com.example.rahulbera.hydra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;


public class AmountActivity extends AppCompatActivity {
TextView textView4;
EditText editText3;


    Button GoToNewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount);
        textView4 = findViewById(R.id.textView4);
        editText3=findViewById(R.id.editText3);
        Intent intent = getIntent();
        String str = intent.getStringExtra("name");
        textView4.setText(str);
        String str1 = intent.getStringExtra("weight");
       final String serv= editText3.getText().toString();


        int w = Integer.parseInt(str1);
        double l = w/15;
        final String ls = String.valueOf(l);
        GoToNewActivity = findViewById(R.id.button2);

        GoToNewActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String ls1=ls;
                String servf=serv;
               Intent i = new Intent(getApplicationContext(), PlanActivity.class);
               i.putExtra("litre",ls1);
               i.putExtra("serve",servf);
               startActivity(i);

            }
        });  }


    }




