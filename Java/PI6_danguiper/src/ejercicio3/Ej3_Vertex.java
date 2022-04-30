package ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import ejercicio3.datosEj3.DuplaComponente;
import ejercicio3.datosEj3.TipoProducto;
import us.lsi.common.List2;
import us.lsi.graphs.virtual.VirtualVertex;

public record Ej3_Vertex(int indice, List<Integer> alternativasCogidas) 
implements VirtualVertex<Ej3_Vertex,Ej3_Edge,Integer>{
	//Indice de producto 
	//lista de alternativas cogidas tamaño P

	public static Ej3_Vertex of(int indice, List<Integer> alternativas){
		return new Ej3_Vertex(indice, alternativas);
	}
	
	public static Ej3_Vertex V_inicial() {
		return of(0,List2.empty());
	}
	
	public static Predicate<Ej3_Vertex> goal(){
		return v->v.indice==datosEj3.getMaxProductos();
	}
	
	
	
	@Override
	public List<Integer> actions() {
		List<Integer> la= new ArrayList<>();
		if(indice==datosEj3.getMaxProductos()) {
			return la;
		}
		la.add(-1);
		la.addAll(IntStream.range(0, datosEj3.getProducots())
				.filter(x->aplicable(x))
				.boxed().toList());
		 
		 return la;
	}

	private Boolean aplicable(int indiP) {
		TipoProducto prod=datosEj3.getProducto(indiP);
		
		Boolean res=alternativasCogidas.get(indiP)<prod.maxUnidades();
		int tp=0,tm=0;
		for(int i=0;i<prod.componentes().size();i++) {//i=0
			String nombreComponente= prod.componentes().get(i).nombreComp();
			
			DuplaComponente tiemposComponente= datosEj3.getTiempos(nombreComponente);
			Integer cantidadComponente= prod.componentes().get(i).cantidad();
			Integer numeroProds=alternativasCogidas.get(i);
			
			tp=tp+(tiemposComponente.prod()*cantidadComponente)*numeroProds;
			tm=tm+(tiemposComponente.manual()*cantidadComponente)*numeroProds;
		}
		res=res&& ( datosEj3.TiempoMaxProd>=tp )  && (datosEj3.TiempoMaxManual>=tm);
		return res;
	}

	@Override
	public Ej3_Vertex neighbor(Integer a) {
		alternativasCogidas.set(a, alternativasCogidas.get(a)+1);
		return of(indice+1,alternativasCogidas);
	}

	@Override
	public Ej3_Edge edge(Integer a) {
		return Ej3_Edge.of(this, this.neighbor(a), a);
	}
	


	
}
