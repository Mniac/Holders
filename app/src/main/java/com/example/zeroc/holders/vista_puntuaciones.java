package com.example.zeroc.holders;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by zeroc on 13/12/2016.
 */

public class vista_puntuaciones extends MainActivity {

    private ArrayList<Puntuacion> puntuaciones;
    private TextView textView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Indica el layout para esta actividad.
        // El archivo de layout se guarda en res/layout/layout_actividad2.xml
        this.setContentView(R.layout.vista_puntuaciones);
        puntuaciones = toPuntuacionList(getIntent().getExtras().getStringArrayList("puntuaciones"));
        textView = (TextView) this.findViewById(R.id.textView5);
        textView.setText(puntuacionToString());

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        this.getMenuInflater().inflate(R.menu.puntuaciones_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean toret = false;
        switch (menuItem.getItemId()) {
            case R.id.opNombre:
                ordenarPorNombre();
                toret = true;
                break;
            case R.id.opFecha:
                ordenarPorFecha();
                toret = true;
                break;
            case R.id.opPuntos:
                ordenarPorPuntos();
                toret = true;
                break;
        }
        return toret;
    }
    private ArrayList<Puntuacion> toPuntuacionList(ArrayList<String> puntuaciones){
        ArrayList<Puntuacion> toret = new ArrayList<>();
        for (String actual : puntuaciones) {
            toret.add(new Puntuacion(actual));
        }
        return toret;
    }

    public String puntuacionToString() {
        StringBuilder toret = new StringBuilder();
        toret.append("Nombre --- Fecha --- Puntuación\n\n");
        for (Puntuacion actual : puntuaciones) {
            toret.append(actual.toString()+"\n\n");
        }
        System.out.println(toret.toString());
        return toret.toString();
    }
    public void ordenarPorFecha(){
        System.out.println("Ordenado por fesha");
        Collections.sort(puntuaciones, new Comparator<Puntuacion>(){
            public int compare(Puntuacion object1, Puntuacion object2) {
                return object1.getFecha().compareTo(object2.getFecha());
            }
        });
        textView.setText(puntuacionToString());
    }

    public void ordenarPorNombre(){
        System.out.println("Ordenado por nombre");
        Collections.sort(puntuaciones, new Comparator<Puntuacion>(){
            public int compare(Puntuacion object1, Puntuacion object2) {
                return object1.getNombre().compareTo(object2.getNombre());
            }
        });

        textView.setText(puntuacionToString());
    }

    public void ordenarPorPuntos(){
        System.out.println("Ordenado por puntos");
        Collections.sort(puntuaciones, new Comparator<Puntuacion>(){
            public int compare(Puntuacion object1, Puntuacion object2) {
                return object1.getHoldersConseguidos()-object2.getHoldersConseguidos();
            }
        });

        textView.setText(puntuacionToString());
    }
}
