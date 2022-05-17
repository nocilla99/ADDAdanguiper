package ej2Manual;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import ejercicio2.datosEj2;

public class Ej2_BT {

	public static class StateEj2{ 
		private Ej2Problem vertice;
		private Integer valorAcum;
		private List<Integer> acciones;
		private List<Ej2Problem> vertices;
		
		public StateEj2(Ej2Problem vertice, Integer valorAcum, List<Integer> acciones, List<Ej2Problem> vertices) {
			super();
			this.vertice = vertice;
			this.valorAcum = valorAcum;
			this.acciones = acciones;
			this.vertices = vertices;
		}
		
		public static StateEj2 of(Ej2Problem vertice) {
			List<Ej2Problem> vt = new ArrayList<Ej2Problem>();
			vt.add(vertice);
			return new StateEj2(vertice, 0, new ArrayList<>(), vt);
		}
		
		void forward(Integer a) {
			this.acciones.add(a);
			Ej2Problem vcn = this.vertice.vecino(a);		
			this.vertices.add(vcn);
			int p= a*datosEj2.getCandidato(vertice.indice()).valoracion();
			this.valorAcum = this.valorAcum + p ;
			this.vertice = vcn;
		}

		void back(Integer a) {
			this.acciones.remove(this.acciones.size()-1);
			this.vertices.remove(this.vertices.size()-1);
			this.vertice = this.vertices.get(this.vertices.size()-1);
			int p= a*datosEj2.getCandidato(vertice.indice()).valoracion();
			this.valorAcum = this.valorAcum - p ;			
		}
		
		Solucion2Man solucion() {
			return Solucion2Man.of(Ej2_BT.start,this.acciones);
		}
	}
	
	public static Ej2Problem start;
	public static StateEj2 estado;
	public static Integer maxValue;
	public static Set<Solucion2Man> soluciones;
	
	public static void btm(List<String> cualidades) {
		Ej2_BT.start=Ej2Problem.inicio(cualidades);
		Ej2_BT.estado=StateEj2.of(start);
		Ej2_BT.maxValue=Integer.MIN_VALUE;
		Ej2_BT.soluciones=new HashSet<>();
		btm();
	}
	
	
	public static void btm(List<String> cualidades, Integer maxValue, Solucion2Man s) {
		Ej2_BT.start=Ej2Problem.inicio(cualidades);
		Ej2_BT.estado = StateEj2.of(start);
		Ej2_BT.maxValue = maxValue;
		Ej2_BT.soluciones = new HashSet<>();
		Ej2_BT.soluciones.add(s);
		btm();
	}
	
	private static void btm() {
		if(Ej2_BT.estado.vertice.indice()==datosEj2.getNumCandidatos()) {
			Integer value= estado.valorAcum;
			if(value> Ej2_BT.maxValue) {
				Ej2_BT.maxValue=value;
				Ej2Problem n = Ej2_BT.estado.vertice;
				if(vaciaLista(n.cualisPendientes(),n.indice()))Ej2_BT.soluciones.add(Ej2_BT.estado.solucion());
			}
			
		}else {
			List<Integer> alternativas = Ej2_BT.estado.vertice.actions();
			for(Integer a:alternativas) {	
				int cota = Ej2_BT.estado.valorAcum+Heuristica.cota(Ej2_BT.estado.vertice,a);
				if(cota < Ej2_BT.maxValue) continue;
				Ej2_BT.estado.forward(a);
				btm();  
				Ej2_BT.estado.back(a);
			}
		}
	}
	
	public static boolean PresuOk(List<Integer> alternativas) {
		double presupuesto=datosEj2.presupuesto;
		for (int i=0; i<alternativas.size();i++) {
			presupuesto-= datosEj2.getCandidato(i).precio()*alternativas.get(i);
		}
		return (presupuesto>=0.);
	}
	
	private static boolean vaciaLista(List<String> listCua,Integer index) {
		List<String> cuaIndiv= datosEj2.getCandidato(index-1).cualidades();
		List<String> res =listCua.stream().filter(x->!cuaIndiv.contains(x)).collect(Collectors.toList());
		return res.size()==0;
		
	}	
	public static void main(String[] args) {
		datosEj2.iniDatos("./fichero/PI6Ej2DatosEntrada2.txt");
		List<String> caps= datosEj2.requeridas;
		Ej2_BT.btm(caps);
		List<Solucion2Man> sol1=Ej2_BT.soluciones.stream().sorted(Comparator.comparing(Solucion2Man::valoraciones).reversed()).collect(Collectors.toList());
		if(sol1.size()==0) {System.out.println("No hay solucion");}else {
		System.out.println("#################\n"+sol1.get(0).toString()+"#################");}
		//System.out.println(Ej2_BT.soluciones.stream().sorted(Comparator.comparing(Solucion2Man::valoraciones).reversed()).collect(Collectors.toList()));
	}

}
