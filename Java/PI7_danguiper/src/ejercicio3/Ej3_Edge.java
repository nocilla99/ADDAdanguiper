package ejercicio3;

import us.lsi.graphs.virtual.SimpleEdgeAction;

public record Ej3_Edge(Ej3_Vertex source,Ej3_Vertex target, Integer action,Double weight) implements SimpleEdgeAction<Ej3_Vertex, Integer> {

	
	public static Ej3_Edge of(Ej3_Vertex src,Ej3_Vertex dst, Integer action) {
		//double p=src.gananciasAcumuladas();
		double p=0.;
		p= datosEj3.getProducto(src.indice()).precio()*action;
		
		return new Ej3_Edge(src,dst,action,p);
		
	}
	
	
	

}
