package ejercicio4;

import java.util.List;

public class TipoElemento {
	
	String id;
	List<String> tipos;
	
	
	public TipoElemento(String id, List<String> tipos) {
		super();
		this.id = id;
		this.tipos = tipos;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getTipos() {
		return tipos;
	}
	public void setTipos(List<String> tipos) {
		this.tipos = tipos;
	}
	
	
	

}
