package ej4Manual;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import datos.datosEj4;

public class Ej4_PD {

	public static record Spm(Integer a,Integer weight) implements Comparable<Spm> {
		
		public static Spm of(Integer a, Integer d) {
			return new Spm(a, d);
		}
		
		@Override
		public int compareTo(Spm sp) {
			return this.weight.compareTo(sp.weight);
		}
	}
	
	public static double maxValue = Integer.MIN_VALUE;
	public static Ej4Problem start;
	public static Map<Ej4Problem,Spm> memory;
	
	public static Solucion4Man pd(List<Integer> capRestantes) {
		Ej4_PD.maxValue = Integer.MIN_VALUE;
		Ej4_PD.start = Ej4Problem.of(0, capRestantes);
		Ej4_PD.memory = new HashMap<>();
		pd(start,0,memory);
		return Ej4_PD.solucion();
	}
	
	/*public static Solucion4Man pd(List<Integer> capRestantes, int maxValue, Solucion4Man s) {
		Ej4_PD.maxValue = maxValue;
		Ej4_PD.start = Ej4Problem.of(0,capRestantes);
		Ej4_PD.memory = new HashMap<>();
		pd(start,0,memory);
		if(Ej4_PD.memory.get(start) == null) return s;
		else return Ej4_PD.solucion();
	}*/
	
	public static Spm pd(Ej4Problem vertex,int d, Map<Ej4Problem,Spm> memory) {
		Spm r;
		if(memory.containsKey(vertex)) {
			r = memory.get(vertex);
		} else if(vertex.indice() == datosEj4.getNumElems()) {
			r = Spm.of(null,0);
			memory.put(vertex,r);
			if(d > Ej4_PD.maxValue) Ej4_PD.maxValue = d;
		} else {
			List<Spm> soluciones = new ArrayList<>();
			for(Integer a:vertex.actions()) {	
				Double cota = Heuristica.cota(vertex,a);
				if(cota < Ej4_PD.maxValue) continue;				
				Spm s = pd(vertex.vecino(a),vertex.peso(),memory);
				if(s!=null) {
					Spm sp = Spm.of(a,s.weight());
					soluciones.add(sp);
				}
			}
			r = soluciones.stream().max(Comparator.naturalOrder()).orElse(null);
			if(r!=null) memory.put(vertex,r);
		}
		return r;
	}
	
	public static Solucion4Man solucion(){
		List<Integer> acciones = new ArrayList<>();
		Ej4Problem v = Ej4_PD.start;
		Spm s = Ej4_PD.memory.get(v);
		while(s.a() != null) {
			acciones.add(s.a());
			v = v.vecino(s.a());	
			s = Ej4_PD.memory.get(v);
		}
		return Solucion4Man.of(Ej4_PD.start,acciones);
	}
	
	
	public static void main(String[] args) {
		datosEj4.iniDatos("./fichero/PI6Ej4DatosEntrada1.txt");
		Ej4_PD.pd(datosEj4.contenedores.stream().map(x->x.capacidad()).collect(Collectors.toList()));
		System.out.println(Ej4_PD.solucion());
	}

}
