package ejercicio4;

import java.util.function.Predicate;


public class heuristicaEj4 {
	public static Double heuristic(Ej4_Vertex actual,Predicate<Ej4_Vertex> goal,Ej4_Vertex fin){
		
		if(actual.indice()>=datosEj4.getNumElems()) {
			return 0.;
		}	
		
		long  contllenas= actual.capRestantes().stream().filter(cnt->cnt==0).count(); 
		int h= (datosEj4.getNumContenedores()-(int)contllenas);
		return Double.valueOf(h);
		//return (double) datosEj4.getNumElems()-actual.indice();
		
	}
}
