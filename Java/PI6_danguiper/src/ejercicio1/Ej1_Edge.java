package ejercicio1;

import us.lsi.graphs.virtual.SimpleEdgeAction;

public record Ej1_Edge(Ej1_Vertex source, Ej1_Vertex target, Integer action,Double weight) implements SimpleEdgeAction<Ej1_Vertex,Integer>{

		public static Ej1_Edge of(Ej1_Vertex source, Ej1_Vertex target, Integer action) {
		
			
			//Sumarle 1 a almacenados
			
			return new Ej1_Edge(source,target,action,(double)target.indice());
			
			//idea general:  
			/* Añadir propiedad a Memoria :List<Archivos> y maximizar la suma de los archivos almacenados en ellas?
			 * 
			 * Objetivo: saltarse los archivos que no quepan porque quizas despues hay archivos que quepan?
			 * 
			 */
		}


}
