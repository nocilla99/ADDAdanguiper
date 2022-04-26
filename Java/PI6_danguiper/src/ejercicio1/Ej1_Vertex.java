package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.jgrapht.GraphPath;

import us.lsi.common.List2;
import us.lsi.common.Preconditions;
import us.lsi.graphs.virtual.VirtualVertex;

public record Ej1_Vertex(Integer index, List<Integer> memsCap) 
	implements VirtualVertex<Ej1_Vertex,Ej1_Edge,Integer>{

		}
	

}
