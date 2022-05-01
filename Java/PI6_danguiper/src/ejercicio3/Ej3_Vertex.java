package ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import ejercicio3.datosEj3.TipoProducto;
import us.lsi.graphs.virtual.VirtualVertex;

public record Ej3_Vertex(int indice, int TProdRestante,int TManRestante) 
implements VirtualVertex<Ej3_Vertex,Ej3_Edge,Integer>{
	//Indice de producto 
	//Tiempo de produccion que queda por usar
	//Tiempo manual que queda por usar

	public static Ej3_Vertex of(int indice,int tp,int tm){
		return new Ej3_Vertex(indice,tp,tm);
	}
	
	public static Ej3_Vertex V_inicial() {
		return of(0,datosEj3.TiempoMaxProd,datosEj3.TiempoMaxManual);
	}
	
	public static Predicate<Ej3_Vertex> goal(){
		return v->v.indice>=datosEj3.getProductos();
	}
	
	
	
	@Override
	public List<Integer> actions() {
		List<Integer> la= new ArrayList<>();
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

	@Override
	public Ej3_Vertex neighbor(Integer a) {
		
		TipoProducto prod=datosEj3.getProducto(indice);
		int tp=datosEj3.getTiempoProduccion(prod);
		int tm=datosEj3.getTiempoManual(prod);
		
		//double g=gananciasAcumuladas+datosEj3.getProducto(indice).precio()*a;
		return of(indice+1,TProdRestante-(tp*a),TManRestante-(tm*a));
	}

	@Override
	public Ej3_Edge edge(Integer a) {
		return Ej3_Edge.of(this, this.neighbor(a), a);
	}
	


	
}
