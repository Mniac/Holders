package com.example.zeroc.holders;

import java.util.ArrayList;

public class Historia implements  java.io.Serializable{

	
	private static final long serialVersionUID = 1L;
	private String titulo;
	private Inicio inicio;
	private ArrayList<Bloque> bloques = new ArrayList<>();;
	private String fin;

	
	public Historia(String titulo) {	
		this.titulo= titulo;
		fin = "huye";
	}
	public void setInicio(String pais, String ciudad, boolean institucion){
		this.inicio = new Inicio(pais,ciudad,institucion,titulo);;
	}
	public void addBloque(Bloque bloque){
		bloques.add(bloque);
	}	
	
	
	public void ejecutar(){
		inicio.ejecutar();
		Bloque b = bloques.get(0);
		while (b.getFin().equals("vivo")) {
			b.ejecutar();
			if(b.getSiguiente() == null) break;
			b = b.getSiguiente();
		}
		
		switch (b.getFin()) {
		case "vivo":
			JOptionPane.showMessageDialog(null, "Has sobrevivido");
			break;
		case "muerto":
			JOptionPane.showMessageDialog(null, "Has muerto");
			break;
		case "huye":
			JOptionPane.showMessageDialog(null, "Has huido");
			break;
		}
	}
	
}


