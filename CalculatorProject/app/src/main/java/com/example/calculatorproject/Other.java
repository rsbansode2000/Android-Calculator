package com.example.calculatorproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Other extends Fragment {
    CardView cardViewBMI, cardViewUnitConverter, cardViewLinearEquation, cardViewInterest, cardViewMatrices;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_other, container, false);
        cardViewBMI = view.findViewById(R.id.cardViewBMI);
        cardViewUnitConverter = view.findViewById(R.id.cardViewUnitConverter);
        cardViewLinearEquation = view.findViewById(R.id.cardViewLinearEquation);
        cardViewInterest = view.findViewById(R.id.cardViewInterest);
        cardViewMatrices = view.findViewById(R.id.cardViewMatrices);
        onClick();
        return view;
    }

    public void onClick(){
        MainActivity mainActivity = (MainActivity) getActivity();

        cardViewMatrices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainActivity,Matrices_Activity.class);
                startActivity(intent);
            }
        });

        cardViewInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainActivity,IntrestCalculator_Activity.class);
                startActivity(intent);
            }
        });

        cardViewBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainActivity,BMI_Activity.class);
                startActivity(intent);
            }
        });

        cardViewUnitConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainActivity,Unit_Converter_Activity.class);
                startActivity(intent);
            }
        });

        cardViewLinearEquation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainActivity,LinearEquation_Activity.class);
                startActivity(intent);
            }
        });

    }

}