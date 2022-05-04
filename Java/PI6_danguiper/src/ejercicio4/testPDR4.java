package ejercicio4;

import org.jgrapht.GraphPath;

import us.lsi.graphs.alg.DynamicProgrammingReduction;
import us.lsi.graphs.alg.DynamicProgramming.PDType;
import us.lsi.graphs.virtual.EGraph;
import us.lsi.graphs.virtual.SimpleVirtualGraph;

public class testPDR4 {

	public static void main(String[] args) {
			datosEj4.iniDatos("./fichero/PI6Ej4DatosEntrada2.txt");
			Ej4_Vertex v1= Ej4_Vertex.V_inicial();
			
			
			EGraph<Ej4_Vertex, Ej4_Edge> grafo= 
					SimpleVirtualGraph.sum(v1,Ej4_Vertex.goal(),e-> (double)e.weight());
			
			DynamicProgrammingReduction<Ej4_Vertex, Ej4_Edge> dpr= 
					DynamicProgrammingReduction.of(grafo,heuristicaEj4::heuristic,PDType.Min);
			
			GraphPath<Ej4_Vertex,Ej4_Edge> S= dpr.search().get();
			Solucion4 sol= Solucion4.of(S);
			System.out.println(sol);	
			
		}

}
