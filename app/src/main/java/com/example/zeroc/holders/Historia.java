package com.example.zeroc.holders;

import android.content.Context;

import java.io.*;
import java.util.ArrayList;

public class Historia implements  java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String titulo;
	private Inicio inicio;
	private java.util.ArrayList<Bloque> bloques = new ArrayList<>();
	private String fin;
	private TheHolders theHolders;

	public Historia(String titulo) {
		this.titulo= titulo;
		bloques = new ArrayList<>();
	}

	public Historia(String titulo,TheHolders theHolders) {
		this.titulo= titulo;
		this.theHolders = theHolders;
		bloques = new ArrayList<>();
	}

	public void setInicio(String pais, String ciudad, boolean institucion){
		this.inicio = new Inicio(pais,ciudad,institucion,titulo,theHolders);;
	}
	public void addBloque(Bloque bloque){

		bloques.add(bloque);
		bloque.setTheHolders(theHolders);
	}


	public void ejecutar(){
		if(inicio == null)
		System.out.println("CARGANDO null");

		inicio.ejecutar();
		fin = "vivo";
		System.out.println();
		Bloque actual = bloques.get(0);
		while (fin.equals("vivo")) {
			actual.ejecutar();
			fin = actual.getFin();
			if(actual.getSiguiente() == null)
				break;
			actual = actual.getSiguiente();
		}

		switch (fin) {
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

	public String getFin() {
		return fin;
	}
	public String getTitulo() {
		return titulo;
	}
}


