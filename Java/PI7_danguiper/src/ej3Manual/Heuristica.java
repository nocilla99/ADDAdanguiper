package ej3Manual;

import datos.datosEj3;
import datos.datosEj3.TipoProducto;

public class Heuristica {

private static record Heu_Ej3(int indice, int TProdRestante,int TManRestante)  {	//COMO VERTEX
		
		public static Heu_Ej3 of(int indice, int TProdRestante,int TManRestante)  { //constructor mitico
			return new Heu_Ej3(indice, TProdRestante,TManRestante);
		}		
	}

	public static double cota(Ej3Problem vertice, Integer a) { //peso arista+ heuristica vecino
		Ej3Problem v2= vertice.vecino(a);
		return a*(datosEj3.getProducto(vertice.indice()).precio())+heuristica(v2);
	}

	private static double heuristica(Ej3Problem v1) { //mejor camino desde v1.indice hasta final  (funcion objetivo)
		Heu_Ej3 v= Heu_Ej3.of(v1.indice(),v1.TProdRestante(),v1.TManRestante());
		
		Double restante=0.;
		for(int i=v.indice();i<datosEj3.getProductos();i++) {
			TipoProducto p=datosEj3.getProducto(i);
			restante+=(p.precio()*p.maxUnidades());
		}
		
		return restante;
		
	}

}
