package ejercicio1;

import us.lsi.graphs.virtual.SimpleEdgeAction;

public record Ej2_Edge(Ej2_Vertex source, Ej2_Vertex target, Integer action,Double weight) implements SimpleEdgeAction<Ej2_Vertex,Integer>{

		public static Ej2_Edge of(Ej2_Vertex source, Ej2_Vertex target, Integer action) {
			return new Ej2_Edge(source,target,action,(action==-1)?0.:1.);
			
		}


}
