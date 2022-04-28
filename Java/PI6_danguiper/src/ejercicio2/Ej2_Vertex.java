package ejercicio2;

import java.util.List;
import java.util.function.Predicate;
import ejercicio2.datosEj2.TipoCandidato;
import us.lsi.common.List2;
import us.lsi.graphs.virtual.VirtualVertex;

public record Ej2_Vertex(int indice,List<String> cualisPendientes, List<Integer> alternativas) 
implements VirtualVertex<Ej2_Vertex,Ej2_Edge,Integer>{
	
	/*•Propiedades de los vértices (Prop. individuales)

	Básicas:

	•i: entero. Índice que recorre todas las variables del modelo.

	•as: lista de enteros. Lista de alternativas tomadas

	Derivadas:

	•cualidadesACubrir: conjunto de enteros. Índices de las cualidades que faltan por cubrir.

	•presupRestante: real. Presupuesto restante.*/


	
	public static Ej2_Vertex of(int indice,List<String> cualisPendientes, List<Integer> alternativas) {
		return new Ej2_Vertex(indice,cualisPendientes,alternativas);
	}
	
	public static Ej2_Vertex V_inicial() {
		
		return of(0,datosEj2.requeridas,List2.empty());
	}
	
	
	public static Predicate<Ej2_Vertex> goal(){
		return v->v.indice==datosEj2.getNumCandidatos();
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
				res=res && datosEj2.getCandidato(indice).incompatibilidad().contains(persona.id());
				
			}
		}
		if(res==false) return false;
		//contiene alguna cualidad requerida
		
		res= res && cualisPendientes.stream().anyMatch(x->datosEj2.getCandidato(indice).cualidades().contains(x));
		
		//no hace el presupuesto a 0
		if(res==false) return false;
		
		Double presupuesto=datosEj2.presupuesto;
		for(int elem=0;elem<alternativas.size();elem++) {
			presupuesto-= datosEj2.getCandidato(elem).precio()*alternativas.get(elem);
		}
		res=res&& (presupuesto>=0);
		return res;
	}

	@Override
	public Ej2_Vertex neighbor(Integer a) {
		List<Integer>copiAlter= List2.copy(alternativas);
		copiAlter.add(a);
		if(a==1) {
		List<String> copiaCualis= List2.copy(cualisPendientes);
		copiaCualis.removeAll(datosEj2.getCandidato(indice).cualidades());	
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
