package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import us.lsi.common.List2;
import us.lsi.graphs.virtual.VirtualVertex;

public record Ej1_Vertex(Integer indice,List<Integer> capRestantes) 
	implements VirtualVertex<Ej1_Vertex,Ej1_Edge,Integer>{

	public static Ej1_Vertex V_inicial() {
		
		List<Integer> memos = datosEj1.getMemorias().stream().map(x->x.getCapacidad()).collect(Collectors.toList());
		
		return of(0,memos);
	}
	
	
	
	@Override
	public List<Integer> actions() {
		
		if(indice>=datosEj1.getNumArchivos()) {
			return List2.empty();
		}
		 List<Integer> la= new ArrayList<>();
		 la.add(-1);
		 la.addAll(IntStream.range(-1, datosEj1.getNumMemorias())
				.filter(x->x!=-1).filter(memos->datosEj1.getMemoria(memos).getTamMax()>=datosEj1.getArchivo(indice).getPeso()
						&& capRestantes.get(memos)>=datosEj1.getArchivo(indice).getPeso())
				.boxed().toList());
		 
		 return la;
	}

	@Override
	public Ej2_Vertex neighbor(Integer a) {
		
			List<Integer> copia= List2.copy(capRestantes);
		if(a!=-1) {
				copia.set(a, copia.get(a)-datosEj1.getArchivo(indice).getPeso());
			return of(indice+1,copia);
		}else {
			return of(indice+1,copia);
		}
	}

	private static Ej2_Vertex of(int i, List<Integer> listCaps) {
		return new Ej2_Vertex(i,listCaps);
	}

	@Override
	public Ej2_Edge edge(Integer a) {
		return Ej2_Edge.of(this, this.neighbor(a), a);
	}
	
	public static Predicate<Ej2_Vertex> goal(){
		return v->v.indice==datosEj1.getNumArchivos();
	}

}
