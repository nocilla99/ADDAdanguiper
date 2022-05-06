package ejercicio1;

import us.lsi.graphs.virtual.SimpleEdgeAction;

public record Ej1_Edge(Ej1_Vertex source, Ej1_Vertex target, Integer action,Double weight) implements SimpleEdgeAction<Ej1_Vertex,Integer>{

		public static Ej1_Edge of(Ej1_Vertex source, Ej1_Vertex target, Integer action) {
			return new Ej1_Edge(source,target,action,(action==-1)?0.:1.);
			
		}


}
