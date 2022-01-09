package elementos_aux;

import java.util.Objects;



public class Investigador {
	
	private Integer id;
	private Integer anyo_nac;
	private String university;
	
//	Getters
	
	public Integer getId() {
		return id;
	}
	public Integer getAnyo_nac() {
		return anyo_nac;
	}
	public String getUniversity() {
		return university;
	}
	
//	Métodos factoría
	public static Investigador of() {
		return new Investigador("");
	}
	
	public static Investigador ofFormat(String[] formato)	{
		return new Investigador(formato);
	}
	
	private Investigador(String[] formato) {
		this.id = Integer.parseInt(formato[0]);
		this.anyo_nac = Integer.parseInt(formato[1]);
		this.university = formato[2];
	}
	
	public static Investigador ofId(String id) {
		return new Investigador(id);
	}
	
	private Investigador(String id) {
		this.id = Integer.valueOf(id);
		this.anyo_nac = 0;
		this.university = null;
	}
	
	public Investigador(Integer id, Integer anyo, String uni) {
		this.id = id;
		this.anyo_nac = anyo;
		this.university = uni;
	}
	@Override
	public int hashCode() {
		return Objects.hash(anyo_nac, id, university);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Investigador other = (Investigador) obj;
		return Objects.equals(anyo_nac, other.anyo_nac) && id == other.id
				&& Objects.equals(university, other.university);
	}
	
	public String toString() {
		return "inv-" + this.getId();
	}
	public String toString2() {
		return "INV-" + this.getId() + " " + this.getAnyo_nac();
	}
	public String toString3() {
		return "INV-" + this.getId() + " " + this.getUniversity();
	}
}
