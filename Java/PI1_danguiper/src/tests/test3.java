package tests;

import java.util.List;

import ejercicios.Ejercicio3;
import us.lsi.common.Files2;

public class test3 {

	public static void main(String[] args) {
		
		String ruta= "./ficheros/TestAlumnos/PI1E3_DatosEntrada.txt";
		List<String> fichero=Files2.linesFromFile(ruta);
		
		for(String linea:fichero) {
			String[] x = linea.split(",");
			Integer a=Integer.valueOf(x[0]);
			Integer b=Integer.valueOf(x[1]);
			System.out.println("Entrada ("+a+","+b+")\n Rec: "+Ejercicio3.ej3Re(a,b)+"\n\n Ite: "+Ejercicio3.ejercicio3it(a, b)+"\n");
		}

	}

}
