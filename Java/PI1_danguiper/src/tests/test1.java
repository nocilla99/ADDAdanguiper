package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import ejercicios.Ejercicio1;
import us.lsi.common.Files2;

public class test1 {

	public static void main(String[] args) {
		
		Predicate<String> predS= Ejercicio1.predS();
		Predicate<Integer> predI = Ejercicio1.predI();
		Function<String, Integer> f = Ejercicio1.f();
		String ruta= "./ficheros/TestAlumnos/PI1E1_DatosEntrada.txt";
		List<String> fichero=Files2.linesFromFile(ruta);
		
		for(String linea:fichero) {
			if(!linea.contains("//")) {
				List<String> ls= new ArrayList<>();
				String[] x=linea.split(",");
				for(String pal:x) {
					ls.add(pal);
				}
				System.out.println("Entrada "+ls
						+"\n Rec: "+Ejercicio1.ejercicio1RE(ls, predS, predI, f)
						+"\n Ite: "+Ejercicio1.ejercicio1it(ls, predS, predI, f)+"\n"
						);
			}
		}
	}
	
}
