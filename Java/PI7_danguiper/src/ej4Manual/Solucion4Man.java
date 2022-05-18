package ej4Manual;

import java.util.ArrayList;
import java.util.List;

import datos.datosEj3;
import datos.datosEj3.TipoProducto;

public record Solucion4Man(Double ingresos, List<Integer>cantidades) {	

			public static Solucion4Man of(Ej4Problem p, List<Integer> acciones) {
				
				Ej4Problem v= p;
				Double ingresos= 0.;
				List<Integer> CantidadProd= new ArrayList<>();
				
				for(int i=0; i< acciones.size();i++) {
					Integer a = acciones.get(i);
					TipoProducto producto= datosEj3.getProducto(i);
					
					ingresos+= producto.precio()*a;
					CantidadProd.add(a);
	
				
					v= v.vecino(a);
				}
				return new Solucion4Man(ingresos,CantidadProd);
			}

			public String toString() {;
				return "Funcion Objetivo:"+ingresos+"\nProductos:\n";
			}

			
			
}
