package com.example.zeroc.holders;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

/**
 * Created by zeroc on 13/12/2016.
 */

public class options_menu extends MainActivity {
    private Switch mySwitch;
    private String nombre;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// Indica el layout para esta actividad.
// El archivo de layout se guarda en res/layout/layout_actividad2.xml
        this.setContentView( R.layout.options_menu);

        SharedPreferences prefs = this.getSharedPreferences("opciones", Context.MODE_PRIVATE );

        mySwitch = (Switch) findViewById(R.id.switch1);

         boolean survive = prefs.getBoolean("modo",false);

        mySwitch.setChecked(survive);

        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mySwitch.setChecked(true);
                    setModo(true);
                }else{
                    mySwitch.setChecked(false);
                    setModo(false);
                }
            }
        });

        EditText edText1 = (EditText) findViewById(R.id.editText);
        edText1.setText(prefs.getString("nombre","player"));
        edText1.setInputType(InputType.TYPE_CLASS_TEXT);


        edText1.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                setPerfil();
                return false;
            }
        });

    }

    private void setModo(boolean modo){
        SharedPreferences prefs = this.getSharedPreferences("opciones", Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("modo",modo);
        editor.apply();
        System.out.println("modo -> " + modo);
    }
    private void setPerfil(){
        EditText edText1 = (EditText) findViewById(R.id.editText);
        nombre = edText1.getText().toString();
        SharedPreferences prefs = this.getSharedPreferences("opciones", Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("nombre",nombre);
        editor.apply();
        System.out.println("nombre -> " + nombre);

    }
}
