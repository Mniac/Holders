package com.example.zeroc.holders;

import java.io.*;
import java.util.ArrayList;

public class Historia implements  java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private String titulo;
	private Inicio inicio;
	private java.util.ArrayList<Bloque> bloques = new ArrayList<>();
	private String fin;
	private MainActivity mainActivity;

	public Historia(String titulo) {
		this.titulo= titulo;
		bloques = new ArrayList<>();
	}
	
	public Historia(String titulo,MainActivity mainActivity) {
		this.titulo= titulo;
		this.mainActivity = mainActivity;
		bloques = new ArrayList<>();
	}

	public void setInicio(String pais, String ciudad, boolean institucion){
		this.inicio = new Inicio(pais,ciudad,institucion,titulo,mainActivity);;
	}
	public void addBloque(Bloque bloque){

		bloques.add(bloque);
		bloque.setMainActitivy(mainActivity);
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
	public Object getTitulo() {
		return titulo;
	}
}


