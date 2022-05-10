package ej2Manual;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import ejercicio2.datosEj2;
import ejercicio2.datosEj2.TipoCandidato;
import us.lsi.common.List2;
import us.lsi.common.Preconditions;

public record Ej2Problem(int indice,List<String> cualisPendientes, List<Integer> alternativas) {  //COMO VERTEX
	static Ej2Problem of(int indice,List<String> cualisPendientes, List<Integer> alternativas) {
		Preconditions.checkArgument(indice>=0 && indice<=datosEj2.getNumCandidatos(),
				"indice: "+indice+" CualisPEndientes: "+cualisPendientes+" Lista alternativas"+alternativas);
		return new Ej2Problem(indice,cualisPendientes, alternativas);
	}
	static Ej2Problem inicio(List<String>cualis) {return new Ej2Problem(0, cualis, new ArrayList<Integer>());}
	
	public Ej2Problem vecino(Integer a) { //idem a vertex
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
	
	public List<Integer> actions() { //idem a vertex 
		List<Integer> la= List2.empty();
		if(indice>= datosEj2.getNumCandidatos()) {
			return la;
		}
			la.add(0);
			if(aplicable(indice)) la.add(1);
			return la;
	}
	
	
	private boolean aplicable(int escogido) { //idem a vertex 
			
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
		
		return res ;
	}
	
	
}
