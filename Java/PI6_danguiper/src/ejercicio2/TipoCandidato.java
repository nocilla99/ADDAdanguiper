package ejercicio2;

import java.util.List;

public class TipoCandidato {
	private String id;
	private int valoracion;
	private List<String> incompatibilidad,cualidades;
	private double precio;
	
	
	
	
	public TipoCandidato(String id,List<String> cualidades,double precio, int valoracion, List<String> incompatibilidad) {
		super();
		this.id = id;
		this.valoracion = valoracion;
		this.incompatibilidad = incompatibilidad;
		this.precio = precio;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getValoracion() {
		return valoracion;
	}
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	public List<String> getIncompatibilidad() {
		return incompatibilidad;
	}
	public void setIncompatibilidad(List<String> incompatibilidad) {
		this.incompatibilidad = incompatibilidad;
	}
	public List<String> getCualidades() {
		return cualidades;
	}
	public void setCualidades(List<String> cualidades) {
		this.cualidades = cualidades;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
