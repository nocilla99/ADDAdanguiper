package ejercicio4;

import us.lsi.graphs.virtual.SimpleEdgeAction;

public record Ej4_Edge (Ej4_Vertex source, Ej4_Vertex target, Integer action,Double weight) 
implements SimpleEdgeAction<Ej4_Vertex,Integer>{

	public static Ej4_Edge of(Ej4_Vertex source,Ej4_Vertex target,Integer action) {
		//ver si esa memoria se llena o no -> peso
		long  memsllenas= source.capRestantes().stream().filter(ele->ele!=0).count();
		return new Ej4_Edge(source,target,action,Double.valueOf(memsllenas));
	}
}
