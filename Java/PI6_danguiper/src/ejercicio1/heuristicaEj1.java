package ejercicio1;

import java.util.function.Predicate;


public class heuristicaEj1 {
	public static Double heuristic(Ej2_Vertex actual,Predicate<Ej2_Vertex> goal,Ej2_Vertex fin){
		
		if(actual.indice()>=datosEj1.getNumArchivos()) {
			return 0.;
		}
		return (double)datosEj1.getNumArchivos()-actual.indice();

	}
}
