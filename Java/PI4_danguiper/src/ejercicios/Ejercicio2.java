package ejercicios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph; 
import org.jgrapht.traverse.TopologicalOrderIterator;
import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.colors.GraphColors.Style;
import us.lsi.common.Files2; 

public class Ejercicio2 {
public static Graph<String, DefaultEdge> lee_grafo(String fichero){
		
		SimpleDirectedGraph<String, DefaultEdge> gf = new SimpleDirectedGraph<>(String::new, DefaultEdge::new, false);
		
		List<String> lineas = Files2.linesFromFile("ficheros/" + fichero + ".txt");
		List<String> aristas = lineas.subList(lineas.indexOf("#EDGE#") + 1, lineas.size());
		
		for (String linea:aristas) {
			String[] v = linea.split(",");
			gf.addVertex(v[0]);
			gf.addVertex(v[1]);
			gf.addEdge(v[0], v[1]);
		}
		
		return gf;
		
	}
	
	public static Set<String> apA(Graph<String, DefaultEdge> gf) {
		
		List<String> ls = gf.vertexSet().stream().toList();
		Set<String> set = new HashSet<>();
		
		for (int i = 0; i < ls.size(); i++) {
			
			if(gf.inDegreeOf(ls.get(i)) == 0)
				set.add(ls.get(i));
			
		}
		
		String res = "ficheros/Ejercicio2a.gv";
		GraphColors.toDot(gf, res, vert -> vert, ari -> "", vert -> 
		GraphColors.colorIf(Color.blue, Color.black, res.contains(vert)), ari -> GraphColors.style(Style.solid));
		
		if (!set.isEmpty())
			System.out.println("Fichero: " + res + "\n");
		
		return set;
		
	}
	
	public static Boolean apB(Graph<String, DefaultEdge> gf, List<String> ls) {
		
		var dij = new DijkstraShortestPath<>(gf);
		
		Boolean b = null;
		
		for (int i=0;i<ls.size() - 1;i++) {
			
			GraphPath<String, DefaultEdge> camino = dij.getPath(ls.get(i), ls.get(i + 1));
			
			if (camino != null)
				b = true;
			else 
				b = false;
			
		}
		
		return b;
		
	}
	
	public static List<String> apartadoC(Graph<String, DefaultEdge> gf, String libro) {
		
		var dij = new DijkstraShortestPath<>(gf);
		List<String> ls = gf.vertexSet().stream().filter(x -> !x.equals(libro) && dij.getPath(x, libro)!=null).toList();
		
		List<String> res = new ArrayList<>(); 
		var alg2 = new TopologicalOrderIterator<String ,DefaultEdge>(gf);
		alg2.forEachRemaining(v -> res.add(v));

		gf.vertexSet().stream().filter(s -> !ls.contains(s)).forEach(a -> res.remove(a));
		
		return res;
	}

}
