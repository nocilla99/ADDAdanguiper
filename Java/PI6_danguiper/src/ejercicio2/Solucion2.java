package ejercicio2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.jgrapht.GraphPath;

import ejercicio2.datosEj2.TipoCandidato;

public class Solucion2 {
	
		public Solucion2() {
		}
		
		public int v_TOTAL;
		public List<TipoCandidato> cands;
	
		
		public static Solucion2 of(GraphPath<Ej2_Vertex,Ej2_Edge> gp) {
			Solucion2 spr3= new Solucion2();
			spr3.v_TOTAL=0;
			spr3.cands= new ArrayList<>();
			List<Ej2_Edge> ls= gp.getEdgeList();
			for(int i=0; i<ls.size();i++) {
				if(ls.get(i).action()==1) {
				spr3.v_TOTAL += datosEj2.getCandidato(i).valoracion();
				spr3.cands.add(datosEj2.getCandidato(i));
				}
				
			}
			return spr3;
			
		}

		public String toString() {
			System.out.println( "Valoracion total: "+v_TOTAL);
			System.out.println("Candidatos("+cands.size()+"):\n "+cands.stream().map(c->c.toString()+"\n").collect(Collectors.toList()));
			Double coste=cands.stream().map(c->c.precio()).reduce(0.,Double::sum);
			System.out.println("Coste: "+coste);
			Set<String> set= new HashSet<String>();
			for(int k=0;k<cands.size();k++) {
				List<String> lc= datosEj2.getCandidato(k).cualidades();
				set.addAll(lc);
			}
			System.out.println("Cubiertas: "+set);
			return "";
			}
}
	
