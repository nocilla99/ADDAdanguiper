package ejercicio1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.common.Files2;

public class DatosEj1 {

	 public record Archivo(String id,Integer tamanyo) implements Comparable<Archivo>{

		 

		public static Archivo parse (String s){		
				String[] v = s.split(":");
				String i = v[0].trim();
				Integer t = Integer.parseInt(v[1].trim());
				return new Archivo(i,t);
		 }
		
		@Override
		public int compareTo(Archivo o) {
			return this.tamanyo().compareTo(o.tamanyo());
		}
		 
	}
	
		
	
	
	public static int archivos;
	public static List<Archivo> disponibles=new ArrayList<>();
	public static List<Tipo_memoria> CapacidadesMemorias;
	
	public static void datos(String fichero) {
		disponibles = Files2.streamFromFile(fichero)
				.map(s -> Archivo.parse(s))
				.collect(Collectors.<Archivo> toList());
		archivos = disponibles.size();
	}
	



}
