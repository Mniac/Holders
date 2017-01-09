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
        this.setContentView( R.layout.in_game);

        Intent data = this.getIntent();
        TextView textView4 = (TextView) findViewById(R.id.textView);
        textView4.setText(data.getExtras().getString("texto"));
        final int inicio = data.getExtras().getInt("inicio");

        Button btnAceptar = (Button) this.findViewById( R.id.btnOp3 );
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //System.out.print("PULSANDO BOTON ->");
                switch (inicio) {
                    case 1:
                        //System.out.println("\tresult 3");
                        setResult(3);
                        break;
                    case 2:
                        //System.out.println("\tresult 4");
                        setResult(4);
                        break;
                    case 5:
                        setResult(((int) (Math.random()*2))+1);
                        break;
                   default: setResult(1);//System.out.println("\tresult 1");
                       break;
                }


                finish();
            }
        });

    }

}
