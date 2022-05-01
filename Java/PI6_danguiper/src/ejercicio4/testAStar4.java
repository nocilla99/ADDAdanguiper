package ejercicio4;

import org.jgrapht.GraphPath;
import us.lsi.graphs.alg.AStar;
import us.lsi.graphs.alg.AStar.AStarType;
import us.lsi.graphs.virtual.EGraph;
import us.lsi.graphs.virtual.SimpleVirtualGraph;

public class testAStar4 {
	public static void main(String[] args) {
		
		datosEj4.iniDatos("./fichero/PI6Ej4DatosEntrada2.txt");
		
		Ej4_Vertex v1= Ej4_Vertex.V_inicial();
		
		
		EGraph<Ej4_Vertex, Ej4_Edge> graph= 
				SimpleVirtualGraph.sum(v1,Ej4_Vertex.goal(),e-> (double)e.weight());
		
		AStar<Ej4_Vertex, Ej4_Edge> ms= AStar.of(graph,heuristicaEj4::heuristic,AStarType.Max);
		
		GraphPath<Ej4_Vertex, Ej4_Edge> path = ms.search().get();
		Solucion4 s =Solucion4.of(path);
		System.out.println(s);
	}
}
