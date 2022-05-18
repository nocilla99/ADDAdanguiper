package ej3Manual;

import java.util.List;
import java.util.stream.IntStream;

import datos.datosEj3;
import datos.datosEj3.TipoProducto;
import us.lsi.common.List2;
import us.lsi.common.Preconditions;

public record Ej3Problem(int indice, int TProdRestante,int TManRestante)  {  //COMO VERTEX
	 
	public static Ej3Problem of(int indice, int TProdRestante,int TManRestante) {
		Preconditions.checkArgument(indice>=0 && indice<=datosEj3.getProductos(),
				"indice: "+indice+" Tprod: "+TProdRestante+" Tman:"+TManRestante);
		return new Ej3Problem(indice,TProdRestante, TManRestante);
	}
	public static Ej3Problem inicio(int tp,int tm) {return of(0, tp,tm);}
	
	public Ej3Problem vecino(Integer a) { //idem a vertex
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
