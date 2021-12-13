package tests;

import java.util.List;
import ejercicios.Ejercicio2;
import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.BinaryTree;

public class Test2 {

	public static void main(String[] args) {
		String ruta= "./fichero/PI3E2_DatosEntrada.txt";
		List<String> lineas= Files2.linesFromFile(ruta); 
		for (String linea:lineas) {
			String[] trozos= linea.split("#");
			BinaryTree<Integer> arbol= BinaryTree.parse(trozos[0],dato->Integer.valueOf(dato));
			System.out.println("Entrada: "+linea+"\n"
					+"  Salida -> "+Ejercicio2.ej2REC(arbol,Integer.valueOf(trozos[1])));
		}
	}

}

