package elementos_aux;

import java.util.Objects;

public class Alumno {
	
	private static int num;
	private int id;
	private Integer fila;
	private Integer columna;
	private boolean covid;
	
	
	public static Alumno ofFormat(String[] formato) {
		return new Alumno(formato);
	}
 
	
	private Alumno(Integer f, Integer c, boolean covid) {
		super();
		this.id = num;
		this.columna = c;
		this.fila = f;
		this.covid = covid;
		num++;
	}
 
	private Alumno(String[] s) {
		super();
		this.covid = s[0].contains("+") ? true : false;
		this.id = num;
		this.fila = Integer.valueOf(s[1]);
		this.columna = Integer.valueOf(s[2]);
		num++;
	}
	
	public static int getNum() {
		return num;
	}
	public static void setNum() {
		num = 0;
	}
	public int getId() {
		return id;
	}
	public Integer getFila() {
		return fila;
	}
	public Integer getColumna() {
		return columna;
	}
	public boolean getCovid() {
		return covid;
	}
	@Override
	public int hashCode() {
		return Objects.hash(columna, covid, fila, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(columna, other.columna) && covid == other.covid && Objects.equals(fila, other.fila)
				&& id == other.id;
	}
	@Override
	public String toString() {
		return fila + "," + columna;
	}
	
	
}
