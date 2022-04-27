package practs;

import us.lsi.graphs.virtual.SimpleEdgeAction;

public record prArista(pr3Vertex source,pr3Vertex target, Integer action,Double weight) implements SimpleEdgeAction<pr3Vertex, Integer> {

	
	public static prArista of(pr3Vertex src,pr3Vertex dst, Integer action) {
		
		Double p= (double) datosprob3.getAfinidad(src.indice(),action);
		return new prArista(src,dst,action,p);
		
	}
	
	
	

}
