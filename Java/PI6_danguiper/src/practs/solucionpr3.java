package practs;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class solucionpr3 {
	
	
		
		public int af_TOTAL;
		public SortedMap<Integer,List<String>> solucion;
	
		

		public solucionpr3() {
		}

		public static solucionpr3 of(GraphPath<pr3Vertex,prArista> gp) {
			solucionpr3 spr3= new solucionpr3();
			spr3.af_TOTAL=0;
			spr3.solucion= new TreeMap<>();
			List<prArista> ls= gp.getEdgeList();
			for(int i=0; i<ls.size();i++) {
				prArista e=ls.get(i);
				Integer g=e.action();
				spr3.af_TOTAL += datosprob3.getAfinidad(i, g);
				if(spr3.solucion.containsKey(g)) {
					spr3.solucion.get(g).add(datosprob3.getAlumno(i).nombre());	
				}else {
					spr3.solucion.put(g,List.of(datosprob3.getAlumno(i).nombre()));
					
				}
			}
			return spr3;
			
		}

		public String toString() {
			String s= "\n Afinidad toal :"+af_TOTAL;
			return solucion.entrySet().stream().map(e->"Grupo "+(e.getKey()+1)+": "+e.getValue()).collect(Collectors.joining("\n Reparto: \n"+s));
			}
}
	
