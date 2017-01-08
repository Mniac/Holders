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
        System.out.println(getFilesDir()+"EJECUTANDO INSTALADOR");
        this.startActivity( new Intent( this, Instalador.class ) );

        System.out.println("Cosas nazis");

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
        this.startActivityForResult( new Intent( this, TheHolders.class ), REQUEST_CODE);

    }
}
