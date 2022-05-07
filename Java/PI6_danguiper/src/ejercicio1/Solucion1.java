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

		public static Solucion1 of(GraphPath<Ej1_Vertex,Ej1_Edge> gp) {
			Solucion1 solu= new Solucion1();
			solu.archivosAlmacenados=0;
			solu.solucion= new TreeMap<>();
			List<Ej1_Edge> ls= gp.getEdgeList();
			
			for(int i=0; i<ls.size();i++) {
				Ej1_Edge e=ls.get(i);
				Integer g=e.action();
				solu.archivosAlmacenados += (g!=-1)?1:0;
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

		public String toString() {
			System.out.println(archivosAlmacenados);
			return solucion.entrySet().stream().map(e->IndMem(e.getKey()+1)+": "+e.getValue()).collect(Collectors.joining("\n"));
		}
}
	
