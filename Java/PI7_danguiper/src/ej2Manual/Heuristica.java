package ej2Manual;

import java.util.List;
import ejercicio2.datosEj2;

public class Heuristica {

private static record Heu_Ej2(Integer indice, List<String> cualidadesRestantes,List<Integer> alternativas) {	//COMO VERTEX
		
		public static Heu_Ej2 of(Integer index, List<String> cualis,List<Integer> alternativas) { //constructor mitico
			return new Heu_Ej2(index, cualis,alternativas);
		}		
	}

	public static Integer cota(Ej2Problem vertice, Integer a) { //peso arista+ heuristica vecino
		Ej2Problem v2= vertice.vecino(a);
		return a*(datosEj2.getCandidato(vertice.indice()).valoracion())+heuristica(v2);
	}

	private static Integer heuristica(Ej2Problem v1) { //mejor camino desde v1.indice hasta final  (funcion objetivo)
		Heu_Ej2 v= Heu_Ej2.of(v1.indice(),v1.cualisPendientes(),v1.alternativas());
		int valos=0;
		if(v.indice()>=datosEj2.getNumCandidatos()) {
			return 0;
		}
		for(int i=v.indice();i<datosEj2.getNumCandidatos();i++) {
			valos+=datosEj2.getCandidato(i).valoracion();
		}
		int h= (datosEj2.getNumCandidatos()*5-valos);
		return h;
		
	}

}
