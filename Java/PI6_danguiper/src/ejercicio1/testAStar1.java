package ejercicio1;

import java.util.List;

import org.jgrapht.GraphPath;
import us.lsi.graphs.alg.*;
import us.lsi.graphs.alg.AStar.AStarType;
import us.lsi.graphs.virtual.EGraph;
import us.lsi.graphs.virtual.SimpleVirtualGraph;

public class testAStar1 {

	public static void main(String[] args) {
		datosEj1.iniDatos("./fichero/PI6Ej1DatosEntrada1.txt");
		
		Ej1_Vertex v1= Ej1_Vertex.V_inicial();
		Ej1_Vertex v2= Ej1_Vertex.V_final();
		
		
		EGraph<Ej1_Vertex, Ej1_Edge> graph= 
				SimpleVirtualGraph.last(v1,Ej1_Vertex.goal(),v-> (double)v.indice(),v2);
		
		AStar<Ej1_Vertex, Ej1_Edge> ms= AStar.of(graph,heuristicaEj1::heuristic,AStarType.Min);
		
		GraphPath<Ej1_Vertex, Ej1_Edge> path = ms.search().get();
		List<Ej1_Edge> edges = path.getEdgeList();
		System.out.println(edges);
		Solucion1 s =Solucion1.of(path);
		System.out.println(s);
		
		
		
	}

}
