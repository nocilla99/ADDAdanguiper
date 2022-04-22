package ejercicio3;

public class TipoComponente {
	private String id;
	private int tprod,telab;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTprod() {
		return tprod;
	}
	public void setTprod(int tprod) {
		this.tprod = tprod;
	}
	public int getTelab() {
		return telab;
	}
	public void setTelab(int telab) {
		this.telab = telab;
	}
	public TipoComponente(String id, int tprod, int telab) {
		super();
		this.id = id;
		this.tprod = tprod;
		this.telab = telab;
	}
	
	

}
