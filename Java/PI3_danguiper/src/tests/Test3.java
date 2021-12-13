package tests;

import java.util.List;
import ejercicios.Ejercicio3;
import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.BinaryTree;

public class Test3 {

	public static void main(String[] args) {
		String ruta= "./fichero/PI3E3_DatosEntrada.txt";
		List<String> lineas= Files2.linesFromFile(ruta); 
		for (String linea:lineas) {
			BinaryTree<Integer> arbol= BinaryTree.parse(linea,dato->Integer.valueOf(dato));
			System.out.println("Entrada: "+arbol+"\n"
				+"  Salida -> "+Ejercicio3.ej3REC(arbol)
				);
		}

	}

}
