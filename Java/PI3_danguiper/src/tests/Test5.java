package tests;

import java.util.List;

import ejercicios.Ejercicio5;
import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.BinaryTree;

public class Test5 {

	public static void main(String[] args) {
		String ruta= "./fichero/PI3E5_DatosEntrada.txt";
		List<String> lineas= Files2.linesFromFile(ruta); 
		for (String linea:lineas) {
			BinaryTree<Integer> arbol= BinaryTree.parse(linea,dato->Integer.valueOf(dato));
			System.out.println("Entrada: "+arbol+" (fun/rec)\n"
				+"  Salida -> "+Ejercicio5.ej5FUN(arbol)+" / "+Ejercicio5.ej5REC(arbol)
				);
		}

	}

}
