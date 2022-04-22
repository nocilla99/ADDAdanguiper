package ejercicio1;

public class TipoArchivo {
	private String nombre;
	private int tamanyo;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTamanyo() {
		return tamanyo;
	}
	public void setTamanyo(int tamanyo) {
		this.tamanyo = tamanyo;
	}
	public TipoArchivo(String nombre, int tamanyo) {
		super();
		this.nombre = nombre;
		this.tamanyo = tamanyo;
	}
	
	

}
