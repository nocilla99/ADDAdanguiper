package datos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.common.Files2;

public class datosEj2 {
	public static List<TipoCandidato> candidatos=new ArrayList<>();
	
	public static List<String> requeridas=new ArrayList<>();
	
	public static Double presupuesto;
	
	public record TipoCandidato(String id,List<String> cualidades,double precio, int valoracion, List<String> incompatibilidad) {
		
		public static TipoCandidato create(String s) {
			String n;
			List<String> cualis,incompts;
			double prec;
			int valo;
			//parsear
			String[]j=s.split(":");
			n=j[0].trim();
			j=j[1].split(";");
			
			cualis=hazLizta(j[0].split(","));
			prec=Double.valueOf(j[1].trim());
			valo=Integer.valueOf(j[2].trim());			
			incompts=hazLizta(j[3].trim().split(","));
			
			return new TipoCandidato(n,cualis, prec, valo, incompts);
		}
		
		public static List<String> hazLizta(String[] in){
			List<String> res= new ArrayList<>();
			for (String el : in) {
				res.add(el.trim());
			}
			return res;
			
		}
		
		public String toString() {
			return id+"; "+ cualidades.toString() +"; "+ precio +"; "+valoracion+"; "+incompatibilidad.toString();
		}
	}
		
	
	
	
	public static List<String> getRequeridas() {
		return requeridas;
	}

	public static Double getPresupuesto() {
		return presupuesto;
	}

	public static List<TipoCandidato> getCandidatos(){
		return candidatos;
	}
	
	public static TipoCandidato getCandidato(int i) {
		return candidatos.get(i);
	}

	public static Integer getNumCandidatos() {
		return candidatos.size();
	}
	
	
	
	
	private static void setReq(String line) {
		String[] p= line.split(":");
		requeridas=TipoCandidato.hazLizta(p[1].trim().split(","));
		
	}
	
	private static void setPresu(String l) {
		String[] p= l.split(":");
		presupuesto= Double.valueOf(p[1].trim());
	}
	
	public static void iniDatos(String fichero) {
		List<String> lineas= Files2.streamFromFile(fichero).collect(Collectors.toList());
		setReq(lineas.get(0));
		setPresu(lineas.get(1));
		for(int di=2; di<lineas.size();di++) {
			candidatos.add(TipoCandidato.create(lineas.get(di)));
		}
		
	}
	
}
