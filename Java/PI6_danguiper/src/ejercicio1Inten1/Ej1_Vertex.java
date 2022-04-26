package ejercicio1Inten1;

import java.util.List;
import java.util.stream.Collectors;
import us.lsi.graphs.virtual.VirtualVertex;

public record Ej1_Vertex(Integer index, List<Integer> CapRestante,List<Integer> MaxPermitido) 
implements VirtualVertex<Ej1_Vertex,Ej1_Edge,Ej1_Action>{
	
	public static Ej1_Vertex of(Integer index, List<Integer> CapRestante,List<Integer> MaxPermitido) {
		return new Ej1_Vertex(index,CapRestante,MaxPermitido);
	}

	public static Ej1_Vertex inicialV(List<TipoArchivo> files,List<Tipo_memoria> memos) {
		return of(0,
				memos.stream().map(x->x.getCapacidad()).collect(Collectors.toList()),
				memos.stream().map(x->x.getTamMax()).collect(Collectors.toList()));
	}
	

	public static Ej1_Vertex finalV(List<TipoArchivo> files,List<Tipo_memoria> memos) {
		return of(files.size(),
				memos.stream().map(x->x.getCapacidad()*0).collect(Collectors.toList()),
				memos.stream().map(x->x.getTamMax()).collect(Collectors.toList()));
	}

	@Override
	public List<Ej1_Action> actions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ej1_Vertex neighbor(Ej1_Action a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ej1_Edge edge(Ej1_Action a) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
