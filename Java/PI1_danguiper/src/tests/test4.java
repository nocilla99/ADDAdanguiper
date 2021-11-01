package tests;

import java.util.List;

import ejercicios.Ejercicio4;
import us.lsi.common.Files2;

public class test4 {

	public static void main(String[] args) {
		
		String ruta= "./ficheros/TestAlumnos/PI1E4_DatosEntrada.txt";
		List<String> fichero=Files2.linesFromFile(ruta);
		
		for(String linea:fichero) {
			String[] x = linea.split(",");
			Double a=Double.valueOf(x[0]);
			Double b=Double.valueOf(x[1]);
			System.out.println("Entrada ("+a+","+b+")- Raíz exacta: "+Math.cbrt(a)+"\n Ite: "+Ejercicio4.ejercicio4it(a, b)
			+"\n Rec: "+Ejercicio4.ejercicio4RE(a, b)+"\n Fun: "+Ejercicio4.Ej4Fu(a, b)+"\n");
		}
	}

}

