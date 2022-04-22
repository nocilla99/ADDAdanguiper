package ejercicio4;

public class TipoContenedor {
	String id, tipo;
	int capacidad;
	
	
	public TipoContenedor(String id, int capacidad, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.capacidad = capacidad;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	
}
