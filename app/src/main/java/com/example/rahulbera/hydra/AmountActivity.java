package com.example.rahulbera.hydra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;


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
        textView4.setText(MainActivity.name);

        int wi = Integer.parseInt(MainActivity.weight);
        double l = wi*1.4698;
        MainActivity.liter = String.valueOf(String.format("%.2f",l*0.03));
        GoToNewActivity = findViewById(R.id.button2);

        GoToNewActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MainActivity.serving_size = editText3.getText().toString();
                try{
                    if(Integer.parseInt(MainActivity.serving_size)==0) {
                        throw new Exception("Enter serving size>0");
                    }
                    else {
                        Intent i2 = new Intent(getApplicationContext(), MoreData.class);
                        startActivity(i2);
                    }
                }
                catch (Exception e){
                    Toast.makeText(AmountActivity.this, "Error! "+e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });  }


    }




