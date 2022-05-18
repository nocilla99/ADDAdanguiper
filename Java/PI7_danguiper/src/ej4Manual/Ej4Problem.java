package ej4Manual;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import datos.datosEj4;
import us.lsi.common.List2;
import us.lsi.common.Preconditions;

public record Ej4Problem(Integer indice,List<Integer> capRestantes)  {  //COMO VERTEX
	 
	public static Ej4Problem of(Integer indice,List<Integer> capRestantes) {
		Preconditions.checkArgument(indice>=0 && indice<=datosEj4.getNumElems(),
				"indice: "+indice+" ca: "+capRestantes);
		return new Ej4Problem(indice,capRestantes);
	}
	
	
	public Ej4Problem vecino(Integer a) { //idem a vertex
		List<Integer> cap2 = List2.copy(capRestantes);
		if (a < datosEj4.contenedores.size()) cap2.set(a, cap2.get(a) - datosEj4.elementos.get(indice).tamaño());
		
		return of(indice + 1, cap2);
	}

	public int peso() {
		return (int) capRestantes.stream().filter(x->x==0).count();
	}
	
	public List<Integer> actions() { //idem a vertex 
		List<Integer> la = List2.empty();
		
		if (indice >= datosEj4.getNumElems()) {
			return la;
		}
		
		List<Integer> containers = IntStream.rangeClosed(0, datosEj4.contenedores.size()).boxed().collect(Collectors.toList());
		
		for (int i: containers) {
			if (i < datosEj4.contenedores.size()
				&& datosEj4.elementos.get(indice).tamaño() <= capRestantes.get(i)
				&& datosEj4.elementos.get(indice).tipos().contains(datosEj4.contenedores.get(i).tipo())) {
				
				la.add(i);
				
			} else if (i == datosEj4.contenedores.size()) {
				la.add(i);
			}
		}
		
		return la;
	}


	public static Predicate<Ej4Problem> constraint() {
		
		return x -> IntStream.range(0, datosEj4.contenedores.size()).boxed()
				.allMatch(c -> x.capRestantes.get(c) == 0
						|| x.capRestantes.get(c) == datosEj4.contenedores.get(c).capacidad());
	}
	
}
