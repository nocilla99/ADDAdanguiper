package ejercicio3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.jgrapht.GraphPath;


public class Solucion3 {
	
		public Solucion3() {
		}
		
		public double ingresos;
		public Map<Integer,Integer> TipoCantidad;
	
		
		public static Solucion3 of(GraphPath<Ej3_Vertex,Ej3_Edge> gp) {
			Solucion3 spr3= new Solucion3();
			spr3.ingresos=0;
			spr3.TipoCantidad= new HashMap<>();
			List<Ej3_Edge> ls= gp.getEdgeList();
			for(int i=0; i<ls.size();i++) {
				Ej3_Edge e=ls.get(i);
				Integer alternativa=e.action();
				
				if(spr3.TipoCantidad.containsKey(alternativa)) {
					spr3.TipoCantidad.put(alternativa,spr3.TipoCantidad.get(alternativa)+1);	
				}else {
					spr3.TipoCantidad.put(alternativa,0);
				}	
				
			}
			return spr3;
			
		}

		public String IndMem(Integer indMas1) {
			String r=(indMas1==0)? "No almacenados": "Memoria "+indMas1.toString();
			return r;
		}

		public String toString() {;
			return "Ingresos: "+ingresos+"\n"+TipoCantidad.entrySet().stream().map(e->IndMem(e.getKey()+1)+": "+e.getValue()).collect(Collectors.joining("\n"));
		}
}
	
