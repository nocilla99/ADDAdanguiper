package test;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import ejercicios.Ejercicio2;
import us.lsi.common.Files2;

public class TestEjercicio2 {

	public static void main(String[] args) {

			
			String file = "PI4E2_DatosEntrada1";
			System.out.println("Ejercicio 2\n");
			testA(file);
			testB(file, "PI4E2_DatosEntrada2");
			
			List<String> ls = new ArrayList<>();
			ls.add("L3");
			ls.add("L9");
			ls.add("L7");
			
			testC(file, ls);

		}
		
		private static void testA(String file) {
			
			Graph<String, DefaultEdge> g = Ejercicio2.lee_grafo(file);
			
			System.out.println("- Apartado a)\n");
			
			Ejercicio2.apA(g);
			
		}
		
		private static void testB(String file, String listas) {
			
			Graph<String, DefaultEdge> g = Ejercicio2.lee_grafo(file);
			
			List<String> ls = Files2.linesFromFile("ficheros/" + listas + ".txt");
			
			System.out.println("- Apartado b:\n");
			
			for (int i=0;i<ls.size();i++) {
				
				Integer num = i+1;
				String s = ls.get(i).replace("Test" + num.toString() + ": ", "").replace("[", "").replace("]", "");
				String[] v = s.split(",");
				
				List<String> lsFinal = new ArrayList<>();
				
				for (String e: v) {
					lsFinal.add(e);
				}
				
				Boolean b = Ejercicio2.apB(g, lsFinal);
				
				if (b)
					System.out.println("Para el " + ls.get(i) + " hay solucion");
				else
					System.out.println("Para el " + ls.get(i) + " no hay solucion");	
			}
			
		}
		
		private static void testC(String file, List<String> ls) {
			
			Graph<String, DefaultEdge> g = Ejercicio2.lee_grafo(file);
			System.out.println("\n- Apartado c:\n");
			
			for (int i=0;i<ls.size();i++)
				System.out.println(ls.get(i) + "-> requeridos: " + Ejercicio2.apartadoC(g, ls.get(i)));
		}
		
		

	}


