package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.jgrapht.GraphPath;

public class Solucion1 {
	
	
		
		public int archivosAlmacenados;
		public Map<Integer,List<String>> solucion;
	
		

		public Solucion1() {
		}

		public static Solucion1 of(GraphPath<Ej2_Vertex,Ej2_Edge> gp) {
			Solucion1 solu= new Solucion1();
			solu.archivosAlmacenados=0;
			solu.solucion= new TreeMap<>();
			List<Ej2_Edge> ls= gp.getEdgeList();
			for(int i=0; i<ls.size();i++) {
				Ej2_Edge e=ls.get(i);
				Integer g=e.action();
				solu.archivosAlmacenados += 1;
				if(solu.solucion.containsKey(g)) {
					solu.solucion.get(g).add(datosEj1.getArchivo(i).nombre());	
				}else {
					List<String> li= new ArrayList<String>();
					li.add(datosEj1.getArchivo(i).nombre());
					solu.solucion.put(g,li);
					
				}
			}
			return solu;
			
		}
		
		public String IndMem(Integer indMas1) {
			String r=(indMas1==0)? "No almacenados": "Memoria "+indMas1.toString();
			return r;
		}

		public String toString() {;
			return solucion.entrySet().stream().map(e->IndMem(e.getKey()+1)+": "+e.getValue()).collect(Collectors.joining("\n"));
			}
}
	
