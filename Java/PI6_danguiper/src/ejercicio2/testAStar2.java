package ejercicio2;


import org.jgrapht.GraphPath;
import us.lsi.graphs.alg.*;
import us.lsi.graphs.alg.AStar.AStarType;
import us.lsi.graphs.virtual.EGraph;
import us.lsi.graphs.virtual.SimpleVirtualGraph;

public class testAStar2 {

	public static void main(String[] args) {
		datosEj2.iniDatos("./fichero/PI6Ej2DatosEntrada2.txt");
		
		Ej2_Vertex v1= Ej2_Vertex.V_inicial();
		
		
		EGraph<Ej2_Vertex, Ej2_Edge> graph= 
				SimpleVirtualGraph.sum(v1,Ej2_Vertex.goal(),e-> (double)e.weight());
		
		AStar<Ej2_Vertex, Ej2_Edge> ms= AStar.of(graph,heuristicaEj2::heuristic,AStarType.Max);
		
		GraphPath<Ej2_Vertex, Ej2_Edge> path = ms.search().get();
		Solucion2 s =Solucion2.of(path);
		System.out.println(s);
		
		
		
	}

}
