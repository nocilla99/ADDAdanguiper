package ejercicio1;


import org.jgrapht.GraphPath;
import us.lsi.graphs.alg.*;
import us.lsi.graphs.alg.AStar.AStarType;
import us.lsi.graphs.virtual.EGraph;
import us.lsi.graphs.virtual.SimpleVirtualGraph;

public class testAStar1 {

	public static void main(String[] args) {
		datosEj1.iniDatos("./fichero/PI6Ej1DatosEntrada1.txt");
		
		Ej1_Vertex v1= Ej1_Vertex.V_inicial();
		
		
		EGraph<Ej1_Vertex, Ej1_Edge> graph= 
				SimpleVirtualGraph.sum(v1,Ej1_Vertex.goal(),e-> (double)e.weight());
		
		AStar<Ej1_Vertex, Ej1_Edge> ms= AStar.of(graph,heuristicaEj1::heuristic,AStarType.Max);
		
		GraphPath<Ej1_Vertex, Ej1_Edge> path = ms.search().get();
		Solucion1 s =Solucion1.of(path);
		System.out.println(s);
		
		
		
	}

}
