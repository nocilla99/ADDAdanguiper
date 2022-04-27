package practs;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import us.lsi.common.List2;
import us.lsi.graphs.virtual.VirtualVertex;

public record pr3Vertex(int indice,List<Integer> capRestante) implements VirtualVertex<pr3Vertex,prArista,Integer>{

	
	public static pr3Vertex of(int indice,List<Integer> capRestante) {
		return new pr3Vertex(indice,capRestante);
	}
	
	public static pr3Vertex inicial() {
		int k= datosprob3.getTamGrupo();
		int m= datosprob3.getNumGrupos();
		
		return of(0,List2.ofTam(k, m));
	}
	
	public static Predicate<pr3Vertex> goal(){
		return v->v.indice==datosprob3.getNumAlumnos();
	}
	
	@Override
	public List<Integer> actions() {
		List<Integer> la= List2.empty();
		if(indice>= datosprob3.getNumAlumnos()) {
			return la;
		}
			return IntStream.range(0, datosprob3.getNumGrupos()).filter(g-> capRestante.get(g)>0).filter(g-> datosprob3.getAfinidad(indice,g)>0).boxed().toList();
	}

	@Override
	public pr3Vertex neighbor(Integer a) {
		List<Integer> copia= List2.copy(capRestante);
		copia.set(a, copia.get(a)-1);
		return of(indice+1,copia);
	}

	@Override
	public prArista edge(Integer a) {
		return prArista.of(this,this.neighbor(a),a);
	}


	
}
