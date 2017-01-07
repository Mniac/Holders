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
	}
	
	public Historia(String titulo,MainActivity mainActivity) {
		this.titulo= titulo;
		this.mainActivity = mainActivity;
	}

	public void setInicio(String pais, String ciudad, boolean institucion){
		this.inicio = new Inicio(pais,ciudad,institucion,titulo,mainActivity);;
	}
	public void addBloque(Bloque bloque){

		bloques.add(bloque);
		bloque.setMainActitivy(mainActivity);
	}	
	
	
	public void ejecutar(){
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
	
	public void read() throws IOException, ClassNotFoundException {
		//Creamos un fujo de entrada a disco, pas�ndole el nombre del archivo en disco o un objeto de la clase File.
        FileInputStream fileIn=new FileInputStream(titulo+".holder");
        
		//El fujo de entrada ObjectInputStream es el que procesa los datos y se ha de vincular a un objeto fileIn de la clase FileInputStream.
        ObjectInputStream entrada=new ObjectInputStream(fileIn);
        
        //El método readObject lee los objetos del flujo de entrada, en el mismo orden en el que ha sido escritos.
        Historia h1 = null;
        Object aux = entrada.readObject();
        if( aux instanceof Historia){
        	 h1 = (Historia)aux;
             
            //Se realizan tareas con dichos objetos
            titulo = h1.titulo;
         	inicio = h1.inicio;
         	bloques = h1.bloques;
         	fin = h1.fin;
        }
        	
       //Finalmente, se cierra los flujos
       // System.out.println("LEIDO");
        entrada.close();
	}
	public void save() throws IOException{
	    //Creamos un fujo de salida a disco, pas�ndole el nombre del archivo en disco o un objeto de la clase File.
	    FileOutputStream fileOut=new FileOutputStream(titulo+".holder");
	    
	    //El fujo de salida ObjectOutputStream es el que procesa los datos y se ha de vincular a un objeto fileOut de la clase FileOutputStream .
	    ObjectOutputStream salida=new ObjectOutputStream(fileOut);
	    
	    //El m�todo writeObject escribe los objetos al flujo de salida y los guarda en un archivo en disco. Por ejemplo, un string y un objeto de la clase Lista.
	    salida.writeObject(this);
	    
	    //Finalmente, se cierran los flujos
	    //System.out.println("GUARDADO");
	    salida.close();
	        
	}
	public String getFin() {
		return fin;
	}
	public Object getTitulo() {
		return titulo;
	}
}


