package ej4Manual;

import datos.datosEj3;
import datos.datosEj3.TipoProducto;

public class Heuristica {

private static record Heu_Ej4(int indice, int TProdRestante,int TManRestante)  {	//COMO VERTEX
		
		public static Heu_Ej4 of(int indice, int TProdRestante,int TManRestante)  { //constructor mitico
			return new Heu_Ej4(indice, TProdRestante,TManRestante);
		}		
	}

	public static double cota(Ej4Problem vertice, Integer a) { //peso arista+ heuristica vecino
		Ej4Problem v2= vertice.vecino(a);
		return a*(datosEj3.getProducto(vertice.indice()).precio())+heuristica(v2);
	}

	private static double heuristica(Ej4Problem v1) { //mejor camino desde v1.indice hasta final  (funcion objetivo)
		Heu_Ej4 v= Heu_Ej4.of(v1.indice(),v1.TProdRestante(),v1.TManRestante());
		
		Double restante=0.;
		for(int i=v.indice();i<datosEj3.getProductos();i++) {
			TipoProducto p=datosEj3.getProducto(i);
			restante+=(p.precio()*p.maxUnidades());
		}
		
		return restante;
		
	}

}
