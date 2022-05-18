package ej4Manual;

public class Heuristica {
	


	public static Double heuristic(Ej4Problem actual) {
		return actual.peso()*1.0;
	}
	
	public static Double cota(Ej4Problem v1, Integer a) {
		Ej4Problem v2 = v1.vecino(a);
		return heuristic(v2);
	}
	
}

