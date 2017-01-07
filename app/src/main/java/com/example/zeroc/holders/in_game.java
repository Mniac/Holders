package com.example.zeroc.holders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by zeroc on 13/12/2016.
 */

public class in_game extends MainActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// Indica el layout para esta actividad.
// El archivo de layout se guarda en res/layout/layout_actividad2.xml
        this.setContentView( R.layout.selection_game);
        Intent data = this.getIntent();
        TextView textView4 = (TextView) findViewById(R.id.textView);
        textView4.setText(data.getExtras().get("texto").toString());
    }

}
