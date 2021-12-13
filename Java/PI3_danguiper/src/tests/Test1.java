package tests;

import java.util.List;
import java.util.function.Predicate;

import ejercicios.Ejercicio1;
import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.Tree;

public class Test1 {

	public static void main(String[] args) {
		Predicate<Integer> pred1= x-> x<5;
		Predicate<Integer> pred2=x -> x%2==0;
		String ruta= "./fichero/PI3E1_DatosEntrada.txt";
		List<String> lineas= Files2.linesFromFile(ruta); 
		for (String linea:lineas) {
			Tree<Integer> entrada= Tree.parse(linea,dato->Integer.valueOf(dato));
			System.out.println("Entrada: "+entrada+ " (rec / fun)\n"
					+"  Pred 1-> "+Ejercicio1.ej1REC(entrada, pred1)+" / "+Ejercicio1.ej1Fun(entrada, pred1)+
					"\n  Pred 2 ->"+Ejercicio1.ej1REC(entrada, pred2)+" / "+Ejercicio1.ej1Fun(entrada, pred2));
		}
	}

}
