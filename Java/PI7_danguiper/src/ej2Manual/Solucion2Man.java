package ej2Manual;

import java.util.ArrayList;
import java.util.List;
import ejercicio2.datosEj2;
import ejercicio2.datosEj2.TipoCandidato;

public record Solucion2Man(List<String> seleccionados,double coste,int valoraciones) {	

			public static Solucion2Man of(Ej2Problem p, List<Integer> acciones) {
				
				Ej2Problem v= p;
				Integer valoraciones= 0;
				List<String> elegidos= new ArrayList<>();
				double coste=0.;
				
				
				for(int i=0; i< acciones.size();i++) {
					Integer a = acciones.get(i);
					TipoCandidato persona= datosEj2.getCandidato(i);
					if (a ==1) {
						valoraciones+=persona.valoracion();
						elegidos.add(persona.id());
						coste+=persona.precio();
					}
					v= v.vecino(a);
				}
				return new Solucion2Man(elegidos,coste,valoraciones);
			}

			public String toString() {;
				return "Funcion Objetivo: "+valoraciones+"\nCoste: "+coste+"\nCandidatos: "+seleccionados+"\n";
			}
			
}
