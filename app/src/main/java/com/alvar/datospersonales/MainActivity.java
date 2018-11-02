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

//Resources res= getResources();
//String[]estadoCivil = res.getStringArray(R.array.estadoCivil);
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = (EditText) findViewById(R.id.editTextNombre);
        editTextApellidos = (EditText) findViewById(R.id.editTextApellidos);
        editTextEdad = (EditText) findViewById(R.id.editTextEdad);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButtonHombre = (RadioButton) findViewById(R.id.radioButtonHombre);
        radioButtonMujer =(RadioButton) findViewById(R.id.radioButtonMujer);

        switchHijos = (Switch) findViewById(R.id.switchHijos);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
        btnlimpiar = (Button) findViewById(R.id.btnLimpiar);

        //ArrayAdapter<String> estadoCivil = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, R.string.estadoCivil);


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

    }
}
