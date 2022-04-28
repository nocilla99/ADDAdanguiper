package ejercicio1;

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
	
	
	public static Ej1_Vertex V_final() {
		//esta bien este vertice?? capRestantes
		return of(datosEj1.getNumArchivos(),List2.ofTam(datosEj1.getNumMemorias(), 0));
	}
	@Override
	public List<Integer> actions() {
		
		if(indice>=datosEj1.getNumArchivos()) {
			return List2.empty();
		}
		return IntStream.range(0, datosEj1.getNumMemorias()-1)
				.filter(memos->datosEj1.getMemoria(memos).getTamMax()>=datosEj1.getArchivo(indice).getPeso()
						&& capRestantes.get(memos)>=datosEj1.getArchivo(indice).getPeso())
				.boxed().toList();
	}

	@Override
	public Ej1_Vertex neighbor(Integer a) {
		List<Integer> copia= List2.copy(capRestantes);
		
		//restarle a la capacidad el tamaño del archivo
		copia.set(a, copia.get(a)-datosEj1.getArchivo(indice).getPeso());
		return of(indice+1,copia);
	}

	private static Ej1_Vertex of(int i, List<Integer> listCaps) {
		return new Ej1_Vertex(i,listCaps);
	}

	@Override
	public Ej1_Edge edge(Integer a) {
		return Ej1_Edge.of(this, this.neighbor(a), a);
	}
	
	public static Predicate<Ej1_Vertex> goal(){
		return v->v.indice==datosEj1.getNumArchivos();
	}

}
