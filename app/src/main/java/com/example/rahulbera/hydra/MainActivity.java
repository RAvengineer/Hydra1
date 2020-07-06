package com.example.rahulbera.hydra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.String;

public class MainActivity extends AppCompatActivity {
        EditText editText,editText2;
        Button button;
        public static String liter;
        public static String name;
        public static String weight;
        public static String serving_size;
        public static String workout_time;
        public static String work_hours;
        public static String frequency;
        public static String duration;
        public static String ledStatus;
        public static String buzzerStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editText.getText().toString();
                weight = editText2.getText().toString();
                try {
                    //int wi = Integer.parseInt(MainActivity.weight);
                    if(Integer.parseInt(weight)!=0) {
                        Intent intent = new Intent(getApplicationContext(),AmountActivity.class);
                        startActivity(intent);
                    }
                    else {
                        throw new Exception("Enter a weight greater than Zero!");
                    }
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error!\n"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }

           }});

    }

}
