package com.example.rahulbera.hydra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MoreData extends AppCompatActivity {
    EditText etworkout_time,etwork_hours;
    Switch LED,Buzzer;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_data);
        etworkout_time = findViewById(R.id.etWorkoutTime);
        etwork_hours = findViewById(R.id.etWorkHours);
        LED = findViewById(R.id.sLED);
        Buzzer = findViewById(R.id.sBuzzer);
        btn1 = findViewById(R.id.btnFinish);

        MainActivity.ledStatus = "1";
        LED.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    MainActivity.ledStatus = "1";
                else
                    MainActivity.ledStatus = "0";
            }
        });

        MainActivity.buzzerStatus = "1";
        Buzzer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    MainActivity.buzzerStatus = "1";
                else
                    MainActivity.buzzerStatus = "0";
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.workout_time = etworkout_time.getText().toString();
                MainActivity.work_hours = etwork_hours.getText().toString();
                try{
                    double lit = Double.parseDouble(MainActivity.liter);
                    double wti = Double.parseDouble(MainActivity.workout_time);
                    lit += (wti*0.012);
                    MainActivity.liter = String.valueOf(String.format("%.2f",lit));
                    if (Integer.parseInt(MainActivity.work_hours)<24 && Integer.parseInt(MainActivity.work_hours)>0&& Integer.parseInt(MainActivity.workout_time)<1440){
                        if (MainActivity.buzzerStatus=="1" || MainActivity.ledStatus=="1" ) {
                            Intent i6 = new Intent(getApplicationContext(), PlanActivity.class);
                            startActivity(i6);
                        }
                        else
                            Toast.makeText(MoreData.this, "Select atleast one among LED indicator and Buzzer", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(MoreData.this, "Enter Workout time<1440 and 0<Work hours<24!", Toast.LENGTH_LONG).show();
                    }
                }
                catch (Exception e){
                    Toast.makeText(MoreData.this, "Error for empty inputs!", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
