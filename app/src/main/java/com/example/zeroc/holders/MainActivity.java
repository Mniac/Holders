package com.example.zeroc.holders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE = 1;
    private static TheHolders TH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Activity para instalar la aplicacion //controlar first Run
        System.out.println("EJECUTANDO INSTALADOR");
        Intent subActividad = new Intent( MainActivity.this, Instalador.class );
        MainActivity.this.startActivityForResult( subActividad, REQUEST_CODE );

        System.out.println("");
        TH = new TheHolders(this);
        Button btNew = (Button) this.findViewById( R.id.btnMain2 );
        Button btOptions = (Button) this.findViewById( R.id.btnMain3 );
        Button btPoints = (Button) this.findViewById( R.id.btnMain4 );

        System.out.println("CARGANDO HISTORIAS");

        btNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("ANTES DE INICIAR");
                iniciarJuego();
            }
        });

        btOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent subActividad = new Intent( MainActivity.this, options_menu.class );

                MainActivity.this.startActivityForResult( subActividad, REQUEST_CODE );
            }
        });

        btPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent subActividad = new Intent( MainActivity.this, vista_puntuaciones.class );

                MainActivity.this.startActivityForResult( subActividad, REQUEST_CODE );
            }
        });
    }

    private void iniciarJuego(){
        this.startActivity( new Intent( this, TheHolders.class ) );

    }

    public void cargarVistaSimple(String texto){
        Intent subActividad = new Intent( MainActivity.this, in_game.class );
        subActividad.putExtra("texto",texto);
        MainActivity.this.startActivityForResult( subActividad, REQUEST_CODE );

    }

    public int cargarVistaSelect(String texto, ArrayList<String> opciones){
        Intent subActividad = new Intent( MainActivity.this, selection_game.class );
        subActividad.putExtra("texto",texto);
        subActividad.putExtra("numOp" ,opciones.size());
        for(int i = 0; i < opciones.size(); i++)
            subActividad.putExtra(("op"+i) ,opciones.get(i));
        MainActivity.this.startActivityForResult( subActividad, REQUEST_CODE );
        return REQUEST_CODE;
    }

}
