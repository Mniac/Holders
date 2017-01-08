package com.example.zeroc.holders;

import java.util.ArrayList;


public class Bloque implements  java.io.Serializable{

	private static final long serialVersionUID = 1L;
	public String tipo;
	public String texto;
	public ArrayList<String> opciones = new ArrayList<>();
	public ArrayList<String> opcionFin = new ArrayList<>();
	public ArrayList<Bloque> opcionSiguiente = new ArrayList<>();
	public Bloque siguiente;
	public String fin;
	
	
	public Bloque(String tipo) {
		this.tipo = tipo;
	}
	

	public void addOpcion(String opcion,Bloque siguienteBloque, String fin) {
		this.opciones.add(opcion);
		this.opcionFin.add(fin);
		this.opcionSiguiente.add(siguienteBloque);
	}
	
	public Bloque getSiguiente() {
		return siguiente;
	}

	public String getFin() {
		return fin;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
