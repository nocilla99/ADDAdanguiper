package ej1Manual;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ejercicio1.datosEj1;

public record Solucion1Man(Integer valor,List<Integer> acciones,Map<Integer,List<String>> s) {	

			public static Solucion1Man of(Ej1Problem p, List<Integer> acciones) {
				
				Ej1Problem v= p;
				Integer valor= (int)acciones.stream().filter(a->a!=-1).count();
				
				Map<Integer,List<String>> res= new HashMap<>();
				
				for(int i=0; i< acciones.size();i++) {
					Integer a = acciones.get(i);
					if (a !=-1) {
						if(res.containsKey(a)) {
							res.get(a).add(datosEj1.getArchivo(i).getNombre());
						}else {
							List<String> l= new ArrayList<String>();
							l.add(datosEj1.getArchivo(i).getNombre());
							res.put(a, l);
						}
					}
					v= v.vecino(a);
				}
				return new Solucion1Man(valor,acciones,res);
	}
}
