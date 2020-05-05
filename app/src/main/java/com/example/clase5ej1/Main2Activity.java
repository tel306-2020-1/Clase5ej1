package com.example.clase5ej1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Spinner spinner2 = findViewById(R.id.spinner2);
        String[] listaCelulares = {"Iphone", "Samsung", "Nokia", "BB"};

        ArrayAdapter<String> adaptarSpinner = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                listaCelulares);


        spinner2.setAdapter(adaptarSpinner);


        SeekBar seekBar1 = findViewById(R.id.seekBar);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("seekbarN", String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ((SeekBar) findViewById(R.id.seekBar2)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("seekbarD", String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void verificarToggleBtn(View view) {
        ToggleButton toggleButton = (ToggleButton) view;
        Log.d("estadoTb", String.valueOf(toggleButton.isChecked()));
    }

    public void mostrarEditTextNombre(View view) {
        EditText editTextNombre = findViewById(R.id.editTextNombre);

        CheckBox checkBox1 = findViewById(R.id.checkBox);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        RadioButton radioButton1 = findViewById(R.id.radioButton);
        RadioButton radioButton2 = findViewById(R.id.radioButton2);

        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        Switch sw = findViewById(R.id.switch1);

        Log.d("estadoC1", String.valueOf(checkBox1.isChecked()));
        Log.d("estadoC2", String.valueOf(checkBox2.isChecked()));
        Log.d("estadoR1", String.valueOf(radioButton1.isChecked()));
        Log.d("estadoR2", String.valueOf(radioButton2.isChecked()));
        Log.d("estadoTb", String.valueOf(toggleButton.isChecked()));
        Log.d("estadoSw", String.valueOf(sw.isChecked()));


        if (editTextNombre.getText().length() == 0) {
            //editTextNombre.setError("Debe llenar el texto");
            TextView textViewNombreError = findViewById(R.id.textViewErrorNombre);
            textViewNombreError.setText("Debe llenar el texto");
            textViewNombreError.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(this, editTextNombre.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
