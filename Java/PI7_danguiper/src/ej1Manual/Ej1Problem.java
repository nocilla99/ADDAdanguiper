package ej1Manual;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import datos.datosEj1;
import us.lsi.common.List2;
import us.lsi.common.Preconditions;

public record Ej1Problem(Integer indice,List<Integer> capRestantes) {
	static Ej1Problem of(Integer indice, List<Integer> capRestantes) {
		Preconditions.checkArgument(indice>=0 && indice<=datosEj1.getNumArchivos(),
				"indice: "+indice+" Memorias: "+capRestantes);
		return new Ej1Problem(indice, capRestantes);
	}
	
	public Ej1Problem vecino(Integer a) {
		
		List<Integer> copia= List2.copy(capRestantes);
		if(a!=-1) {
				copia.set(a, copia.get(a)-datosEj1.getArchivo(indice).getPeso());
			return of(indice+1,copia);
		}else {
			return of(indice+1,copia);
		}
	}
	
	public List<Integer> actions() {
			
		if(indice>=datosEj1.getNumArchivos()) {
			return List2.empty();
		}
		 List<Integer> la= new ArrayList<>();
		 la.add(-1);
		 la.addAll(IntStream.range(0, datosEj1.getNumMemorias())
				.filter(memos->datosEj1.getMemoria(memos).getTamMax()>=datosEj1.getArchivo(indice).getPeso()
						&& capRestantes.get(memos)>=datosEj1.getArchivo(indice).getPeso() 
						//ESTO ES NUEVO
						&&  capRestantes.get(memos)-datosEj1.getArchivo(indice).peso() >=0)
				.boxed().toList());
		 
		 return la;
	}
	
	
	
}
