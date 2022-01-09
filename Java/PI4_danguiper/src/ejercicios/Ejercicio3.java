package ejercicios;

import java.util.*; 
import java.util.function.Function;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.Graphs;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.shortestpath.FloydWarshallShortestPaths;
import org.jgrapht.alg.tour.HeldKarpTSP;
import org.jgrapht.graph.SimpleWeightedGraph;

import elementos_aux.Calle;
import elementos_aux.Interseccion;
import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;

public class Ejercicio3 {
	
	private static Function<Calle, String> calleDuracion = ari -> ari.getDuracion().toString();
	private static Function<Calle, String> calleEsfuerzo = ari -> ari.getEsfuerzo().toString();
	private static Function<Interseccion, String> interseccion = i -> 
	i.isEsRelevante() ? "Int-" + i.getId().toString() + ", " + i.getNombreMonumento() + ", " +  i.getRelevancia().toString()+"int" : "Int-" + i.getId().toString();
	
	private static SimpleWeightedGraph<Interseccion, Calle> gf;
	
	public static void lee_grafo(String fichero) {
		
		gf = GraphsReader.newGraph("ficheros/" + fichero + ".txt", 
				Interseccion::ofFormat,
				Calle::ofFormat, 
				Graphs2::simpleWeightedGraph);
		
	}
	
	public static void apA(String file, String m1, String m2, String nombreFichero) {
		
		Graph<Interseccion, Calle> gf = GraphsReader.newGraph("ficheros/" + file + ".txt", Interseccion::ofFormat, Calle::ofFormat, Graphs2::simpleWeightedGraph, a -> Double.valueOf(a.getDuracion()));
		
		Interseccion i1 = null;
		Interseccion i2 = null;
		
		
		for(Interseccion i: gf.vertexSet()) {
			
			if(i.getNombreMonumento().equals(m1))
				i1=i;
			else if(i.getNombreMonumento().equals(m2))
				i2=i;
			else if(i1!=null && i2!=null)
				break;
			
		}
		
		var flo = new FloydWarshallShortestPaths<>(gf);
		GraphPath<Interseccion, Calle> gp = flo.getPath(i1, i2);
		
		GraphColors.toDot(gf, nombreFichero, Interseccion::toString, calleDuracion,
				ver -> GraphColors.colorIf(Color.blue, Color.black, gp.getVertexList().contains(ver)),
				ari -> GraphColors.colorIf(Color.blue, Color.black, gp.getEdgeList().contains(ari)));
		
		
		
	}
	
	public static void apB(String file) {
		
		Calle.setNum(0);
		Graph<Interseccion, Calle> gf = GraphsReader.newGraph("ficheros/" + file + ".txt", Interseccion::ofFormat, Calle::ofFormat, Graphs2::simpleWeightedGraph, a -> Double.valueOf(a.getEsfuerzo()));
		var hk = new HeldKarpTSP<Interseccion, Calle>();
		GraphPath<Interseccion, Calle> gp = hk.getTour(gf);
		
		
		String res = "ficheros/Ejercicio3b.gv";
		GraphColors.toDot(gf, res, Interseccion::toString, calleEsfuerzo,
				ver -> GraphColors.colorIf(Color.blue, Color.black, gp.getVertexList().contains(ver)),
				ari -> GraphColors.colorIf(Color.blue, Color.black, gp.getEdgeList().contains(ari)));
		
		
		
		
	}
	
	private static record tuplaDatos(Set<Interseccion> set, Graph<Interseccion, Calle> gf, ConnectivityInspector<Interseccion, Calle> met) {
		
		public static tuplaDatos of(Set<Interseccion> set, Graph<Interseccion, Calle> gf, ConnectivityInspector<Interseccion, Calle> met) {
			return new tuplaDatos(set, gf, met);
		}
		
	}
	
	private static tuplaDatos apartadoCaux(String file, Set<Calle> callesCortadas) {
		
		Calle.setNum(0);
		Graph<Interseccion, Calle> gc = GraphsReader.newGraph("ficheros/" + file + ".txt", Interseccion::ofFormat, Calle::ofFormat, Graphs2::simpleWeightedGraph);
				
		Graphs.addGraph(gc, gf);
		
		List<Integer> ids = callesCortadas.stream().map(x -> x.getId()).toList();
		for (Calle c: gc.edgeSet()) {
			if (ids.contains(c.getId()))
				gf.removeEdge(c);
		}
		
		var c = new ConnectivityInspector<>(gf);
		
		List<Set<Interseccion>> ls = c.connectedSets();
		Integer suma, total = 0;
		Set<Interseccion> res = new HashSet<>();
		
		for(int i = 0; i<ls.size(); i++) {
			
			suma = ls.get(i).stream().mapToInt(in -> in.getRelevancia()).sum();
			
			if(suma >= total) {

				total = suma;
				res = ls.get(i);
			
			}
		}
		
		return tuplaDatos.of(res, gf, c);
		
	}
	
	public static void apC(String file, Set<Calle> callesCortadas, String archivo) {
		
		tuplaDatos tupla = apartadoCaux(file, callesCortadas);
		
		GraphColors.toDot(tupla.gf, archivo, interseccion, c -> "",
				ver -> GraphColors.colorIf(Color.blue, Color.black, tupla.set.contains(ver)),
				ari -> GraphColors.colorIf(Color.blue, Color.black, tupla.set.contains(tupla.gf.getEdgeSource(ari))));
		
		String s="";
		if(tupla.met.isConnected()) {
			s="si";
		}else {
			s="no";
			
		}
		System.out.println("Se pueden visitar todos los monumentos a pie: " + s);
		
		
	}
		
}
