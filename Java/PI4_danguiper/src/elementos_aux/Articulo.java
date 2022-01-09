package elementos_aux;

import java.util.Objects;




public class Articulo {
	private int id;
	private static int num=0;
	private Investigador inv1;
	private Investigador inv2;
	private Integer numArticulos;
	
	private Articulo(String[] formato) {
		this.inv1 = Investigador.ofId(formato[0]);
		this.inv2 = Investigador.ofId(formato[1]);
		this.numArticulos = Integer.valueOf(formato[2]);
		this.id = num;
		num++;
	}
	private Articulo(Investigador i1, Investigador i2) {
		
		this.inv1 = i1;
		this.inv2 = i2;
		this.numArticulos = 0;
		this.id = num;
		num++;
	}
	private Articulo() {
		this.inv1 = null;
		this.inv2 = null;
		this.numArticulos = 0;
		this.id = num;
		num++;
	}
	public static Articulo of() {
		return new Articulo();
	}

	public static Articulo ofFormat(String[] formato) {
		return new Articulo(formato);
	}
	
	public static Articulo ofVertex(Investigador i1, Investigador i2) {
		return new Articulo(i1, i2);
	}

	public static int getNum() {
		return num;
	}

	public Investigador getInv1() {
		return inv1;
	}

	public Investigador getInv2() {
		return inv2;
	}

	public Integer getNumArticulos() {
		return Integer.valueOf(this.numArticulos);
	}
	public Investigador obtenInvestigadorContrario(Investigador i) {
		
		Investigador res = null;
		if (this.getInv1().getId()==i.getId()) {
			res = this.getInv2();
		}else {
			res = this.getInv1();
		
		}
		
		
			return res;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, inv1, inv2, numArticulos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		return id == other.id && Objects.equals(inv1, other.inv1) && Objects.equals(inv2, other.inv2)
				&& Objects.equals(numArticulos, other.numArticulos);
	}

	@Override
	public String toString() {
		return "Articulo [getInv1()=" + getInv1() + ", getInv2()=" + getInv2() + ", getNumArticulos()="
				+ getNumArticulos() + ", hashCode()=" + hashCode() + "]";
	}

}
