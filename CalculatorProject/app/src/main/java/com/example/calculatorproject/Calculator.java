package com.example.calculatorproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class Calculator extends Fragment implements View.OnClickListener {
    Button buttonAC, buttonpercentage, buttondivide, button7, button8, button9, buttonX,
    button4, button5, button6, buttonsubtract, button1, button2, button3, buttonadd,
    buttonpoint, button0, buttonequals, buttonback;
    TextView textAnswer, textQue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        findID(view);
        return  view;
    }

    private void findID(View view) {
        textAnswer = view.findViewById(R.id.textViewAnswer);
        textQue = view.findViewById(R.id.TextViewQuestion);
        button0 = view.findViewById(R.id.button0);
        button1 = view.findViewById(R.id.button1);
        button2 = view.findViewById(R.id.button2);
        button3 = view.findViewById(R.id.button3);
        button4 = view.findViewById(R.id.button4);
        button5 = view.findViewById(R.id.button5);
        button6 = view.findViewById(R.id.button6);
        button7 = view.findViewById(R.id.button7);
        button8 = view.findViewById(R.id.button8);
        button9 = view.findViewById(R.id.button9);
        buttonAC = view.findViewById(R.id.buttonAC);
        buttonback = view.findViewById(R.id.buttonBackSpace);
        buttonpercentage = view.findViewById(R.id.buttonPercentage);
        buttondivide = view.findViewById(R.id.buttonDivision);
        buttonX = view.findViewById(R.id.buttonMultiply);
        buttonsubtract = view.findViewById(R.id.buttonSubtract);
        buttonadd = view.findViewById(R.id.buttonAdd);
        buttonpoint = view.findViewById(R.id.buttonpoint);
        buttonequals = view.findViewById(R.id.buttonEqual);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonpoint.setOnClickListener(this);
        buttonadd.setOnClickListener(this);
        buttonsubtract.setOnClickListener(this);
        buttondivide.setOnClickListener(this);
        buttonX.setOnClickListener(this);
        buttonequals.setOnClickListener(this);
        buttonpercentage.setOnClickListener(this);
        buttonback.setOnClickListener(this);
        buttonAC.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String buttonText = button.getText().toString();
        String dataToCal = textQue.getText().toString();

        if(buttonText.equals("AC")){
            textQue.setText("");
        }
        else if(buttonText.equals("C")){
            if (dataToCal.length()>0){
                dataToCal = dataToCal.substring(0,dataToCal.length()-1);
                textQue.setText(dataToCal);
            }
            else{
                textQue.setText("");
            }
        }
        else if(buttonText.equals("=")){
            if(!textQue.getText().toString().equals("")){
                textQue.setText(textAnswer.getText().toString());
            }
            else{
            }
        }
        else {
            dataToCal = dataToCal + buttonText;
            textQue.setText(dataToCal);
        }

        String result = getResult(dataToCal);
        if(!result.equals("Err")){
            textAnswer.setText(result);
        }

    }

    String getResult(String data){
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initSafeStandardObjects();
            String result = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            if (result.endsWith(".0")) {
                result = result.replace(".0", "");
            }
            if (result.contains(".")) {
                int index = result.indexOf(".");
                result = result.substring(0, index + 3);
            }
            return result;
        }
        catch (Exception e){
            return "Err";
        }
    }
}