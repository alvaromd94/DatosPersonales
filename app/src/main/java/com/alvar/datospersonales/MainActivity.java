package com.alvar.datospersonales;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    int edad=0;
    String genero="";
    String tieneHijos="";
    String mayoriaEdad="";
    String cadenaNombre="";
    String cadenaApellidos="";
    String cadenaEdad="";
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
        radioButtonHombre.setChecked(true);

       ArrayAdapter adaptador = ArrayAdapter.createFromResource(this, R.array.estadoCivil,R.layout.support_simple_spinner_dropdown_item);
        final Spinner spinnerEstadoCivil = findViewById(R.id.spinnerEstadoCivil);
        spinnerEstadoCivil.setAdapter(adaptador);

        btnlimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNombre.setText("");
                editTextApellidos.setText("");
                editTextEdad.setText("");
                radioButtonMujer.setChecked(false);
                switchHijos.setChecked(false);
                textViewResultado.setText("");
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!editTextNombre.getText().toString().isEmpty()&&!editTextApellidos.getText().toString().isEmpty()&&!editTextEdad.getText().toString().isEmpty())
                {
                    textViewResultado.setTextColor(getResources().getColor(R.color.Negro));
                    Log.i("App", "Posición" + spinnerEstadoCivil.getSelectedItemPosition() + "Estado Civil"+ spinnerEstadoCivil.getSelectedItem().toString());
                    edad = Integer.parseInt(editTextEdad.getText().toString());
                    mayoriaEdad = (edad>=18)? "mayor de edad" : "menor de edad";
                    genero = (radioButtonHombre.isChecked())?"hombre" :"mujer";
                    tieneHijos = (switchHijos.isChecked()?"con hijos" : "sin hijos");

                    textViewResultado.setText( editTextApellidos.getText() + ", " + editTextNombre.getText() + ", " + mayoriaEdad + ", " + genero + ", " + spinnerEstadoCivil.getSelectedItem() + " y " + tieneHijos + ".");
                }

                else{
                    textViewResultado.setTextColor(getResources().getColor(R.color.Rojo));

                    if(editTextNombre.getText().toString().isEmpty())
                    {
                        cadenaNombre=getResources().getString(R.string.errorNombre);
                    }
                    if(editTextApellidos.getText().toString().isEmpty())
                    {
                        cadenaApellidos=getResources().getString(R.string.errorApellidos);
                    }
                    if(editTextEdad.getText().toString().isEmpty())
                    {
                        cadenaEdad=getResources().getString(R.string.errorEdad);
                    }
                    textViewResultado.setText(cadenaNombre + " " + cadenaApellidos + " " + cadenaEdad);

                }
                }

        });
    }
}
