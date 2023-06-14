package com.example.calculatorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IntrestCalculator_Activity extends AppCompatActivity {
    EditText amount, rate, time;
    TextView textViewAnswer;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intrest_calculator);
        amount = findViewById(R.id.editTextNumbeAmount2);
        rate = findViewById(R.id.editTextNumbeRate);
        time = findViewById(R.id.editTextNumberTime);
        textViewAnswer = findViewById(R.id.textViewAnswer);
        button = findViewById(R.id.buttonInterest);

        onButtonClick();
    }

    private void onButtonClick() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!amount.getText().toString().equals("") && !rate.getText().toString().equals("") && !time.getText().toString().equals("")){
                    float p = Float.parseFloat(amount.getText().toString());
                    float r = Float.parseFloat(rate.getText().toString());
                    float t = Float.parseFloat(time.getText().toString());
                    float si = (p*r*t)/100;
                    float amount_for_ci = (float) (p*Math.pow((1+(r/100)),t));
                    textViewAnswer.setTextColor(Color.BLACK);
                    textViewAnswer.setText("SI is RS "+String.format("%.2f",si).toString()+
                            " and Money should return is RS "+String.format("%.2f",si+p).toString()+"\nOR\nCI is RS "+
                            String.format("%.2f",amount_for_ci-p)+" and Money should return is RS "+String.format("%.2f",amount_for_ci));
                }
                else{
                    textViewAnswer.setText("Please Enter the Values!!!");
                    textViewAnswer.setTextColor(Color.RED);
                }
            }
        });
    }
}