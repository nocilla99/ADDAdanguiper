package ejercicio1;

import org.jgrapht.GraphPath;

import us.lsi.graphs.alg.*;
import us.lsi.graphs.alg.DynamicProgramming.PDType;
import us.lsi.graphs.virtual.EGraph;
import us.lsi.graphs.virtual.SimpleVirtualGraph;

public class testPDR1 {

	public static void main(String[] args) {
		datosEj1.iniDatos("./fichero/PI6Ej1DatosEntrada2.txt");
		
		Ej1_Vertex v1= Ej1_Vertex.V_inicial();
		
		
		EGraph<Ej1_Vertex, Ej1_Edge> grafo= 
				SimpleVirtualGraph.sum(v1,Ej1_Vertex.goal(),e-> (double)e.weight());
		
		DynamicProgrammingReduction<Ej1_Vertex, Ej1_Edge> dpr= 
				DynamicProgrammingReduction.of(grafo,heuristicaEj1::heuristic,PDType.Max);
		
		GraphPath<Ej1_Vertex,Ej1_Edge> S= dpr.search().get();
		Solucion1 sol= Solucion1.of(S);
		System.out.println(sol);
		
		
		
		
		
	}

}
