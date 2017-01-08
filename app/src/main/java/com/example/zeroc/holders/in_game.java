package com.example.zeroc.holders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by zeroc on 13/12/2016.
 */

public class in_game extends MainActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Indica el layout para esta actividad.
        // El archivo de layout se guarda en res/layout/layout_actividad2.xml
        System.out.println("ANTES DE ASIGNAR LAYOUT");
        this.setContentView( R.layout.in_game);

        System.out.println("ANTES DE INTENT");
        Intent data = this.getIntent();
        System.out.println("ANTES DE ASIGNAR TEXTVIEW");
        TextView textView4 = (TextView) findViewById(R.id.textView);
        System.out.println("ANTES DE ASIGNAR TEXTO A TEXT VIEW");
        //textView4.setText((String)data.getExtras().get("texto"));
        System.out.println("ANTES DE BOTON");

        Button btnAceptar = (Button) this.findViewById( R.id.btnOp3 );

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("PULSANDO BOTON");
                finish();
            }
        });

    }

}
