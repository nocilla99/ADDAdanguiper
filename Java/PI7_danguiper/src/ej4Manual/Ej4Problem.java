package ej4Manual;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import datos.datosEj4.Elemento;
import datos.datosEj4;
import us.lsi.common.List2;
import us.lsi.common.Preconditions;

public record Ej4Problem(Integer indice,List<Integer> capRestantes)  {  //COMO VERTEX
	 
	public static Ej4Problem of(Integer indice,List<Integer> capRestantes) {
		Preconditions.checkArgument(indice>=0 && indice<=datosEj4.getNumElems(),
				"indice: "+indice+" Tprod: "+capRestantes);
		return new Ej4Problem(indice,capRestantes);
	}
	
	
	public Ej4Problem vecino(Integer a) { //idem a vertex
		List<Integer> copia= List2.copy(capRestantes);
		if(a!=-1) {
				copia.set(a, copia.get(a)-datosEj4.getElemento(indice).tamaño());
			return of(indice+1,copia);
		}else {
			return of(indice+1,copia);
		}
	}

	public int peso() {
		return (int) capRestantes.stream().filter(x->x==0).count();
	}
	
	public List<Integer> actions() { //idem a vertex 
		if(indice>=datosEj4.getNumElems()) {
			return List2.empty();
		}
		 List<Integer> la= new ArrayList<>();
		 Elemento elemento=datosEj4.getElemento(indice);
		 
		 la.add(-1);
		 la.addAll(IntStream.range(0, datosEj4.getNumContenedores())
				.filter(c->capRestantes.get(c)-elemento.tamaño()>=0
						&& elemento.tipos().contains(datosEj4.getContenedor(c).tipo()))
				.boxed().toList());
		 
		 return la;
	}
	
}
