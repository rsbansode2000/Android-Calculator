package com.example.calculatorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class BMI_Activity extends AppCompatActivity {
    EditText weight, height;
    TextView result, status;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        weight = findViewById(R.id.editTextTextWeight);
        height = findViewById(R.id.editTextHeight);
        result = findViewById(R.id.textViewBMIResult);
        status = findViewById(R.id.textViewBMIStatus);
        button = findViewById(R.id.buttonBMICalculate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float wt, ht, bmi;
                if(!weight.getText().toString().equals("") && !height.getText().toString().equals("")){
                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                    wt = Float.parseFloat(weight.getText().toString());
                    ht = Float.parseFloat(height.getText().toString())/100;
                    bmi = wt/(ht*ht);
                    result.setText("BMI = "+String.format("%.2f",bmi).toString());
                    status(bmi);
                }
                else{
                    Toast.makeText(BMI_Activity.this, "Please Enter Weight and Height", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void status(float bmi){
        if(bmi<18){
            status.setText("You are Under Weight...");
            status.setTextColor(Color.rgb(253,216,53));
        }
        else if(bmi >= 18 && bmi < 25){
            status.setTextColor(Color.rgb(0,255,0));
            status.setText("Congraluation! Your weight is Normal!");
        }
        else if(bmi >= 25 && bmi < 30){
            status.setTextColor(Color.rgb(251,140,0));
            status.setText("You are Over Weight.....");
        }
        else {
            status.setTextColor(Color.rgb(255,0,0));
            status.setText("Warning!!! You are Obses!!!!!");
        }
    }
}