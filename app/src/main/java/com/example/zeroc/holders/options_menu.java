package com.example.zeroc.holders;

import android.os.Bundle;
import android.text.InputType;
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

        mySwitch = (Switch) findViewById(R.id.switch1);

        mySwitch.setChecked(false);

        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if(isChecked){
                    mySwitch.setChecked(true);
                }else{
                    mySwitch.setChecked(false);
                }

            }
        });

        if(mySwitch.isChecked()){
            TH.setSurvive(true);
        }
        else {
            TH.setSurvive(false);
        }

        EditText edText1 = (EditText) findViewById(R.id.editText);

        edText1.setInputType(InputType.TYPE_CLASS_TEXT);

        nombre = edText1.getText().toString();
    }
}
