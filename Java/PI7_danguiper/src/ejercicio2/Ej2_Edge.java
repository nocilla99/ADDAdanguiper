package ejercicio2;

import us.lsi.graphs.virtual.SimpleEdgeAction;

public record Ej2_Edge(Ej2_Vertex source,Ej2_Vertex target, Integer action,Double weight) implements SimpleEdgeAction<Ej2_Vertex, Integer> {

	
	public static Ej2_Edge of(Ej2_Vertex src,Ej2_Vertex dst, Integer action) {
		
		Double p= (double) datosEj2.getCandidato(src.indice()).valoracion()*action;
		return new Ej2_Edge(src,dst,action,p);
		
	}
	
	
	

}
