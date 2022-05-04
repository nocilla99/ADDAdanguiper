package ejercicio1;
import us.lsi.graphs.alg.*;
import us.lsi.graphs.alg.BackTracking.BTType;
import us.lsi.graphs.virtual.EGraph;
import us.lsi.graphs.virtual.SimpleVirtualGraph;

public class testBT1 {

	public static void main(String[] args) {
		datosEj1.iniDatos("./fichero/PI6Ej1DatosEntrada2.txt");
		
		Ej1_Vertex v1= Ej1_Vertex.V_inicial();
		
		EGraph<Ej1_Vertex, Ej1_Edge> grafo= 
				SimpleVirtualGraph.sum(v1,Ej1_Vertex.goal(),e-> (double)e.weight());
		
		BackTracking<Ej1_Vertex, Ej1_Edge, Solucion1> bt1=
				BackTracking.of(grafo,heuristicaEj1::heuristic, Solucion1::of, BTType.Max);
		bt1.search();
		System.out.println(bt1.getSolution().get());
	}

}
