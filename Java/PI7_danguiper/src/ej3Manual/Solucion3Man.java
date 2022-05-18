package ej3Manual;

import java.util.ArrayList;
import java.util.List;

import datos.datosEj3;
import datos.datosEj3.TipoProducto;

public record Solucion3Man(Double ingresos, List<Integer>cantidades) {	

			public static Solucion3Man of(Ej3Problem p, List<Integer> acciones) {
				
				Ej3Problem v= p;
				Double ingresos= 0.;
				List<Integer> CantidadProd= new ArrayList<>();
				
				for(int i=0; i< acciones.size();i++) {
					Integer a = acciones.get(i);
					TipoProducto producto= datosEj3.getProducto(i);
					
					ingresos+= producto.precio()*a;
					CantidadProd.add(a);
	
				
					v= v.vecino(a);
				}
				return new Solucion3Man(ingresos,CantidadProd);
			}

			public String toString() {;
				return "Funcion Objetivo:"+ingresos+"\nProductos:\n"+aux(cantidades)+"\n";
			}

			private String aux(List<Integer> cantidades2) {
				String r="";
				for(int i=0;i<cantidades2.size();i++) {
					String s= datosEj3.getProducto(i).id()+" -> Cantidad: "+cantidades2.get(i)+"\n";
					r+= s;
				}
				
				return r;
			}
			
}
