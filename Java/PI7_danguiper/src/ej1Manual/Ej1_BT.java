package ej1Manual;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import ejercicio1.datosEj1;

public class Ej1_BT {

	public static class StateEj1{
		private Ej1Problem vertice;
		private Integer valorAcum;
		private List<Integer> acciones;
		private List<Ej1Problem> vertices;
		
		public StateEj1(Ej1Problem vertice, Integer valorAcum, List<Integer> acciones, List<Ej1Problem> vertices) {
			super();
			this.vertice = vertice;
			this.valorAcum = valorAcum;
			this.acciones = acciones;
			this.vertices = vertices;
		}
		
		public static StateEj1 of(Ej1Problem vertice) {
			List<Ej1Problem> vt = new ArrayList<Ej1Problem>();
			vt.add(vertice);
			return new StateEj1(vertice, 0, new ArrayList<>(), vt);
		}
		
		void forward(Integer a) {
			this.acciones.add(a);
			Ej1Problem vcn = this.vertice.vecino(a);		
			this.vertices.add(vcn);
			int p= (a!=-1)?1:0;
			this.valorAcum = this.valorAcum + p ;
			this.vertice = vcn;
		}

		void back(Integer a) {
			this.acciones.remove(this.acciones.size()-1);
			this.vertices.remove(this.vertices.size()-1);
			this.vertice = this.vertices.get(this.vertices.size()-1);
			int p= (a!=-1)?1:0;
			this.valorAcum = this.valorAcum - p ;			
		}
		
		Solucion1Man solucion() {
			return Solucion1Man.of(Ej1_BT.start,this.acciones);
		}
	}
	
	public static Ej1Problem start;
	public static StateEj1 estado;
	public static Integer maxValue;
	public static Set<Solucion1Man> soluciones;
	
	public static void btm(List<Integer> capIniciales) {
		Ej1_BT.start=Ej1Problem.of(0,capIniciales);
		Ej1_BT.estado=StateEj1.of(start);
		Ej1_BT.maxValue=Integer.MIN_VALUE;
		Ej1_BT.soluciones=new HashSet<>();
		btm();
	}
	
	
	public static void btm(List<Integer> capIniciales, Integer maxValue, Solucion1Man s) {
		Ej1_BT.start = Ej1Problem.of(0,capIniciales);
		Ej1_BT.estado = StateEj1.of(start);
		Ej1_BT.maxValue = maxValue;
		Ej1_BT.soluciones = new HashSet<>();
		Ej1_BT.soluciones.add(s);
		btm();
	}
	
	private static void btm() {
		if(Ej1_BT.estado.vertice.indice()==datosEj1.getNumArchivos()) {
			Integer value= estado.valorAcum;
			if(value> Ej1_BT.maxValue) {
				Ej1_BT.maxValue=value;
				Ej1_BT.soluciones.add(Ej1_BT.estado.solucion());
			}
		}else {
			List<Integer> alternativas = Ej1_BT.estado.vertice.actions();
			for(Integer a:alternativas) {	
				int cota = Ej1_BT.estado.valorAcum+Heuristica.cota(Ej1_BT.estado.vertice,a);
				if(cota < Ej1_BT.maxValue) continue;
				Ej1_BT.estado.forward(a);
				btm();  
				Ej1_BT.estado.back(a);
			}
		}
	}
	
	public static void main(String[] args) {
		datosEj1.iniDatos("./fichero/PI6Ej1DatosEntrada1.txt");
		List<Integer> caps= datosEj1.memorias.stream().map(x->x.capacidad()).collect(Collectors.toList());
		Ej1_BT.btm(caps);
		//System.out.println(Ej1_BT.soluciones);
		Solucion1Man sol1=Ej1_BT.soluciones.stream().sorted(Comparator.comparing(Solucion1Man::valor).reversed()).collect(Collectors.toList()).get(0);
		System.out.println(sol1.toString());
	}

}
