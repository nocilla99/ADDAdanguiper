package ej4Manual;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import datos.datosEj3;

public class Ej4_PD {

	public static record Spm(Integer a,Double weight) implements Comparable<Spm> {
		
		public static Spm of(Integer a, Double d) {
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
	
	public static Solucion4Man pd(int tp, int tm) {
		Ej4_PD.maxValue = Integer.MIN_VALUE;
		Ej4_PD.start = Ej4Problem.of(0,tp,tm);
		Ej4_PD.memory = new HashMap<>();
		pd(start,0,memory);
		return Ej4_PD.solucion();
	}
	
	public static Solucion4Man pd(int tp,int tm, double maxValue, Solucion4Man s) {
		Ej4_PD.maxValue = maxValue;
		Ej4_PD.start = Ej4Problem.of(0,tp,tm);
		Ej4_PD.memory = new HashMap<>();
		pd(start,0,memory);
		if(Ej4_PD.memory.get(start) == null) return s;
		else return Ej4_PD.solucion();
	}
	
	public static Spm pd(Ej4Problem vertex,double d, Map<Ej4Problem,Spm> memory) {
		Spm r;
		if(memory.containsKey(vertex)) {
			r = memory.get(vertex);
		} else if(vertex.indice() == datosEj3.getProductos()) {
			r = Spm.of(null,0.);
			memory.put(vertex,r);
			if(d > Ej4_PD.maxValue) Ej4_PD.maxValue = d;
		} else {
			List<Spm> soluciones = new ArrayList<>();
			for(Integer a:vertex.actions()) {	
				Double cota = d + Heuristica.cota(vertex,a);
				if(cota < Ej4_PD.maxValue) continue;				
				Spm s = pd(vertex.vecino(a),d+a*datosEj3.getProducto(vertex.indice()).precio(),memory);
				if(s!=null) {
					Spm sp = Spm.of(a,s.weight()+a*a*datosEj3.getProducto(vertex.indice()).precio());
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
		datosEj3.iniDatos("./fichero/PI6Ej3DatosEntrada1.txt");
		Ej4_PD.pd(datosEj3.TiempoMaxProd,datosEj3.TiempoMaxManual);
		System.out.println(Ej4_PD.solucion().toString());
		System.out.println();
	}

}
