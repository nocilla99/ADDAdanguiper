package ej4Manual;

import java.util.List;
import java.util.stream.IntStream;

import datos.datosEj3;
import datos.datosEj3.TipoProducto;
import us.lsi.common.List2;
import us.lsi.common.Preconditions;

public record Ej4Problem(int indice, int TProdRestante,int TManRestante)  {  //COMO VERTEX
	 
	public static Ej4Problem of(int indice, int TProdRestante,int TManRestante) {
		Preconditions.checkArgument(indice>=0 && indice<=datosEj3.getProductos(),
				"indice: "+indice+" Tprod: "+TProdRestante+" Tman:"+TManRestante);
		return new Ej4Problem(indice,TProdRestante, TManRestante);
	}
	public static Ej4Problem inicio() {return of(0, datosEj3.TiempoMaxProd,datosEj3.TiempoMaxManual);}
	
	public Ej4Problem vecino(Integer a) { //idem a vertex
		TipoProducto prod=datosEj3.getProducto(indice);
		int tp=datosEj3.getTiempoProduccion(prod);
		int tm=datosEj3.getTiempoManual(prod);
		
		return of(indice+1,TProdRestante-(tp*a),TManRestante-(tm*a));
	}
	
	public List<Integer> actions() { //idem a vertex 
		List<Integer> la= List2.empty();
		if(indice>=datosEj3.getProductos()) {
			return la;
		}
		la.addAll(IntStream.range(0,datosEj3.getProducto(indice).maxUnidades()+1)
				.filter(x->aplicable(x))
				.boxed().toList());
		 
		 return la;
	}
	
	
	private Boolean aplicable(int cantidad) {
		TipoProducto prod=datosEj3.getProducto(indice);
		int tp=datosEj3.getTiempoProduccion(prod);
		int tm=datosEj3.getTiempoManual(prod);
		
		
		Boolean res= (TProdRestante-(tp*cantidad)>=0 )  && (TManRestante-(tm*cantidad)>=0);
		return res;
	}
	
}
