package ejercicio2;

import java.util.function.Predicate;

public class heuristicaEj2 {
	public static Double heuristic(Ej2_Vertex actual,Predicate<Ej2_Vertex> goal,Ej2_Vertex fin){
		
		if(actual.indice()>=datosEj2.getNumCandidatos()) {
			return 0.;
		}	
		int valos=0;
		for(int i=actual.indice();i<datosEj2.getNumCandidatos();i++) {
			valos+=datosEj2.getCandidato(i).valoracion();
		}
		Double h= (datosEj2.getNumCandidatos()*5-(double)valos);
		return h;
		
	}
}
