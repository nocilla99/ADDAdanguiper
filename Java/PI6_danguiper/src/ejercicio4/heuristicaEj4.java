package ejercicio4;

import java.util.function.Predicate;


public class heuristicaEj4 {
	public static Double heuristic(Ej4_Vertex actual,Predicate<Ej4_Vertex> goal,Ej4_Vertex fin){
		
		if(actual.indice()>=datosEj4.getNumElems()) {
			return 0.;
		}	
		
		//total de contenedores - los que estan a 0 de cap restante
		long  memsllenas= actual.capRestantes().stream().filter(cnt->cnt==0).count(); 
		int h= (datosEj4.getNumContenedores()-(int)memsllenas);
		return Double.valueOf(h);
		
	}
}
