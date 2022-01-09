package ejercicios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.Graphs;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.SimpleWeightedGraph;

import elementos_aux.Articulo;
import elementos_aux.Investigador;
import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.colors.GraphColors.Style;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;

public class Ejercicio1 {

private static Graph<Investigador, Articulo> gf;
	
	private static Function<Investigador, String> nombreInv = Investigador::toString2;
	
	private static Function<Articulo, String> numArt = a -> a.getNumArticulos().toString();
	
	public static void lee_grafo(String fichero) {
		
		gf =  GraphsReader.newGraph("ficheros/" + fichero + ".txt",
				Investigador::ofFormat,
				Articulo::ofFormat,
				Graphs2::simpleWeightedGraph,
				a -> Double.valueOf(a.getNumArticulos()));
		
	}
	
	public static void apA(String file) {
		
		Predicate<Investigador> predVertices = v -> (v.getAnyo_nac() < 1982 || gf.edgesOf(v).stream().anyMatch(arista -> 
		arista.getNumArticulos()>5));
		Predicate<Articulo> predArista = arista -> gf.getEdgeWeight(arista) > 5;
		
		String res = "ficheros/Ejercicio1a.gv";
		GraphColors.toDot(gf, res, nombreInv, numArt,
				v -> GraphColors.colorIf(Color.blue, Color.black, predVertices.test(v)),
				e -> GraphColors.colorIf(Color.blue, Color.black, predArista.test(e)));

		System.out.println("- Apartado a:\n Fichero:" + res);
		
	}
	
	public static Set<Investigador> apB(String file) {
		
		Comparator<Investigador> cmp = Comparator.comparingInt(vertice -> gf.degreeOf(vertice));
		
		Set<Investigador> set = gf.vertexSet().stream().sorted(cmp.reversed()).limit(5).collect(Collectors.toSet());
		
		String res = "ficheros/Ejercicio1b.gv";
		GraphColors.toDot(gf, res, nombreInv, numArt,
				vertice -> GraphColors.colorIf(Color.blue, Color.green, set.contains(vertice)),
				arista -> GraphColors.color(Color.green));
		
		System.out.println("- Apartado b:\n Fichero:" + res);
		
		return set;
		
	}
	
	private static List<Investigador> listaInvest(Investigador i) {
		
		return gf.edgesOf(i).stream().sorted(Comparator.comparing(Articulo::getNumArticulos).reversed()).map(arista -> 
		arista.obtenInvestigadorContrario(i)).collect(Collectors.toList());
		
	}
	
	private static List<Articulo> lisArticulos(Map<Investigador, List<Investigador>> mp){
		
		List<Articulo> res = new ArrayList<>();
		for(Entry<Investigador, List<Investigador>> investigador:mp.entrySet()) {
			
			Investigador i = investigador.getValue().get(0);
			Investigador trueI = gf.vertexSet().stream().filter(vertice -> vertice.getId().equals(i.getId())).findFirst().get();
			res.add(gf.getEdge(trueI, investigador.getKey()));
			
		}
		return res;
	}
	
	public static Map<Investigador, List<Investigador>> apC(String file) {
		
		Map<Investigador, List<Investigador>> map = new HashMap<>();
		Set<Investigador> set = gf.vertexSet();
		
		for (Investigador i: set) {
			
			Investigador key = i;
			if (!map.containsKey(key))
				map.put(key, listaInvest(i));
		}
		
		String res = "ficheros/Ejercicio1c.gv";
		
		GraphColors.toDot(gf, res, nombreInv, numArt,
				vertice -> GraphColors.color(Color.black),
				arista -> GraphColors.colorIf(Color.blue, Color.black, lisArticulos(map).contains(arista)));
		

		System.out.println("- Apartado c:\n Fichero:" + res);
		
		return map;
		
	}
	
	public static record TuplaII(GraphPath<Investigador, Articulo> gp, Investigador i1, Investigador i2) {
		
		private static TuplaII of(GraphPath<Investigador, Articulo> g, Investigador a, Investigador b) {
			return new TuplaII(g, a, b);
		}
		
	}
	
	public static TuplaII apD(String file) {
		
		var dij = new DijkstraShortestPath<>(gf);
		Set<Investigador> set = gf.vertexSet();
		GraphPath<Investigador, Articulo> camino = null;
		
		Integer len = 0;
		Investigador ini = null, fin = null;
		
		for (Investigador i1: set) {
			for (Investigador i2: set) {
				
				Integer max_len = dij.getPath(i1, i2).getLength();
				
				if (len < max_len) {
					
					len = max_len;
					ini = i1;
					fin = i2;
					
					camino = dij.getPath(ini,fin);
				}
			}
		}
		return TuplaII.of(camino, ini,fin);
	}
	
	public static void apartadoD_grafo(String file) {
		
		TuplaII tupla = apD(file);
				 
		String res = "ficheros/Ejercicio1d.gv";
		
		GraphColors.toDot(gf, res, nombreInv, numArt,
				vertice -> GraphColors.colorIf(Color.blue, Color.black, tupla.gp().getVertexList().contains(vertice)),
				arista -> GraphColors.colorIf(Color.blue, Color.black, tupla.gp().getEdgeList().contains(arista)));
		

		System.out.println("- Apartado d:\n Fichero:" + res);
		
	}
	
	public static List<Set<Investigador>> apE(String file) {
		
		Graph<Investigador, Articulo> grafo = new SimpleWeightedGraph<Investigador, Articulo>(null, null);
		
		Graphs.addGraph(grafo, gf);
		
		for (Investigador i1: grafo.vertexSet()) {
			for (Investigador i2: grafo.vertexSet()) {
				if (!i1.equals(i2) && grafo.getEdge(i1, i2) == null && i1.getUniversity().equals(i2.getUniversity())) {
					
					Articulo art = Articulo.ofVertex(i2, i1);
					grafo.addEdge(i1, i2, art);
					
				}
			}
		}
		
		
		var alg = new GreedyColoring<>(grafo);
		var coloring = alg.getColoring();
		Map<Investigador, Integer> map = coloring.getColors();
		
		String res = "ficheros/Ejercicio1e.gv";
		
		GraphColors.toDot(gf, res, Investigador::toString3, numArt, 
				v -> GraphColors.color(map.get(v)), arista -> GraphColors.style(Style.solid));
		
		System.out.println("\n- Apartado e: \n");
		System.out.println("Resultado en: " + res);
		
		System.out.println("Las reuniones serían:");
		
		return coloring.getColorClasses().stream().filter(x -> x.size()>1).toList();
		
	}
}
