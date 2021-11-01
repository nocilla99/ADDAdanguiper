package tests;

import java.util.ArrayList;
import java.util.List;

import ejercicios.Ejercicio2;
import us.lsi.common.Files2;

public class test2 {

	public static void main(String[] args) {
		
		System.out.println("\n"+"Ejercicio2: "+"\n");

		String ruta= "./ficheros/TestAlumnos/PI1E2_DatosEntrada2.txt";
		List<String> fichero=Files2.linesFromFile(ruta);

		List<List<String>> ls = new ArrayList<>();
		
		for(String linea:fichero) {
			String[] x = linea.split(",");
			met(x,ls);
		}
		System.out.println("Entrada= "+ls+"\n Rec: "+Ejercicio2.ejercicio2RE(ls)+"\n Ite: "+Ejercicio2.ej2It(ls)+"\n");

	}
	
	public static List<List<String>> met(String[] x,List<List<String>> lls){
		List<String> temp= new ArrayList<>();
		for(String pal:x) {
			temp.add(pal);
		}
		lls.add(temp);
		return lls;
	}

}
