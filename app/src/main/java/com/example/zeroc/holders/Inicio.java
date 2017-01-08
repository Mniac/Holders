package com.example.zeroc.holders;

import android.provider.Settings;
import android.support.v7.app.AlertDialog;

public class Inicio implements  java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String texto = "En ___ciudad___, en ___pais___, ve a ___lugar___ donde puedas ir por ti mismo. Cuando llegues al escritorio principal, pregunta por visitar a aquel que se hace llamar ";
	private String pais;
	private String ciudad;
	private boolean institucion;
	private String holder;
	private TheHolders theHolders;

	public Inicio(String pais, String ciudad,	boolean institucion, String holder ,TheHolders theHolders) {
		this.pais = pais;
		this.ciudad = ciudad;
		this.institucion = institucion;
		this.holder = holder;
		texto = texto.replace("___ciudad___", this.ciudad);
		texto = texto.replace("___pais___", this.pais);
		if(this.institucion)
			texto = texto.replace("___lugar___", "institución mental");
		else
			texto = texto.replace("___lugar___", "centro de reinserción social");
		texto = texto.replace("___ciudad___",this.ciudad);
		texto = texto.concat(this.holder+".");
		this.theHolders = theHolders;
	}
	
	
	public void ejecutar(){
		System.out.print("CARGANDO VISTA INICIO \n");
		theHolders.cargarVistaSimple(texto);

	}
}
