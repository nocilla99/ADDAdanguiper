package ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ejercicio4.datosEj4.Elemento;
import us.lsi.common.List2;
import us.lsi.graphs.virtual.VirtualVertex;

public record Ej4_Vertex(Integer indice,List<Integer> capRestantes) 
implements VirtualVertex<Ej4_Vertex,Ej4_Edge,Integer>{

public static Ej4_Vertex V_inicial() {
		
		List<Integer> memos = datosEj4.contenedores.stream().map(x->x.capacidad()).collect(Collectors.toList());
		
		return of(0,memos);
	}
	
	
	
	@Override
	public List<Integer> actions() {
		
		if(indice>=datosEj4.getNumElems()) {
			return List2.empty();
		}
		 List<Integer> la= new ArrayList<>();
		 Elemento elemento=datosEj4.getElemento(indice);
		 
		 la.add(-1);
		 la.addAll(IntStream.range(0, capRestantes.size())
				.filter(memos->capRestantes.get(memos)-elemento.tamaño()>=0
						&& elemento.tipos().contains(datosEj4.getContenedor(memos).tipo()))
				.boxed().toList());
		 
		 return la;
	}

	@Override
	public Ej4_Vertex neighbor(Integer a) {
		
			List<Integer> copia= List2.copy(capRestantes);
		if(a!=-1) {
				copia.set(a, copia.get(a)-datosEj4.getElemento(indice).tamaño());
			return of(indice+1,copia);
		}else {
			return of(indice+1,copia);
		}
	}

	private static Ej4_Vertex of(int i, List<Integer> listCaps) {
		return new Ej4_Vertex(i,listCaps);
	}

	@Override
	public Ej4_Edge edge(Integer a) {
		return Ej4_Edge.of(this, this.neighbor(a), a);
	}
	
	public static Predicate<Ej4_Vertex> goal(){
		return v->v.indice==datosEj4.getNumElems();
	}
}
