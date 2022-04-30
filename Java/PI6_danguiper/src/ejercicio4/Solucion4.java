package ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import org.jgrapht.GraphPath;

public class Solucion4 {
	public int contenedoresLLenos;
	public Map<Integer,List<String>> solucion;

	

	public Solucion4() {
	}

	public static Solucion4 of(GraphPath<Ej4_Vertex,Ej4_Edge> gp) {
		Solucion4 solu= new Solucion4();
		solu.contenedoresLLenos=0;
		solu.solucion= new TreeMap<>();
		List<Ej4_Edge> ls= gp.getEdgeList();
		for(int i=0; i<ls.size();i++) {
			Ej4_Edge e=ls.get(i);
			Integer g=e.action();
			solu.contenedoresLLenos += 1;
			if(solu.solucion.containsKey(g)) {
				solu.solucion.get(g).add(datosEj4.getElemento(i).nombre());	
			}else {
				List<String> li= new ArrayList<String>();
				li.add(datosEj4.getElemento(i).nombre());
				solu.solucion.put(g,li);
				
			}
		}
		return solu;
		
	}
	
	public String IndMem(Integer indMas1) {
		String r=(indMas1==0)? "No almacenados": "Contenedor "+indMas1.toString();
		return r;
	}

	public String toString() {;
		return solucion.entrySet().stream().map(e->IndMem(e.getKey()+1)+": "+e.getValue()).collect(Collectors.joining("\n"));
	}
}
