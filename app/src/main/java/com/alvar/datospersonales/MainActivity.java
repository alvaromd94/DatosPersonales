package com.alvar.datospersonales;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextNombre;
    EditText editTextApellidos;
    EditText editTextEdad;
    RadioGroup radioGroup;
    RadioButton radioButtonHombre;
    RadioButton radioButtonMujer;
    Spinner spinnerEstadoCivil;
    Switch switchHijos;
    Button btnMostrar;
    Button btnlimpiar;
    TextView textViewResultado;


    String[]estadoCivil ;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre =  findViewById(R.id.editTextNombre);
        editTextApellidos =  findViewById(R.id.editTextApellidos);
        editTextEdad =  findViewById(R.id.editTextEdad);
        radioGroup =  findViewById(R.id.radioGroup);
        radioButtonHombre =  findViewById(R.id.radioButtonHombre);
        radioButtonMujer = findViewById(R.id.radioButtonMujer);

        switchHijos =  findViewById(R.id.switchHijos);
        btnMostrar =  findViewById(R.id.btnMostrar);
        btnlimpiar =  findViewById(R.id.btnLimpiar);
        textViewResultado =  findViewById(R.id.textViewResultado);

       ArrayAdapter adaptador = ArrayAdapter.createFromResource(this, R.array.estadoCivil,R.layout.support_simple_spinner_dropdown_item);
        Spinner spinnerEstadoCivil = findViewById(R.id.spinnerEstadoCivil);
        spinnerEstadoCivil.setAdapter(adaptador);

        btnlimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNombre.setText("");
                editTextApellidos.setText("");
                editTextEdad.setText("");
                radioButtonMujer.setChecked(false);

                switchHijos.setEnabled(false);
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                textViewResultado.setText( "Nombre"+ editTextNombre.getText() + editTextApellidos.getText() + editTextEdad.getText());
            }
        });
    }
}
