package com.example.rahulbera.hydra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.lang.String;

public class MainActivity extends AppCompatActivity {
        EditText editText,editText2;
        Button button;

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
                String str = editText.getText().toString();
                String str1 = editText2.getText().toString();
                Intent intent = new Intent(getApplicationContext(),AmountActivity.class);
                intent.putExtra("name", str);
                intent.putExtra("weight",str1);
                startActivity(intent);





           }});

    }

}
