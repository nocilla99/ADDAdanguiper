package ej4Manual;

public class Heuristica {
	

	public static double cota(Ej4Problem vertice, Integer a) { //peso arista final
		Ej4Problem v2= vertice.vecino(a);
		return heuristica(v2);
	}

	private static double heuristica(Ej4Problem v1) { //contenedores llenos
		return 1.*v1.peso();
	}

}
