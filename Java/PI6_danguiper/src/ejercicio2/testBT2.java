package ejercicio2;
import us.lsi.graphs.alg.*;
import us.lsi.graphs.alg.BackTracking.BTType;
import us.lsi.graphs.virtual.EGraph;
import us.lsi.graphs.virtual.SimpleVirtualGraph;

public class testBT2 {
	
	public static void main(String[] args) {
		datosEj2.iniDatos("./fichero/PI6Ej2DatosEntrada1.txt");
		
		Ej2_Vertex v1= Ej2_Vertex.V_inicial();
		
		EGraph<Ej2_Vertex, Ej2_Edge> grafo= 
				SimpleVirtualGraph.sum(v1,Ej2_Vertex.goal(),e-> (double)e.weight());
		
		BackTracking<Ej2_Vertex, Ej2_Edge, Solucion2> bt1=
				BackTracking.of(grafo,heuristicaEj2::heuristic, Solucion2::of, BTType.Max);
		bt1.search();
		System.out.println(bt1.getSolution().get());
	}

}
