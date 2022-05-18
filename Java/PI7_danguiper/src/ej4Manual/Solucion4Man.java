package ej4Manual;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import datos.datosEj4;

public record Solucion4Man(int contenLlenos, Map<Integer,List<String>> solucion) {	

			public static Solucion4Man of(Ej4Problem p, List<Integer> acciones) {
				
				Ej4Problem v= p;
				int contenedoresLLenos=0;
				Map<Integer,List<String>> solucion= new HashMap<>();
				
				for(int i=0; i< acciones.size();i++) {
					Integer a = acciones.get(i);
					//??
					contenedoresLLenos+=1;
					if(solucion.containsKey(a)) {
						solucion.get(a).add(datosEj4.getElemento(i).nombre());	
					}else {
						List<String> li= new ArrayList<String>();
						li.add(datosEj4.getElemento(i).nombre());
						solucion.put(a,li);
						
					}
				
					v= v.vecino(a);
				}
				return new Solucion4Man(contenedoresLLenos,solucion);
			}


			public String toString() {
			System.out.println(solucion);
			String r= solucion.entrySet().stream().filter(e->e.getKey()!=-1)
					.map(e->"Contenedor "+ (e.getKey()+1)+" ("+datosEj4.getContenedor(e.getKey()).capacidad()+"): "+e.getValue()+" Tamaño ocupado: "+sumatams(e.getValue()))
					.collect(Collectors.joining("\n"))+"";
			return r;
		}

		private int sumatams(List<String> listaEls) {
			
			return datosEj4.elementos.stream().filter(x->listaEls.contains(x.nombre()))
					.map(x->x.tamaño()).reduce(0, Integer::sum);
		}
			
			
}
