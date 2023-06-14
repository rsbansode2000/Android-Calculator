package com.example.calculatorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LinearEquation_Activity extends AppCompatActivity {
//    Button button, button1, button2, button3, buttonC, button4, button5, button6, button7,
//            button8, button9, button0, buttonPoint, buttonAC;
    Button button;
    TextView textView;
    EditText textA, textB, textC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_equation);
        textView = findViewById(R.id.textView5);
        textA = findViewById(R.id.editTextNumberDecimalA);
        textB = findViewById(R.id.editTextNumberDecimalB);
        textC = findViewById(R.id.editTextNumberDecimalC);
        button = findViewById(R.id.buttonCalculateX);
        onButtonClick();
    }

    private void onButtonClick() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateX();
            }
        });
    }

    private void calculateX(){
        float a = Float.parseFloat(textA.getText().toString());
        float b = Float.parseFloat(textB.getText().toString());
        float c = Float.parseFloat(textC.getText().toString());
        double result1, result2;
        try{
            float flag = b*b-4*a*c;
            if(flag < 0){
                textView.setText("Cannot Solve");
            }
            else{
              result1 = (-b + Math.sqrt(flag))/(2*a);
              result2 = (-b - Math.sqrt(flag))/(2*a);
              textView.setText(" X = "+String.format("%.2f",result1)+" or  X = "+String.format("%.2f",result2));
            }
        }catch (Exception e){
             System.out.println(e);
        }
    }

//    @Override
//    public void onClick(View v) {
//        Button button = (Button) v;
//    }
//
//    public void declearingID(){
//        button = findViewById(R.id.buttonFindLength);
//        button1 = findViewById(R.id.button1);
//        button1.setOnClickListener(this);
//        button2 = findViewById(R.id.button2);
//        button2.setOnClickListener(this);
//        button3 = findViewById(R.id.button3);
//        button3.setOnClickListener(this);
//        button4 = findViewById(R.id.button4);
//        button4.setOnClickListener(this);
//        button5 = findViewById(R.id.button5);
//        button5.setOnClickListener(this);
//        button6 = findViewById(R.id.button6);
//        button6.setOnClickListener(this);
//        button7 = findViewById(R.id.button7);
//        button7.setOnClickListener(this);
//        button8 = findViewById(R.id.button8);
//        button8.setOnClickListener(this);
//        button9 = findViewById(R.id.buttonpoint9);
//        button9.setOnClickListener(this);
//        button0 = findViewById(R.id.button0);
//        button0.setOnClickListener(this);
//        buttonAC = findViewById(R.id.buttoncac);
//        buttonAC.setOnClickListener(this);
//        buttonPoint = findViewById(R.id.buttonpoint);
//        buttonPoint.setOnClickListener(this);
//        buttonC = findViewById(R.id.buttonc);
//        buttonC.setOnClickListener(this);
//    }

}