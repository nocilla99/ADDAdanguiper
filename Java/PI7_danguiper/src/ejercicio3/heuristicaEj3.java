package ejercicio3;

import java.util.function.Predicate;

import ejercicio3.datosEj3.TipoProducto;

public class heuristicaEj3 {
	public static Double heuristic(Ej3_Vertex actual,Predicate<Ej3_Vertex> goal,Ej3_Vertex fin){
		
		
		Double restante=0.;
		for(int i=actual.indice();i<datosEj3.getProductos();i++) {
			TipoProducto p=datosEj3.getProducto(i);
			restante+=(p.precio()*p.maxUnidades());
		}
		
		return restante;
		
		
		
	}
}
