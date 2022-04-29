package ejercicio1;
import org.jgrapht.GraphPath;
import us.lsi.graphs.alg.*;
import us.lsi.graphs.alg.BackTracking.BTType;
import us.lsi.graphs.virtual.EGraph;
import us.lsi.graphs.virtual.SimpleVirtualGraph;

public class testBT1 {

	public static void main(String[] args) {
		datosEj1.iniDatos("./fichero/PI6Ej1DatosEntrada1.txt");
		
		Ej2_Vertex v1= Ej2_Vertex.V_inicial();
		
		EGraph<Ej2_Vertex, Ej2_Edge> grafo= 
				SimpleVirtualGraph.sum(v1,Ej2_Vertex.goal(),e-> (double)e.weight());
		
		BackTracking<Ej2_Vertex, Ej2_Edge, Integer> bt1=
				BackTracking.of(grafo,heuristicaEj1::heuristic,null, BTType.Max);
															   //greedy?
		GraphPath<Ej2_Vertex,Ej2_Edge> S= bt1.optimalPath().get();
		Solucion1 sol= Solucion1.of(S);
		System.out.println(sol);
	}

}
