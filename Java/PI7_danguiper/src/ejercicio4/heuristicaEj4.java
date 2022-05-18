package ejercicio4;

import java.util.function.Predicate;

import datos.datosEj4;


public class heuristicaEj4 {
	public static Double heuristic(Ej4_Vertex actual,Predicate<Ej4_Vertex> goal,Ej4_Vertex fin){
		
		if(actual.indice()>=datosEj4.getNumElems()) {
			return 0.;
		}	
		
		long  contllenas= actual.capRestantes().stream().filter(cnt->cnt==0).count(); 
		int h= (int)contllenas-datosEj4.getNumContenedores();
		return Double.valueOf(h);
		
	}
}
