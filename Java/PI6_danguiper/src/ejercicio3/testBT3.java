package ejercicio3;
import us.lsi.graphs.alg.*;
import us.lsi.graphs.alg.BackTracking.BTType;
import us.lsi.graphs.virtual.EGraph;
import us.lsi.graphs.virtual.SimpleVirtualGraph;

public class testBT3 {

	public static void main(String[] args) {
		datosEj3.iniDatos("./fichero/PI6Ej3DatosEntrada2.txt");
		
		Ej3_Vertex v1= Ej3_Vertex.V_inicial();
		
		EGraph<Ej3_Vertex, Ej3_Edge> grafo= 
				SimpleVirtualGraph.sum(v1,Ej3_Vertex.goal(),e-> (double)e.weight());
		
		BackTracking<Ej3_Vertex, Ej3_Edge, Solucion3> bt1=
				BackTracking.of(grafo,heuristicaEj3::heuristic, Solucion3::of, BTType.Max);
		bt1.search();
		System.out.println(bt1.getSolution().get());
	}

}
