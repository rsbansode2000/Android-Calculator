package com.example.calculatorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Matrices_Activity extends AppCompatActivity {
    EditText buttona11, buttona12, buttona13, buttona21, buttona22, buttona23, buttona31, buttona32, buttona33,
            buttonb11, buttonb12, buttonb13, buttonb21, buttonb22, buttonb23, buttonb31, buttonb32, buttonb33;
    TextView textViewAnswer;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrices);
        button = findViewById(R.id.buttonCalculateMatrices);
        textViewAnswer = findViewById(R.id.textViewAnswerMatrices);
        findID();
        onButtonClick();
    }

    private void findID() {
        buttona11 = findViewById(R.id.editTextNumbera11);
        buttona12 = findViewById(R.id.editTextNumberaa12);
        buttona13 = findViewById(R.id.editTextNumberaa13);
        buttona21 = findViewById(R.id.editTextNumberaaa21);
        buttona22 = findViewById(R.id.editTextNumbera22);
        buttona23 = findViewById(R.id.editTextNumbera23);
        buttona31 = findViewById(R.id.editTextNumbera31);
        buttona32 = findViewById(R.id.editTextNumbera32);
        buttona33 = findViewById(R.id.editTextNumbera33);
        buttonb11 = findViewById(R.id.editTextNumberb11);
        buttonb12 = findViewById(R.id.editTextNumberab12);
        buttonb13 = findViewById(R.id.editTextNumberab13);
        buttonb21 = findViewById(R.id.editTextNumberaab21);
        buttonb22 = findViewById(R.id.editTextNumberb22);
        buttonb23 = findViewById(R.id.editTextNumberb23);
        buttonb31 = findViewById(R.id.editTextNumberb31);
        buttonb32 = findViewById(R.id.editTextNumberb32);
        buttonb33 = findViewById(R.id.editTextNumberb33);


    }

    private void onButtonClick() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDotProduct();
            }
        });
    }

    private void calculateDotProduct(){
        int a11=0; int a12=0;int a13=0;int a21=0;int a22=0;int a23=0;int a31=0;int a32=0;int a33=0;int
                b11=0;int  b12=0;int b13=0;int b21=0;int b22=0;int b23=0;int b31=0;int b32=0;int b33=0;
        textViewAnswer.setText(" ");
        if(!buttona11.getText().toString().equals("") && !buttona12.getText().toString().equals("") && !buttona13.getText().toString().equals("")
        && !buttona21.getText().toString().equals("") && !buttona22.getText().toString().equals("") && !buttona23.getText().toString().equals("")
        && !buttona31.getText().toString().equals("") && !buttona32.getText().toString().equals("") && !buttona33.getText().toString().equals("")
        && !buttonb11.getText().toString().equals("") && !buttonb12.getText().toString().equals("") && !buttonb13.getText().toString().equals("")
                && !buttonb21.getText().toString().equals("") && !buttonb22.getText().toString().equals("") && !buttonb23.getText().toString().equals("")
                && !buttonb31.getText().toString().equals("") && !buttonb32.getText().toString().equals("") && !buttonb33.getText().toString().equals("")){
            a11 = Integer.parseInt(buttona11.getText().toString());
            a12 = Integer.parseInt(buttona12.getText().toString());
            a13 = Integer.parseInt(buttona13.getText().toString());
            a21 = Integer.parseInt(buttona21.getText().toString());
            a22 = Integer.parseInt(buttona22.getText().toString());
            a23 = Integer.parseInt(buttona23.getText().toString());
            a31 = Integer.parseInt(buttona31.getText().toString());
            a32 = Integer.parseInt(buttona32.getText().toString());
            a33 = Integer.parseInt(buttona33.getText().toString());
            b11 = Integer.parseInt(buttonb11.getText().toString());
            b12 = Integer.parseInt(buttonb12.getText().toString());
            b13 = Integer.parseInt(buttonb13.getText().toString());
            b21 = Integer.parseInt(buttonb21.getText().toString());
            b22 = Integer.parseInt(buttonb22.getText().toString());
            b23 = Integer.parseInt(buttonb23.getText().toString());
            b31 = Integer.parseInt(buttonb31.getText().toString());
            b32 = Integer.parseInt(buttonb32.getText().toString());
            b33 = Integer.parseInt(buttonb33.getText().toString());


            int a[][] = {{a11,a12,a13}, {a21,a22,a23}, {a31,a32,a33}};
            int b[][] = {{b11,b12,b13}, {b21,b22,b23}, {b31,b32,b33}};
            int c[][] = new int[3][3];

            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                    c[i][j] = 0;
                    for(int k=0; k<3; k++){
                        c[i][j] += a[i][k]*b[k][j];
                    }
                    textViewAnswer.append(c[i][j]+" ");
                }
                textViewAnswer.append("\n");
            }
        }
        else {
            Toast.makeText(this, "Please Enter Values!!!", Toast.LENGTH_SHORT).show();
        }
    }

}