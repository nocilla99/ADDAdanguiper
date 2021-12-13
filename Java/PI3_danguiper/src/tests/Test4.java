package tests;

import java.util.List;

import ejercicios.Ejercicio4;
import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.Tree;

public class Test4 {

	public static void main(String[] args) {
		String ruta= "./fichero/PI3E4_DatosEntrada.txt";
		List<String> lineas= Files2.linesFromFile(ruta); 
		for (String linea:lineas) {
			Tree<String> entrada= Tree.parse(linea);
			System.out.println("Entrada: "+entrada+ "\n"
					+"  Salida-> "+Ejercicio4.ej4REC(entrada));
			}

	}

}
