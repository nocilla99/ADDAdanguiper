package ejercicio1;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.jgrapht.GraphPath;

public class Solucion1 {
	
	
		
		public int archivosAlmacenados;
		public SortedMap<Integer,List<String>> solucion;
	
		

		public Solucion1() {
		}

		public static Solucion1 of(GraphPath<Ej1_Vertex,Ej1_Edge> gp) {
			Solucion1 solu= new Solucion1();
			solu.archivosAlmacenados=0;
			solu.solucion= new TreeMap<>();
			List<Ej1_Edge> ls= gp.getEdgeList();
			for(int i=0; i<ls.size();i++) {
				Ej1_Edge e=ls.get(i);
				Integer g=e.action();
				solu.archivosAlmacenados += 1;
				if(solu.solucion.containsKey(g)) {
					solu.solucion.get(g).add(datosEj1.getArchivo(i).nombre());	
				}else {
					solu.solucion.put(g,List.of(datosEj1.getArchivo(i).nombre()));
					
				}
			}
			return solu;
			
		}

		public String toString() {
			String s= "\nArchivos almacenados :"+archivosAlmacenados;
			return solucion.entrySet().stream().map(e->"Memoria "+(e.getKey()+1)+": "+e.getValue()).collect(Collectors.joining("\n Archivos: \n"+s));
			}
}
	
