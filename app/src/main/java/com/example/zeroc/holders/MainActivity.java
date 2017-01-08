package com.example.zeroc.holders;

import android.content.Intent;
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
    private HashMap<String,Historia> historias = new HashMap<>();
    private ArrayList<String> historiasPendientes = new ArrayList<>();
    private boolean modoSurvive = true;
    private List<Puntuacion> puntuaciones = new ArrayList<>();
    private String nombre;
    private final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Activity para instalar la aplicacion //controlar first Run
        this.startActivity( new Intent( this, Instalador.class ) );
        Button btNew = (Button) this.findViewById( R.id.btnMain2 );
        Button btOptions = (Button) this.findViewById( R.id.btnMain3 );
        Button btPoints = (Button) this.findViewById( R.id.btnMain4 );
        btNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("CARGAR HISTORIAS()");
                cargarHistorias();
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
                MainActivity.this.startActivityForResult( subActividad, REQUEST_CODE );
            }
        });
    }

    public void cargarHistorias() {
        for (String titulo : titulos)
            historiasPendientes.add(titulo);
        for (String string : historiasPendientes)
            addHistoria(string);

    }

    public void addHistoria(String titulo) {
        try {
            Historia aux = readHist(titulo);
            historias.put(titulo, aux);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public String start(){
        int random = (int) (Math.random()*historiasPendientes.size());
        Historia hActual = historias.get(historiasPendientes.get(random));
        ejecutar(hActual);
        if(modoSurvive && hActual.getFin().equals("muerto")){
            for (String titulo : titulos)
                historiasPendientes.add(titulo);
        }
        if(hActual.getFin().equals("vivo")){
            historiasPendientes.remove(hActual.getTitulo());
        }
        return hActual.getFin();
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
        while(!historiasPendientes.isEmpty()){
            start();
            //JOptionPane.showMessageDialog(null, "Tienes "+(titulos.length-historiasPendientes.size())+" Holders de "+titulos.length+", nunca deben ser reunidos.");
        }
        puntuaciones.add(new Puntuacion(nombre, titulos.length-historiasPendientes.size()));
    }

    public void ordenarPorFecha(){
        Collections.sort(puntuaciones, new Comparator<Puntuacion>(){
            public int compare(Puntuacion object1, Puntuacion object2) {
                return object1.getFecha().compareTo(object2.getFecha());
            }
        });
    }

    public void ordenarPorNombre(){

        Collections.sort(puntuaciones, new Comparator<Puntuacion>(){
            public int compare(Puntuacion object1, Puntuacion object2) {
                return object1.getNombre().compareTo(object2.getNombre());
            }
        });
    }

    private void setSurvive(boolean survival) {
        modoSurvive= survival;
    }

    private Historia readHist(String titulo) throws IOException, ClassNotFoundException {
        System.out.println("\tCargando: "+titulo+".holder");
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

    public void cargarVistaSimple(String texto){
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


    public void ejecutar(Historia h){
        System.out.println("\tIniciando Historia " + h.titulo);
        cargarVistaSimple(h.inicio.getTexto());
        h.fin = "vivo";
        Bloque actual = h.bloques.get(0);
        while (h.fin.equals("vivo")) {
            ejecutar(actual);
            h.fin = actual.getFin();
            if(actual.getSiguiente() == null)
                break;
            actual = actual.getSiguiente();
        }
        System.out.println("\tFIN Historia " + h.titulo);
        switch (h.fin) {
            case "vivo":
                //JOptionPane.showMessageDialog(null, "Has sobrevivido");
                break;
            case "muerto":
                //JOptionPane.showMessageDialog(null, "Has muerto");
                break;
            case "huye":
                //JOptionPane.showMessageDialog(null, "Has huido");
                break;
        }
    }
    public void ejecutar(Bloque b){
        switch (b.tipo) {
            case "decision":
                System.out.println("\t\t BLOQUE DECISION");
                int i = cargarVistaSelect(b.texto,b.opciones);
                b.siguiente = b.opcionSiguiente.get(i);
                b.fin = b.opcionFin.get(i);
                break;
            case "simple":
                System.out.println("\t\t BLOQUE SIMPLE");
                cargarVistaSimple(b.texto);
                b.siguiente = b.opcionSiguiente.get(0);
                b.fin = b.opcionFin.get(0);
                break;
            case "random":
                System.out.println("\t\t BLOQUE RANDOM");
                cargarVistaSimple(b.texto);
                int random = (int) (Math.random() * b.opciones.size());
                b.siguiente = b.opcionSiguiente.get(random);
                b.fin = b.opcionFin.get(random);
                break;
            default:
                System.err.println("tipo de bloque erroneo");
                break;
        }
    }
}
