package com.example.tp4e1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioButton r1 = findViewById(R.id.radioButton3);
        RadioButton r2 = findViewById(R.id.radioButton4);
        ImageButton b1 = findViewById(R.id.imageButton);
        ImageButton b2 = findViewById(R.id.imageButton2);
        EditText txt1 = findViewById(R.id.editTextNumberDecimal);
        EditText txt2 = findViewById(R.id.editTextNumberDecimal2);
        Button bb = findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              try {
                  if(txt2.getText().toString().trim().equals("")){
                      Toast.makeText(MainActivity.this, "please enter value !", Toast.LENGTH_SHORT).show();
                  }
                  else{
                      float x = Float.parseFloat(txt2.getText().toString());

                      if(r2.isChecked()){
                          float res = toeur(x);
                          txt1.setText(Float.toString(res));
                      }
                      else if(r1.isChecked()){
                          float res = toeurs(x);
                          txt1.setText(Float.toString(res));
                      }
                      else{
                          Toast.makeText(MainActivity.this, "please check method", Toast.LENGTH_SHORT).show();
                      }
                  }
              }catch (Exception ee){
                  Toast.makeText(MainActivity.this,ee.getMessage(), Toast.LENGTH_SHORT).show();
              }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              try {
                  if(txt1.getText().toString().trim().equals("")){
                      Toast.makeText(MainActivity.this, "please enter value !", Toast.LENGTH_SHORT).show();
                  }
                  else{
                      float x = Float.parseFloat(txt1.getText().toString());
                      if(r2.isChecked()){
                          float res = toda(x);
                          txt2.setText(Float.toString(res));
                      }
                      else if(r1.isChecked()){
                          float res = todas(x);
                          txt2.setText(Float.toString(res));
                      }
                      else{
                          Toast.makeText(MainActivity.this,"please check method", Toast.LENGTH_SHORT).show();
                      }
                  }
              }catch (Exception ee){
                  Toast.makeText(MainActivity.this,ee.getMessage(), Toast.LENGTH_SHORT).show();
              }
            }
        });


        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try {
                   txt1.setText("");
                   txt2.setText("");
               }catch (Exception ee){
                   Toast.makeText(MainActivity.this,ee.getMessage(), Toast.LENGTH_SHORT).show();
               }
            }
        });
    }

    public float toeur(float x){
        return (float) (x*0.0072);
    }

    public float toda(float x){
        return (float) (x*138.15);
    }

    public float toeurs(float x){
        return (float) (x*0.0044);
    }

    public float todas(float x){
        return (float) (x*225.00);
    }

}