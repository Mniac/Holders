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
		return nombre+"\t"+fecha.toString()+"\t"+holdersConseguidos;
	}
	public void setHoldersConseguidos(int holdersConseguidos) {
		this.holdersConseguidos = holdersConseguidos;
	}
	
	
}
