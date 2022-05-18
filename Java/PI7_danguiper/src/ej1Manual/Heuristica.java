package ej1Manual;

import java.util.List;

import datos.datosEj1;

public class Heuristica {

private static record Heu_Ej1(Integer indice, List<Integer> CapsRestantes) {		
		
		public static Heu_Ej1 of(Integer index, List<Integer> caps) {
			return new Heu_Ej1(index, caps);
		}		
	}

	public static Integer cota(Ej1Problem vertice, Integer a) {
		Ej1Problem v2= vertice.vecino(a);
		int elem= (a!=-1)?1:0;
		return elem+heuristica(v2);
	}

	private static Integer heuristica(Ej1Problem v1) {
		Heu_Ej1 v= Heu_Ej1.of(v1.indice(),v1.capRestantes());
		int r=0;
		int ind= v.indice;
		while(ind<datosEj1.getNumArchivos()) {
			r+=1;
			ind++;
		}
		return r;
	}

}
