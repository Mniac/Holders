package com.example.zeroc.holders;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static String[] titulos= {"The Holder of the Ambition","The Holder of the End","The Holder of the Present","The Holder of the Rage"};
    private String pendientes;
    private boolean modoSurvive;
    private List<Puntuacion> puntuaciones = new ArrayList<>();
    private String nombre;
    private final int REQUEST_CODE = 1;
    private Historia hActual;
    private Bloque actual;
    private boolean iniciado;
    private char[] pendientesArray;
    private int numHistoriaActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = this.getSharedPreferences("opciones", Context.MODE_PRIVATE );
        boolean install = prefs.getBoolean("instalado",false);
        nombre = prefs.getString("nombre","player");

        //System.out.println("modo ->"+ modoSurvive);
        if(!install){
            System.out.println("Instalado");
            this.startActivity( new Intent( this, Instalador.class ) );
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("instalado",true);
            editor.apply();


        }
        puntuaciones.add(new Puntuacion("Jose",1));
        puntuaciones.add(new Puntuacion("Baltasar",2));
        puntuaciones.add(new Puntuacion("Melchor",3));
        puntuaciones.add(new Puntuacion("Dabaixo",4));
        puntuaciones.add(new Puntuacion("Vilares",5));
        puntuaciones.add(new Puntuacion("Nani",6));
        puntuaciones.add(new Puntuacion("Lourdes",7));
        puntuaciones.add(new Puntuacion("Gaspar",8));

        Button btCont = (Button) this.findViewById( R.id.btnMain1 );
        Button btNew = (Button) this.findViewById( R.id.btnMain2 );
        Button btOptions = (Button) this.findViewById( R.id.btnMain3 );
        Button btPoints = (Button) this.findViewById( R.id.btnMain4 );
        btCont.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = MainActivity.this.getSharedPreferences("opciones", Context.MODE_PRIVATE );
                modoSurvive = prefs.getBoolean("modo",false);
                pendientes = prefs.getString("pendientes",pendientes);

                System.out.println("CONTINUAR JUEGO()");
                iniciarJuego();
            }
        });
        btNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences prefs = MainActivity.this.getSharedPreferences("opciones", Context.MODE_PRIVATE );
                modoSurvive = prefs.getBoolean("modo",false);
                pendientes = "";
                for (int i = 0; i < titulos.length ; i++) {
                    pendientes = pendientes + i;
                }

                System.out.println("INICIAR JUEGO()");
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
                subActividad.putExtra("puntuaciones",toArrayString(puntuaciones));
                MainActivity.this.startActivityForResult( subActividad, REQUEST_CODE );
            }
        });
    }



    public void addHistoria(String titulo) {
        try {
             hActual = readHist(titulo);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        System.out.println("\tIniciando Historia " + hActual.titulo);
        iniciado = false;
        hActual.fin = "vivo";
        actual = hActual.bloques.get(0);
        ejecutar(hActual);
    }


    public void guardar(){
        //guardar historiasPendientes
        //guardar modoSurvive
    }
    public void recuperar() {
        //cargar historiasPendientes
        //cargar modoSurvive
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void iniciarJuego() {
        if(!pendientes.equals("")){

            numHistoriaActual = Integer.parseInt(""+pendientes.toCharArray()[(int)(Math.random()*pendientes.length())]);
            addHistoria(titulos[numHistoriaActual]);
            start();
            //JOptionPane.showMessageDialog(null, "Tienes "+(titulos.length-historiasPendientes.size())+" Holders de "+titulos.length+", nunca deben ser reunidos.");
        }else{
            puntuaciones.add(new Puntuacion(nombre, titulos.length-pendientes.length()));
            cargarVistaSimple("Has Ganado",6);
        }

    }

    private Historia readHist(String titulo) throws IOException, ClassNotFoundException {
        //System.out.println("\tCargando: "+titulo+".holder");
        //Creamos un fujo de entrada a disco, pasándole el nombre del archivo en disco o un objeto de la clase File.

        FileInputStream fileIn= this.openFileInput(titulo+".holder");

        //El fujo de entrada ObjectInputStream es el que procesa los datos y se ha de vincular a un objeto fileIn de la clase FileInputStream.
        ObjectInputStream entrada= new ObjectInputStream(fileIn);

        //El método readObject lee los objetos del flujo de entrada, en el mismo orden en el que ha sido escritos.
        Historia aux = (Historia) entrada.readObject();

        //Finalmente, se cierra los flujos
        entrada.close();

        return aux;
        // System.out.println("LEIDO");

    }

    public void cargarVistaSimple(String texto,int inicio){
        Intent subActividad = new Intent( MainActivity.this, in_game.class );
        subActividad.putExtra("texto",texto);
        subActividad.putExtra("inicio",inicio);
        MainActivity.this.startActivityForResult( subActividad, REQUEST_CODE );
    }

    public void cargarVistaInicio(String texto){
        Intent subActividad = new Intent( MainActivity.this, in_game.class );
        subActividad.putExtra("texto",texto);
        MainActivity.this.startActivityForResult( subActividad, REQUEST_CODE );
    }

    public int cargarVistaSelect(String texto, ArrayList<String> opciones){
        Intent subActividad = new Intent( this, selection_game.class );
        subActividad.putExtra("texto",texto);
        subActividad.putExtra("numOp" ,opciones.size());
        for(int i = 0; i < opciones.size(); i++)
            subActividad.putExtra(("op"+i) ,opciones.get(i));
        this.startActivityForResult( subActividad, REQUEST_CODE );
        return REQUEST_CODE;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if ( requestCode == REQUEST_CODE) {
            switch (resultCode) {
                case 1:
                    actual.siguiente = actual.opcionSiguiente.get(0);
                    actual.fin = actual.opcionFin.get(0);
                    hActual.fin = actual.fin;
                    actual =actual.getSiguiente();
                    ejecutar(hActual);
                    break;
                case 2:
                    actual.siguiente = actual.opcionSiguiente.get(1);
                    actual.fin = actual.opcionFin.get(1);
                    hActual.fin = actual.fin;
                    actual =actual.getSiguiente();
                    ejecutar(hActual);
                    break;
                case 3:
                    actual.siguiente = actual.opcionSiguiente.get(0);
                    actual.fin = actual.opcionFin.get(0);
                    hActual.fin = actual.fin;
                    ejecutar(hActual);
                    break;
                case 4:

                    if(hActual.fin.equals("vivo")) {
                        SharedPreferences prefs = this.getSharedPreferences("opciones", Context.MODE_PRIVATE );
                        SharedPreferences.Editor editor = prefs.edit();
                        String pendientesDespues = pendientes.replace(""+numHistoriaActual,"");
                        editor.putString("pendientes",pendientesDespues);
                        System.out.println(pendientes+" replace("+numHistoriaActual+")-> "+pendientesDespues);
                        pendientes = prefs.getString("pendientes",pendientes);
                        //.out.println("guardado: "+pendientes);
                        editor.apply();
                    }
                    //System.out.println(modoSurvive + "  -  "+hActual.fin );
                    if(modoSurvive && hActual.fin.equals("muerto")) {
                        SharedPreferences prefs = this.getSharedPreferences("opciones", Context.MODE_PRIVATE );
                        SharedPreferences.Editor editor = prefs.edit();
                        String aux = "";
                        for (int i = 0; i < titulos.length ; i++) {
                            aux = aux + i;
                        }
                        editor.putString("pendientes",aux);
                       // System.out.println("Reiniciando pendientes: "+aux);
                        editor.apply();
                        puntuaciones.add(new Puntuacion(nombre, titulos.length-pendientes.length()));
                        System.out.println("Insertando Puntuacion: "+puntuaciones.get(puntuaciones.size()-1));
                    }

                    String text = " \nTienes "+(titulos.length-pendientes.length())+" Holders de "+titulos.length+", nunca deben ser reunidos.";
                    cargarVistaSimple(text,6);
                   break;
            }
        }
    }



    public void ejecutar(Historia h){

        if(!iniciado){
            iniciado = true;
            cargarVistaSimple(h.inicio.getTexto(),1);
        }

        else{
            if( actual != null && h.getFin().equals("vivo"))
                ejecutar(actual);
            else{
                System.out.println("\tFIN Historia " + h.titulo);
                switch (h.fin) {
                    case "vivo":
                        cargarVistaSimple("Has conseguido el Holder",2);
                        break;
                    case "muerto":
                        cargarVistaSimple("Has muerto",2);
                        break;
                    case "huye":
                        cargarVistaSimple("Has huido",2);
                        break;
                }
            }
        }
    }
    public void ejecutar(Bloque b){
        switch (b.tipo) {
            case "decision":
                //System.out.println("\t\t BLOQUE DECISION");
                cargarVistaSelect(b.texto,b.opciones);
                break;
            case "simple":
                //System.out.println("\t\t BLOQUE SIMPLE");
                cargarVistaSimple(b.texto,0);
                break;
            case "random":
                //System.out.println("\t\t BLOQUE RANDOM");
                cargarVistaSimple(b.texto,5);
                break;
            default:
                System.err.println("tipo de bloque erroneo");
                break;
        }
    }
    private ArrayList<String> toArrayString(List<Puntuacion> puntuaciones){
        ArrayList<String> toret = new ArrayList<>();
        for (Puntuacion actual : puntuaciones) {
            toret.add(actual.formaString());
        }
        return toret;
    }
}
