package ejercicio4;
import us.lsi.graphs.alg.*;
import us.lsi.graphs.alg.BackTracking.BTType;
import us.lsi.graphs.virtual.EGraph;
import us.lsi.graphs.virtual.SimpleVirtualGraph;

public class testBT4 {

	public static void main(String[] args) {
		datosEj4.iniDatos("./fichero/PI6Ej4DatosEntrada1.txt");
		
		Ej4_Vertex v1= Ej4_Vertex.V_inicial();
		
		EGraph<Ej4_Vertex, Ej4_Edge> grafo= 
				SimpleVirtualGraph.sum(v1,Ej4_Vertex.goal(),e-> (double)e.weight());
		
		BackTracking<Ej4_Vertex, Ej4_Edge, Solucion4> bt1=
				BackTracking.of(grafo,heuristicaEj4::heuristic, Solucion4::of, BTType.Max);
		bt1.search();
		System.out.println(bt1.getSolution().get());
	}

}
