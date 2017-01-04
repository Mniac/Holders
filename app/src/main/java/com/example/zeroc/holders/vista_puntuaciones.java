package com.example.zeroc.holders;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by zeroc on 13/12/2016.
 */

public class vista_puntuaciones extends MainActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// Indica el layout para esta actividad.
// El archivo de layout se guarda en res/layout/layout_actividad2.xml
        this.setContentView( R.layout.vista_puntuaciones);
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu( menu );
        this.getMenuInflater().inflate( R.menu.puntuaciones_menu, menu );
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        boolean toret = false;
        switch( menuItem.getItemId() ) {
            case R.id.opNombre:
                this.ordenaNombre();
                toret = true;
                break;
            case R.id.opPuntos:
                this.ordenaPuntos();
                toret = true;
                break;
        }
    }
