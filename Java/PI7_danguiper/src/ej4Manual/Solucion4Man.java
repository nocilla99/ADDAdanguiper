package ej4Manual;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import datos.datosEj4;
import datos.datosEj4.*;

public class Solucion4Man {	

	private Map<Contenedor, List<Elemento>> map = new HashMap<>();
	private Integer tamaño = 0;
	
	public static Solucion4Man of(Ej4Problem v1, List<Integer> ls) {
		return new Solucion4Man(v1, ls);
	}
			
		private Solucion4Man(Ej4Problem v1, List<Integer> alternativas) {
			
			Ej4Problem v = v1;
			
			Contenedor contenedor = null;
			Elemento elemento = null;
			
			for (int i=0; i<alternativas.size(); i++) {
				
				Integer a = alternativas.get(i);
				if (a != datosEj4.contenedores.size()) {
					
					Integer idCont = alternativas.get(i);
					
					contenedor = datosEj4.contenedores.stream().filter(c -> Integer.valueOf(c.nombre().replace("CONT", "").trim()).equals(idCont + 1)).findFirst().get();
					elemento = datosEj4.elementos.get(i);
					
					if (map.containsKey(contenedor)) {
						map.get(contenedor).add(elemento);
						tamaño++;
					} else {
						List<Elemento> alternativasAux = new ArrayList<>();
						alternativasAux.add(elemento);
						map.put(contenedor, alternativasAux);
						tamaño++;
					}
				}
				v = v.vecino(a);
			}
		}
			
			


		public String toString() {

			List<String> alternativas = new ArrayList<>();
			
			for (Map.Entry<Contenedor, List<Elemento>> par: map.entrySet())
				alternativas.add(par.getKey().nombre() +" ("+par.getKey().capacidad()+ "): " + par.getValue().stream().map(x->x.nombre()).collect(Collectors.toList())+
			" -> "+par.getValue().stream().map(x->x.tamaño()).reduce(0, Integer::sum));
			
			String s = "###############################\n";
			
			for (int i=0; i<alternativas.size(); i++)
				s += alternativas.get(i) + "\n";
			
			s += "Contenedores llenos: " + map.keySet().size() + "\n";
			s += "###############################";
			
			return s;
		}
		
			
}
