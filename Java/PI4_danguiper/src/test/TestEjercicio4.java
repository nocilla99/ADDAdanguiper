package test;

import java.util.List;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import ejercicios.Ejercicio4;
import elementos_aux.Alumno;

public class TestEjercicio4 {
		
		public static void main(String[] args) {
			
			 List<String> datos= Ejercicio4.lecturaFichero("1");
			 SimpleWeightedGraph<Alumno, DefaultWeightedEdge> gf=Ejercicio4.construirGrafo(datos);
			 Ejercicio4.salida(gf,1);
			 List<String> datos2= Ejercicio4.lecturaFichero("2");
			 SimpleWeightedGraph<Alumno, DefaultWeightedEdge> gf2=Ejercicio4.construirGrafo(datos2);
			 Ejercicio4.salida(gf2,2);
			 
			 System.out.println("APARTADO A: \n	Salida en ./ficheros/Ejercicio4A_entrada1.gv");
			 System.out.println("	Salida en ./ficheros/Ejercicio4A_entrada2.gv");
			 
			 
			 
		}
	}