package ejercicio2;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ejercicio2.datosEj2.TipoCandidato;
import us.lsi.common.List2;
import us.lsi.graphs.virtual.VirtualVertex;

public record Ej2_Vertex(int indice,List<String> cualisPendientes, List<Integer> alternativas) 
implements VirtualVertex<Ej2_Vertex,Ej2_Edge,Integer>{
	
	/*�Propiedades de los v�rtices (Prop. individuales)

	B�sicas:

	�i: entero. �ndice que recorre todas las variables del modelo.

	�as: lista de enteros. Lista de alternativas tomadas

	Derivadas:

	�cualidadesACubrir: conjunto de enteros. �ndices de las cualidades que faltan por cubrir.

	�presupRestante: real. Presupuesto restante.*/


	
	public static Ej2_Vertex of(int indice,List<String> cualisPendientes, List<Integer> alternativas) {
		return new Ej2_Vertex(indice,cualisPendientes,alternativas);
	}
	
	public static Ej2_Vertex V_inicial() {
		
		return of(0,datosEj2.requeridas,List2.empty());
	}
	
	
	public static Predicate<Ej2_Vertex> goal(){
		return v->v.indice==datosEj2.getNumCandidatos() && presupuestoOK(v.alternativas) && vaciaLista(v.cualisPendientes,v.indice);
	}
	
	private static boolean vaciaLista(List<String> listCua,Integer index) {
		List<String> cuaIndiv= datosEj2.getCandidato(index-1).cualidades();
		List<String> res =listCua.stream().filter(x->!cuaIndiv.contains(x)).collect(Collectors.toList());
		return res.size()==0;
		
	}

	private static boolean presupuestoOK(List<Integer> alternativas2) {
		Double presupuesto= datosEj2.presupuesto;
		
		for(int elem=0;elem<alternativas2.size();elem++) {
			presupuesto-= datosEj2.getCandidato(elem).precio()*alternativas2.get(elem);
		}
		
		return presupuesto>=0;
	}
	
	

	@Override
	public List<Integer> actions() {
		List<Integer> la= List2.empty();
		if(indice>= datosEj2.getNumCandidatos()) {
			return la;
		}
			la.add(0);
			if(aplicable(indice)) la.add(1);
			return la;
	}

	private boolean aplicable(int escogido) {
		
		boolean res=true;
		if(indice==0) {
			return res;	
		}
		//no es incompt
		
		for (int i=0; i<alternativas.size();i++) {
			if(alternativas.get(i)==1){
				TipoCandidato persona= datosEj2.getCandidato(i);
				res=res && !datosEj2.getCandidato(indice).incompatibilidad().contains(persona.id());
				
			}
		}
		
		//-------------------------------------------
		
		
	
		return res;
	}

	@Override
	public Ej2_Vertex neighbor(Integer a) {
		List<Integer>copiAlter= List2.copy(alternativas);
		copiAlter.add(a);
		if(a==1) {
			List<String> copiaCualis= cualisPendientes.stream()
					.filter(x->!datosEj2.getCandidato(indice).cualidades().contains(x))
					.collect(Collectors.toList());
			return of(indice+1,	copiaCualis,copiAlter);
		}
		return of(indice+1,cualisPendientes(),copiAlter);
	}

	@Override
	public Ej2_Edge edge(Integer a) {
		return Ej2_Edge.of(this,this.neighbor(a),a);
	}

	public int indice() {
		return indice; 
	}

	
}
