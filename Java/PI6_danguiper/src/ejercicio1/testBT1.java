package ejercicio1;
import org.jgrapht.GraphPath;
import us.lsi.graphs.alg.*;
import us.lsi.graphs.alg.BackTracking.BTType;
import us.lsi.graphs.virtual.EGraph;
import us.lsi.graphs.virtual.SimpleVirtualGraph;

public class testBT1 {

	public static void main(String[] args) {
		datosEj1.iniDatos("./fichero/PI6Ej1DatosEntrada1.txt");
		
		Ej1_Vertex v1= Ej1_Vertex.V_inicial();
		
		EGraph<Ej1_Vertex, Ej1_Edge> grafo= 
				SimpleVirtualGraph.sum(v1,Ej1_Vertex.goal(),e-> (double)e.weight());
		
		BackTracking<Ej1_Vertex, Ej1_Edge, Integer> bt1=
				BackTracking.of(grafo,heuristicaEj1::heuristic, null, BTType.Max);
															   //greedy?
		GraphPath<Ej1_Vertex,Ej1_Edge> S= bt1.optimalPath().get();
		Solucion1 sol= Solucion1.of(S);
		System.out.println(sol);
	}

}
