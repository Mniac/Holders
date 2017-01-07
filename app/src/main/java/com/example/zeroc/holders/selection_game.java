package com.example.zeroc.holders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by zeroc on 13/12/2016.
 */

public class selection_game extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Indica el layout para esta actividad.
        // El archivo de layout se guarda en res/layout/layout_actividad2.xml
        this.setContentView( R.layout.selection_game);
        Intent data = this.getIntent();
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setText(data.getExtras().get("texto").toString());
        Button btnOp1 = (Button) findViewById(R.id.btnOp1);
        btnOp1.setText(data.getExtras().get("op0").toString());
        Button btnOp2 = (Button) findViewById(R.id.btnOp2);
        btnOp2.setText(data.getExtras().get("op2").toString());
    }

}