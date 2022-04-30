package ejercicio3;


import org.jgrapht.GraphPath;
import us.lsi.graphs.alg.*;
import us.lsi.graphs.alg.DynamicProgramming.PDType;
import us.lsi.graphs.virtual.EGraph;
import us.lsi.graphs.virtual.SimpleVirtualGraph;

public class testPDR3 {

	public static void main(String[] args) {
		datosEj3.iniDatos("./fichero/PI6Ej3DatosEntrada1.txt");
		Ej3_Vertex v1= Ej3_Vertex.V_inicial();
		
		
		EGraph<Ej3_Vertex, Ej3_Edge> grafo= 
				SimpleVirtualGraph.sum(v1,Ej3_Vertex.goal(),e-> (double)e.weight());
		
		DynamicProgrammingReduction<Ej3_Vertex, Ej3_Edge> dpr= 
				DynamicProgrammingReduction.of(grafo,heuristicaEj3::heuristic,PDType.Max);
		
		GraphPath<Ej3_Vertex,Ej3_Edge> S= dpr.search().get();
		Solucion3 sol= Solucion3.of(S);
		System.out.println(sol);
		
		
		
		
		
	}

}
