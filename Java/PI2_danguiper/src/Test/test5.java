package Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Ejercicios.Ejercicio5;
import Ejercicios.Ejercicio5.Tupla;
import us.lsi.common.Files2;

public class test5 {

	public static void main(String[] args) {
		String ruta= "./fichero/PI2Ej5DatosEntrada.txt";
		List<String> fichero=Files2.linesFromFile(ruta);
		Map<Tupla,Integer> m= new HashMap<Ejercicio5.Tupla, Integer>();
		for(String linea:fichero) {
			String[] x = linea.split(",");
			Integer a=Integer.valueOf(x[0]);
			Integer b=Integer.valueOf(x[1]);
			Integer c=Integer.valueOf(x[2]);
			System.out.println("Entrada ("+a+","+b+","+c+")\n Rec NoMem: "+Ejercicio5.RecNM(a,b,c)
			+"\n RecMem: "+Ejercicio5.RecCM(a,b,c,m));
		}
	}
}
