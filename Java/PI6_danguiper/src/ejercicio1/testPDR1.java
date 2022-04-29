package ejercicio1;

import org.jgrapht.GraphPath;

import us.lsi.graphs.alg.*;
import us.lsi.graphs.alg.DynamicProgramming.PDType;
import us.lsi.graphs.virtual.EGraph;
import us.lsi.graphs.virtual.SimpleVirtualGraph;

public class testPDR1 {

	public static void main(String[] args) {
		datosEj1.iniDatos("./fichero/PI6Ej1DatosEntrada2.txt");
		
		Ej2_Vertex v1= Ej2_Vertex.V_inicial();
		
		
		EGraph<Ej2_Vertex, Ej2_Edge> grafo= 
				SimpleVirtualGraph.sum(v1,Ej2_Vertex.goal(),e-> (double)e.weight());
		
		DynamicProgrammingReduction<Ej2_Vertex, Ej2_Edge> dpr= 
				DynamicProgrammingReduction.of(grafo,heuristicaEj1::heuristic,PDType.Max);
		
		GraphPath<Ej2_Vertex,Ej2_Edge> S= dpr.search().get();
		Solucion1 sol= Solucion1.of(S);
		System.out.println(sol);
		
		
		
		
		
	}

}
