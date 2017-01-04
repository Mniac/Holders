package com.example.zeroc.holders;


public class Inicio {

	private String texto = "En ___ciudad___, en cualquier ___pais___, ve a ___lugar___ donde puedas ir por ti mismo. Cuando llegues al escritorio principal, pregunta por visitar a aquel que se hace llamar ";
	private String pais;
	private String ciudad;
	private boolean institucion;
	private String holder;
	
	public Inicio(String pais, String ciudad,	boolean institucion, String holder ) {
		this.pais = pais;
		this.ciudad = ciudad;
		this.institucion = institucion;
		this.holder = holder;
		texto = texto.replace("___ciudad___", this.ciudad);
		texto = texto.replace("___pais___", this.pais);
		if(this.institucion)
			texto = texto.replace("___lugar___", "instituci�n mental");
		else
			texto = texto.replace("___lugar___", "centro de reinserci�n social");
		texto = texto.replace("___ciudad___",this.ciudad);
		texto = texto.concat(this.holder+".");
	}
	
	
	public void ejecutar(){
		JOptionPane.showMessageDialog(null, texto);
	}
}
