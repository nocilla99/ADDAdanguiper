package ejercicio1;

import us.lsi.graphs.alg.*;
import us.lsi.graphs.alg.DynamicProgramming.PDType;
import us.lsi.graphs.virtual.EGraph;
import us.lsi.graphs.virtual.SimpleVirtualGraph;

public class testPDR1 {

	public static void main(String[] args) {
		datosEj1.iniDatos("./fichero/PI6Ej1DatosEntrada1.txt");
		
		Ej1_Vertex v1= Ej1_Vertex.V_inicial();
		Ej1_Vertex v2= Ej1_Vertex.V_final();
		
		
		EGraph<Ej1_Vertex, Ej1_Edge> grafo= 
				SimpleVirtualGraph.last(v1,Ej1_Vertex.goal(),v-> (double)v.indice(),v2);
		
		DynamicProgrammingReduction<Ej1_Vertex, Ej1_Edge> dpr= 
				DynamicProgrammingReduction.of(grafo,heuristicaEj1::heuristic,PDType.Min);
		
		//HAce falta lo de greedy?
		
		
		
		
	}

}
