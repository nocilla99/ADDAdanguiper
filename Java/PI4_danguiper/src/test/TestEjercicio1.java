package test;

import elementos_aux.Investigador;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ejercicios.Ejercicio1;
import ejercicios.Ejercicio1.TuplaII;
public class TestEjercicio1 {

	public static void main(String[] args) {
		
System.out.println("Ejercicio 1: \n\n");
		
		testAB("PI4E1_DatosEntrada");
		testC("PI4E1_DatosEntrada");
		testD("PI4E1_DatosEntrada");
		testE("PI4E1_DatosEntrada");
		
	}
	
	private static void testAB(String file) {
		
		Ejercicio1.lee_grafo(file);
		Ejercicio1.apA(file);
		System.out.println("Salida: " 
		+ Ejercicio1.apB(file)+"\n");
		
	}
	
	private static void testC(String file) {
		
		Ejercicio1.lee_grafo(file);
		Map<Investigador, List<Investigador>> mp = Ejercicio1.apC(file);
		System.out.println("Salida: :\n");
		
		for (Investigador i: mp.keySet()) {
			
			System.out.println(i + "-> " + mp.get(i));
			
		}
		
	}
	
	private static void testD(String file) {
		
		Ejercicio1.lee_grafo(file);
		TuplaII tupla = Ejercicio1.apD(file);
		Ejercicio1.apartadoD_grafo(file);
		String txt = "(" + tupla.i1() + ", " + tupla.i2() + ")";
		System.out.println("Salida: " + txt);
		
	}
	
	private static void testE(String file) {
		
		List<Set<Investigador>> ls = Ejercicio1.apE(file);
		
		for (Set<Investigador> set: ls) {
			
			System.out.println(set);
		}
		
	}
		
	

}
