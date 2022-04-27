package practs;

import java.util.function.Predicate;

public class heuristica {
	public static Double heuristic(pr3Vertex actual,Predicate<pr3Vertex> goal,pr3Vertex fin){
		
		//la adinidad tiene valor de 0-5
		
		if(actual.indice()>=datosprob3.getNumAlumnos()) {
			return 0.;
		}		
		
		Double h= (datosprob3.getNumAlumnos()-actual.indice()*5.);
		return h;
		
	}
}
