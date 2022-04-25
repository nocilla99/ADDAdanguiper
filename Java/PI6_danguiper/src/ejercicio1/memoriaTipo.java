package ejercicio1;
import java.util.*;

import us.lsi.common.IntPair;
import us.lsi.graphs.SimpleEdge;
import us.lsi.graphs.virtual.Action;
import us.lsi.graphs.virtual.VirtualVertex;

public class memoriaTipo {

	public record VertexEj1(List<Tipo_memoria> mems) 
	implements VirtualVertex<VertexEj1,EdgeEj1>{ //No action??

		@Override
		public Boolean isValid() {
			return null;
		}

		@Override
		public Set<VertexEj1> getNeighborListOf() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Set<EdgeEj1> edgesOf() {
			
			return null;
		}

		@Override
		public List<EdgeEj1> edgesListOf() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public EdgeEj1 getEdgeToVertex(VertexEj1 v2) {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}
	
	public record EdgeEj1(VertexEj1 source, VertexEj1 target, ActionEj1 action,Double weight)
	implements SimpleEdgeAction<VertexEj1,ActionEj1> {
		
		public static EdgeEj1 of(VertexEj1 v1, VertexEj1 v2, ActionEj1 a) {
			return new EdgeEj1(v1, v2, a, 1.);
		}
	}
	
	
	public record ActionEj1(String name,IntPair direction) implements Action<VertexEj1>{


		@Override
		public VertexEj1 neighbor(VertexEj1 v) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isApplicable(VertexEj1 v) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Double weight(VertexEj1 v) {
			// TODO Auto-generated method stub
			return null;
		}}
	
	
	public interface SimpleEdgeAction<V, A> extends SimpleEdge<V> {
			A action();
		}

}
