package ejercicio3;

import java.util.function.Predicate;

public class heuristicaEj3 {
	public static Double heuristic(Ej3_Vertex actual,Predicate<Ej3_Vertex> goal,Ej3_Vertex fin){
		Integer res= actual.alternativasCogidas().stream().reduce(0, Integer::sum);
		Integer total= datosEj3.getMaxProductos();
		
		return (double) (total-res);
		
	}
}
