package test;

import java.util.ArrayList; 
import java.util.List;
import java.util.stream.Collectors;

import elementos_aux.Calle;
import ejercicios.Ejercicio3;

public class TestEjercicio3 {

public static void main(String[] args) {
		
		System.out.println("Ejercicio 3\n");
		test("PI4E3_DatosEntrada");

	}
	
	private static void test(String file) {
		
		Ejercicio3.lee_grafo(file);
		
		// Apartado a)
		
		List<String> ls = new ArrayList<>();
		ls.add("m7");
		ls.add("m2");
		ls.add("m4");
		ls.add("m9");
		
		System.out.println("- Apartado a:\n");
		
		System.out.println("Test1: camino de " + ls.get(0) + " a " + ls.get(1));
		
		Ejercicio3.apA(file, ls.get(0), ls.get(1), "ficheros/Ejercicio3a_test1.gv");
		
		System.out.println("Test2: camino de " + ls.get(2) + " a " + ls.get(3));
		Ejercicio3.apA(file, ls.get(2), ls.get(3), "ficheros/Ejercicio3a_test2.gv");
		
		// Apartado b)
		
		Ejercicio3.apB(file);
		
		// Apartado c)
		
		List<Calle> lista = new ArrayList<>();
		lista.add(Calle.of("c0"));
		lista.add(Calle.of("c3"));
		lista.add(Calle.of("c5"));
		lista.add(Calle.of("c6"));
		
		System.out.println("\n- Apartado c:\n");
		
		System.out.println("Test1: Quitando las calles " + lista);
		
		String nombreTest1 = "ficheros/Ejercicio3c_Test1.gv";
		Ejercicio3.apC(file, lista.stream().collect(Collectors.toSet()), nombreTest1);
		
		List<Calle> lista2 = new ArrayList<>();
		lista2.add(Calle.of("c0"));
		lista2.add(Calle.of("c3"));
		lista2.add(Calle.of("c5"));
		lista2.add(Calle.of("c6"));
		lista2.add(Calle.of("c9"));
		
		System.out.println("Test2: Quitando las calles " + lista2);

		String nombreTest2 = "ficheros/Ejercicio3c_Test2.gv";
		Ejercicio3.apC(file, lista2.stream().collect(Collectors.toSet()), nombreTest2);
		
	}

}
