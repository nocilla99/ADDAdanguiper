package ej1Manual;

import java.util.List;

import ejercicio1.datosEj1;
import us.lsi.common.List2;

public class Heuristica {

private static record Heu_Ej1(Integer indice, List<Integer> CapsRestantes) {		
		
		public static Heu_Ej1 of(Integer index, List<Integer> caps) {
			return new Heu_Ej1(index, caps);
		}
		//--------------------------------------------------------------------------mirar esto
		public int heuristicAction() {
			if(indice>=datosEj1.getNumArchivos()) {
				return 0;
			}
			return datosEj1.getNumArchivos()-indice;
		}
		
		public Heu_Ej1 vecino(Integer a) {

			List<Integer> copia= List2.copy(this.CapsRestantes);
		if(a!=-1) {
				copia.set(a, copia.get(a)-datosEj1.getArchivo(indice).getPeso());
			return of(indice+1,copia);
		}else {
			return of(indice+1,copia);
		}
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
			/*int accion= v.heuristicAction();
		
			Double elem= (accion!=-1)?1.:0.;
			r+=elem;
			//-----------------------El error esta aqui
			
			v=v.vecino(accion);*/
			r+=1;
			ind++;
		}
		return r;
	}

}
