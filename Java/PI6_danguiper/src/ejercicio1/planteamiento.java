package ejercicio1;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator.OfDouble;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.math3.linear.Array2DRowFieldMatrix;

import us.lsi.common.IntPair;
import us.lsi.graphs.SimpleEdge;
import us.lsi.graphs.virtual.Action;
import us.lsi.graphs.virtual.VirtualVertex;

public class planteamiento {
	
	static List<Tipo_memoria> mems;
	static List<TipoArchivo> files;
	
	
	public record Vertices1 (int indice, List<Integer> capacidades) implements VirtualVertex<Vertices1,Aristas1>{

		
		public static Vertices1 initialVertex() {
			return of(mems.stream().map(x->x.getCapacidad()).collect(Collectors.toList()));
			
			
		}
		public static Vertices1 finalVertex() {
			return of(List.of(0,mems.stream().map(x-> x.getCapacidad()*0).collect(Collectors.toList())));
		}
		

		@Override
		public Boolean isValid() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Set<Vertices1> getNeighborListOf() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Set<Aristas1> edgesOf() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Aristas1> edgesListOf() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Aristas1 getEdgeToVertex(Vertices1 v2) {
			// TODO Auto-generated method stub
			return null;
		}

	}
	
	public record Aristas1 (int indiceMemoria) implements SimpleEdgeAction<Vertices1,Integer>{

		@Override
		public Vertices1 source() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Vertices1 target() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Double Weight() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Integer action() {
			// TODO Auto-generated method stub
			return null;
		}

		
	}
	
	
	public interface SimpleEdgeAction<V,A> extends SimpleEdge<Vertices1>{
		A action();
			
	}
	
	public interface SimpleEdge<V>{
		V source();
		V target();
		Double Weight();
	}
	
	public record Acciones1(String id, IntPair direction)implements Action<Vertices1> {

		@Override
		public Vertices1 neighbor(Vertices1 v) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isApplicable(Vertices1 v) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Double weight(Vertices1 v) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String name() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}
