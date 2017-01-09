package com.example.zeroc.holders;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Puntuacion {

	private String nombre;
	private Date fecha;
	private int holdersConseguidos;
	
	
	
	public Puntuacion(String nombre, int holdersConseguidos) {
		this.nombre = nombre;
		this.fecha = new Date();
		this.holdersConseguidos = holdersConseguidos;
	}
	public Puntuacion(String str){
		String strV[] = {"","",""};
		int i = 0;

		for (char c : str.toCharArray()) {
			if(c == '-')
				i++;
			else
				strV[i]= strV[i]+c;
		}
		this.nombre = strV[0];
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		format.toPattern();
		try {
			this.fecha = format.parse(strV[1]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.holdersConseguidos = Integer.parseInt(strV[2]);
	}
	
	public String getNombre() {
		return nombre;
	}
	public Date getFecha() {
		return fecha;
	}
	public int getHoldersConseguidos() {
		return holdersConseguidos;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return nombre+" --- "+format.format(fecha)+" --- "+holdersConseguidos;
	}
	public String formaString(){
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return nombre+"-"+format.format(fecha)+"-"+holdersConseguidos;
	}
	public void setHoldersConseguidos(int holdersConseguidos) {
		this.holdersConseguidos = holdersConseguidos;
	}




}
