package com.example.zeroc.holders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

public class TheHolders {

	private static String[] titulos= {"The Holder of the Ambition","The Holder of the End","The Holder of the Present","The Holder of the Rage"};
	private HashMap<String,Historia> historias = new HashMap<>();
	private ArrayList<String> historiasPendientes = new ArrayList<>();
	private boolean modoSurvive = true;
	private List<Puntuacion> puntuaciones = new ArrayList<>();
	private String nombre;
	
	public TheHolders() {
		for (String titulo : titulos) 
			historiasPendientes.add(titulo);
		
		cargarHistorias();
		
		puntuaciones.add(new Puntuacion("pepe9", 0));
		puntuaciones.add(new Puntuacion("pepe8", 1));
		puntuaciones.add(new Puntuacion("pepe7", 2));
		puntuaciones.add(new Puntuacion("pepe6", 3));
		puntuaciones.add(new Puntuacion("pepe5", 4));
		puntuaciones.add(new Puntuacion("pepe4", 5));
		
	}
	public void addHistoria(String titulo) {
		Historia aux = new Historia(titulo);
		try {
			aux.read();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		historias.put(titulo, aux);
	}
	public void cargarHistorias() {
		for (String string : historiasPendientes) {
			addHistoria(string);
		}
	}
	
	public String start(){
		int random = (int) (Math.random()*historiasPendientes.size());
		Historia hActual = historias.get(historiasPendientes.get(random));
		hActual.ejecutar();
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
		JOptionPane.showMessageDialog(null, "Bienvenido a The Holders");
		while(!historiasPendientes.isEmpty()){
			start();
			JOptionPane.showMessageDialog(null, "Tienes "+(titulos.length-historiasPendientes.size())+" Holders de "+titulos.length+", nunca deben ser reunidos.");
			
		}
		puntuaciones.add(new Puntuacion(nombre, titulos.length-historiasPendientes.size()));
	}
	
	public static void main(String[] args) {
		new TheHolders().iniciarJuego();
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

	
	   
	
}


