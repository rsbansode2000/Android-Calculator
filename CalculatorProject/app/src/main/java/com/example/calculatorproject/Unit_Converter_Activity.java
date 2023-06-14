package com.example.calculatorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Unit_Converter_Activity extends AppCompatActivity implements View.OnClickListener {
    Spinner spinner1, spinner2, spinnerOption;
    Button button, button1, button2, button3, buttonC, button4, button5, button6, button7,
            button8, button9, button0, buttonPoint, buttonAC;
    EditText input1;
    TextView input2;
    String unit1, unit2;
    ArrayAdapter<String> weightAdapter;
    ArrayAdapter<String> lengthAdapter;
    ArrayAdapter<String> temperatureAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinnerOption = findViewById(R.id.spinnerOption);

        allID();
        adapters();
        clickListner();
    }

    private void allID() {
        input1 = findViewById(R.id.editTextNumber1);
        input2 = findViewById(R.id.editTextNumber2);
        button = findViewById(R.id.buttonFindLength);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(this);
        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(this);
        button8 = findViewById(R.id.button8);
        button8.setOnClickListener(this);
        button9 = findViewById(R.id.buttonpoint9);
        button9.setOnClickListener(this);
        button0 = findViewById(R.id.button0);
        button0.setOnClickListener(this);
        buttonAC = findViewById(R.id.buttoncac);
        buttonAC.setOnClickListener(this);
        buttonPoint = findViewById(R.id.buttonpoint);
        buttonPoint.setOnClickListener(this);
        buttonC = findViewById(R.id.buttonc);
        buttonC.setOnClickListener(this);
    }

    private void adapters() {
        ArrayList<String> weight = new ArrayList<>();
        weight.add("kg");
        weight.add("gm");
        weight.add("lib");
        weight.add("gm");
        weightAdapter = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                weight);

        ArrayList<String> length = new ArrayList<>();
        length.add("m");
        length.add("km");
        length.add("cm");
        length.add("ft");
        length.add("inch");
        length.add("mile");
        length.add("yard");
        lengthAdapter = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                length);

        ArrayList<String> temperature = new ArrayList<>();
        temperature.add("deg. Cel");
        temperature.add("Farahanhite");
        temperatureAdapter = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                temperature);
    }

    public  void clickListner(){
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                unit1 = spinner1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                unit2 = spinner2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerOption.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {         // for weight spinner adapter
                if(spinnerOption.getSelectedItem().toString().equals("Length")){
                    spinner1.setAdapter(lengthAdapter);
                    spinner2.setAdapter(lengthAdapter);
                }
                if(spinnerOption.getSelectedItem().toString().equals("Weight")){
                    spinner1.setAdapter(weightAdapter);
                    spinner2.setAdapter(weightAdapter);
                }
                if(spinnerOption.getSelectedItem().toString().equals("Temperature")){
                    spinner1.setAdapter(temperatureAdapter);
                    spinner2.setAdapter(temperatureAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                                                           // calculate result
                if(spinnerOption.getSelectedItem().toString().equals("Length")){
                    float result1 = convertLength(unit1,unit2);
                    input2.setText(String.format("%.2f",result1).toString());
                }
                if(spinnerOption.getSelectedItem().toString().equals("Weight")){                    // weight result
                    float result1 = convertWeight(unit1,unit2);
                    input2.setText(String.format("%.2f",result1).toString());
                }
                if(spinnerOption.getSelectedItem().toString().equals("Temperature")){
                    float result1 = convertTemp(unit1,unit2);
                    input2.setText(String.format("%.2f",result1).toString());
                }
                input2.setBackgroundColor(Color.rgb(243,192,158));}
        });
    }

    public float convertLength(String unit1, String unit2){
        float ip1 = Float.parseFloat(input1.getText().toString());
        if(unit1.equals("m")){
            return calLength(ip1);
        }
        else if(unit1.equals("km")){
            return calLength(ip1*1000);
        }
        else if(unit1.equals("cm")){
            return calLength(ip1/100);
        }
        else if(unit1.equals("inch")){
            return calLength(ip1/39.3709f);
        }
        else if(unit1.equals("ft")){
            return calLength(ip1/3.28084f);
        }
        else if(unit1.equals("mile")){
            return calLength(ip1/0.000621371f);
        }
        else if(unit1.equals("yard")){
            return calLength(ip1/1.09361f);
        }
        return 0;
    }

    public  float calLength(float ip1){
        if(unit2.equals("m")){
            return ip1;
        }
        if(unit2.equals("km")){
            return ip1/1000;
        }
        if(unit2.equals("cm")){
            return ip1*100;
        }
        if(unit2.equals("ft")){
            return ip1*3.28084f;
        }
        if(unit2.equals("inch")){
            return ip1*39.3709f;
        }
        if(unit2.equals("mile")){
            return ip1*0.000621371f;
        }
        if(unit2.equals("yard")){
            return ip1*1.09361f;
        }
        return 0;
    }

    public float convertWeight(String unit1,String unit2){
        float ip1 = Float.parseFloat(input1.getText().toString());
        if(unit1.equals("kg")){
            return calculateWeight(ip1);
        }
        if(unit1.equals("gm")){
            return calculateWeight(ip1/1000);
        }
        return 0;
    }

    public float calculateWeight(float ip1){
        if(unit2.equals("kg")){
            return ip1;
        }
        if(unit2.equals("gm")){
            return ip1*1000;
        }
        return 0;
    }

    public float convertTemp(String unit1, String unit2){
        float ip1 = Float.parseFloat(input1.getText().toString());
        if(unit1.equals("deg. Cel")){
            return calculateTemp(ip1);
        }
        else if(unit1.equals("Farahanhite")){
            return calculateTemp((ip1-32)*5/9);
        }
        return 0;
    }

    public float calculateTemp(float ip1){
        if(unit2.equals("deg. Cel")){
            return ip1;
        }
        else if(unit2.equals("Farahanhite")){
            return (ip1*9/5)+32;
        }
        return 0;
    }

    @Override
    public void onClick(View v) {
        Button buttons = (Button) v;
        String input = input1.getText().toString();
        if(buttons.getText().toString().equals("C")){
            input1.setText(input.substring(0,input.length()-1));
        }
        else if(buttons.getText().toString().equals("AC")){
            input1.setText("");
        }
        else {
            input = input + buttons.getText().toString();
            input1.setText(input);
        }
    }
}