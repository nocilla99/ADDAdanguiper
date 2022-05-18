package ej4Manual;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import datos.datosEj4;

public class Ej4_PD {

		public static record Sp(Integer a, Integer weight) implements Comparable<Sp>{
			
			public static Sp of(Integer a, Integer weight) {
				return new Sp(a, weight);
			}

			public int compareTo(Sp sp) {
				return this.weight.compareTo(sp.weight);
			}
			
		}
		
		public static Integer maxValue = Integer.MIN_VALUE;
		public static Ej4Problem start;
		public static Map<Ej4Problem,Sp> memory;
		
		public static Solucion4Man pd(List<Integer> capacidadInicial) {
			Ej4_PD.maxValue = Integer.MIN_VALUE;
			Ej4_PD.start = Ej4Problem.of(0, capacidadInicial);
			Ej4_PD.memory = new HashMap<>();
			pd(start, 0, memory);
			return Ej4_PD.solucion();
		}
		

		public static Sp pd(Ej4Problem vertex, Integer accumulateValue, Map<Ej4Problem, Sp> memory) {
			
			Sp res;
			Integer n = datosEj4.elementos.size();
			
			if (memory.containsKey(vertex)) {
				res = memory.get(vertex);
			} else if (vertex.indice() == n) {
				res = null;
				if (Ej4Problem.constraint().test(vertex)) {
					res = Sp.of(null, 0);
					memory.put(vertex, res);
					if (accumulateValue > Ej4_PD.maxValue) Ej4_PD.maxValue = accumulateValue;
				}
				memory.put(vertex, res);
			} else {
				List<Sp> soluciones = new ArrayList<>();
				for (Integer a: vertex.actions()) {
					Double cota = Heuristica.cota(vertex, a);
					if (cota < Ej4_PD.maxValue) continue;
					Sp s = pd(vertex.vecino(a), vertex.peso(), memory);
					if (s != null) {
						Sp sp = Sp.of(a, s.weight());
						soluciones.add(sp);
					}
				}
				res = soluciones.stream().max(Comparator.naturalOrder()).orElse(null);
				if (res != null) memory.put(vertex, res);
			}
			return res;
		}
		
		public static Solucion4Man solucion() {
			List<Integer> alternativas = new ArrayList<>();
			Ej4Problem v = Ej4_PD.start;
			Sp s = Ej4_PD.memory.get(v);
			while(s.a() != null) {
				alternativas.add(s.a());
				v = v.vecino(s.a());	
				s = Ej4_PD.memory.get(v);
			}
			return Solucion4Man.of(Ej4_PD.start, alternativas);
		}
		
		public static void main(String[] args) {
			Locale.setDefault(new Locale("en", "US"));
			
			
				String fichero = "./fichero/PI6Ej4DatosEntrada1.txt";
				datosEj4.iniDatos(fichero);
				Ej4_PD.pd(datosEj4.contenedores.stream().map(x->x.capacidad()).collect(Collectors.toList()));
				System.out.println(Ej4_PD.solucion());
			
		}
	}

