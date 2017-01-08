package com.example.zeroc.holders;

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

	public void setInicio(String pais, String ciudad, boolean institucion){
		this.inicio = new Inicio(pais,ciudad,institucion,titulo);
	}
	public void addBloque(Bloque bloque){
		bloques.add(bloque);
	}
	public void setContext(MainActivity mainActivity){
		this.mainActivity = mainActivity;
		inicio.setContext(mainActivity);
		for (Bloque actual : bloques) {
			actual.setContext(mainActivity);
		}
	}

	public void ejecutar(){
		System.out.println("\tIniciando Historia " + titulo);
		inicio.ejecutar();
		fin = "vivo";
		Bloque actual = bloques.get(0);
		while (fin.equals("vivo")) {
			actual.ejecutar();
			fin = actual.getFin();
			if(actual.getSiguiente() == null)
				break;
			actual = actual.getSiguiente();
		}
		System.out.println("\tFIN Historia " + titulo);
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


