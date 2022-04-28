package ejercicio2;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import ejercicio2.datosEj2.TipoCandidato;
import us.lsi.common.List2;
import us.lsi.graphs.virtual.VirtualVertex;

public record Ej2_Vertex(int indice,List<String> cualisPendientes, List<TipoCandidato> elegidos) 
implements VirtualVertex<Ej2_Vertex,Ej2_Edge,Integer>{

	
	public static Ej2_Vertex of(int indice,List<String> cualisPendientes,List<TipoCandidato> elegidos) {
		return new Ej2_Vertex(indice,cualisPendientes,elegidos);
	}
	
	public static Ej2_Vertex V_inicial() {
		
		return of(0,datosEj2.requeridas,List2.empty());
	}
	
	
	
	public static Predicate<Ej2_Vertex> goal(){
		return v->v.indice==datosEj2.getNumCandidatios();
	}
	
	@Override
	public List<Integer> actions() {
		List<Integer> la= List2.empty();
		if(indice>= datosEj2.getNumCandidatios()) {
			return la;
		}
			return IntStream.range(0, datosEj2.getRequeridas().size()-1).  //cualisPendientes.size()-1?
					filter(g-> aplicable(g)).boxed().toList();
	}

	private boolean aplicable(int IndCualidadPendiente) {//mirar
		boolean res=true;
		
		//no es incompt
		
		for (TipoCandidato persona : elegidos) {
			res= res && datosEj2.getCandidato(indice).incompatibilidad().contains(persona.id());
		}
		//contiene alguna cualidad requerida
		
		res= res && datosEj2.getCandidato(indice).cualidades().contains(cualisPendientes.get(IndCualidadPendiente));
		
		//no hace el presupuesto a 0
		Double presupuestoRestante=datosEj2.presupuesto;
		presupuestoRestante -= elegidos.stream().map(can->can.precio()).reduce(0.,Double::sum);
		res = res && -datosEj2.getCandidato(indice).precio()>=0;
		
		return res;
	}

	@Override
	public Ej2_Vertex neighbor(Integer a) {
		List<String> copiaCualis= List2.copy(cualisPendientes);
		copiaCualis.remove(copiaCualis.get(a));
		List<TipoCandidato>copiCandidatos= List2.copy(elegidos);
		copiCandidatos.add(datosEj2.getCandidato(indice+1));
		return of(indice+1,	copiaCualis,copiCandidatos);
	}

	@Override
	public Ej2_Edge edge(Integer a) {
		return Ej2_Edge.of(this,this.neighbor(a),a);
	}

	public int indice() {
		return indice; 
	}
/*�Propiedades de los v�rtices (Prop. individuales)

B�sicas:

�i: entero. �ndice que recorre todas las variables del modelo.

�as: lista de enteros. Lista de alternativas tomadas

Derivadas:

�cualidadesACubrir: conjunto de enteros. �ndices de las cualidades que faltan por cubrir.

�presupRestante: real. Presupuesto restante.*/

	
}
