package com.example.zeroc.holders;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class Historia implements  java.io.Serializable{

	private static final long serialVersionUID = 1L;
	public String titulo;
	public Inicio inicio;
	public java.util.ArrayList<Bloque> bloques = new ArrayList<>();
	public String fin;

	public Historia(String titulo) {
		this.titulo= titulo;
		bloques = new ArrayList<>();
	}

	public void setInicio(String pais, String ciudad, boolean institucion){
		this.inicio = new Inicio(pais,ciudad,institucion,titulo);
	}
	public void addBloque(Bloque bloque){
		bloques.add(bloque);
	}


	public String getFin() {
		return fin;
	}
	public String getTitulo() {
		return titulo;
	}

}


