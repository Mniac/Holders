package com.example.zeroc.holders;

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
        System.out.println();
        this.setContentView( R.layout.selection_game);

        System.out.println();
        Intent data = this.getIntent();
        System.out.println();
        TextView textView4 = (TextView) findViewById(R.id.textView);
        System.out.println();
        textView4.setText(data.getExtras().get("texto").toString());
        System.out.println();

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
