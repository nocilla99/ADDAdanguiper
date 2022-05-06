package ejercicio3;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.GraphPath;

import ejercicio3.datosEj3.TipoProducto;


public class Solucion3 {
	
		public Solucion3() {
		}
		
		public double ingresos;
		public List<Integer> CantidadProd;
	
		
		public static Solucion3 of(GraphPath<Ej3_Vertex,Ej3_Edge> gp) {
			Solucion3 spr3= new Solucion3();
			spr3.ingresos=0;
			spr3.CantidadProd= new ArrayList<>();
			List<Ej3_Edge> ls= gp.getEdgeList();
			for(int i=0; i<ls.size();i++) {
				Ej3_Edge e=ls.get(i);
				Integer cantidad=e.action();
				spr3.ingresos+=datosEj3.getProducto(i).precio()*cantidad;
				spr3.CantidadProd.add(cantidad);
			}
			return spr3;
			
		}


		public String toString() {
			String res= "Ingresos : "+ingresos+"\n";
			for(int i=0;i<datosEj3.getProductos();i++) {
				TipoProducto p = datosEj3.getProducto(i);
				res+= p.id()+" ("+p.precio()+"€): "+CantidadProd.get(i)+"\n";
			}
			
			return res;
		}
}
	
