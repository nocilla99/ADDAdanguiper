package ejercicio3;

import java.util.List;

public class TipoProducto {
	
	private String id;
	private int precio,maximo;
	List<dupla> componentes;
	
	
	
	
	
	public TipoProducto(String id, int precio, List<dupla> componentes, int maximo) {
		super();
		this.id = id;
		this.precio = precio;
		this.maximo = maximo;
		this.componentes = componentes;
	}





	public String getId() {
		return id;
	}





	public void setId(String id) {
		this.id = id;
	}





	public int getPrecio() {
		return precio;
	}





	public void setPrecio(int precio) {
		this.precio = precio;
	}





	public int getMaximo() {
		return maximo;
	}





	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}





	public List<dupla> getComponentes() {
		return componentes;
	}





	public void setComponentes(List<dupla> componentes) {
		this.componentes = componentes;
	}





	public record dupla(TipoComponente id,int cantidad) {}
}
