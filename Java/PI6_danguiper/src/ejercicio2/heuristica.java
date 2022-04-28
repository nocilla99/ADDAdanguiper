package ejercicio2;

import java.util.function.Predicate;

public class heuristica {
	public static Double heuristic(Ej2_Vertex actual,Predicate<Ej2_Vertex> goal,Ej2_Vertex fin){
		
		//la adinidad tiene valor de 0-5
		
		if(actual.indice()>=datosEj2.getNumCandidatios()) {
			return 0.;
		}		
		
		Double h= (datosEj2.getNumCandidatios()*5-actual.indice()*5.);
		for restantes :: valoraciones
		return h;
		
	}
}
