package ejercicio2;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.GraphPath;

import ejercicio2.datosEj2.TipoCandidato;

public class solucion2 {
	
		public solucion2() {
		}
		
		public int v_TOTAL;
		public List<TipoCandidato> cands;
	
		
		public static solucion2 of(GraphPath<Ej2_Vertex,Ej2_Edge> gp) {
			solucion2 spr3= new solucion2();
			spr3.v_TOTAL=0;
			spr3.cands= new ArrayList<>();
			List<Ej2_Edge> ls= gp.getEdgeList();
			for(int i=0; i<ls.size();i++) {
				spr3.v_TOTAL += datosEj2.getCandidato(i).valoracion();
				spr3.cands.add(datosEj2.getCandidato(i));
				
			}
			return spr3;
			
		}

		public String toString() {
			String s= "\n Valoracion total :"+v_TOTAL;
			return s+"\n Candidatos: ("+cands.size()+")\n"+cands.stream().map(x->x.id()).toString();
			}
}
	
