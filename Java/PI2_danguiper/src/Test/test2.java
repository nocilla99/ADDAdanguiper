package Test;

import java.util.List;

import Ejercicios.Ejercicio2;
import us.lsi.common.Files2;
import us.lsi.common.Matrix;

public class test2 {

	public static void main(String[] args) {
		String ruta= "./fichero/PI2Ej2DatosEntrada2.txt";
		List<String> fichero=Files2.linesFromFile(ruta);
		Integer m= fichero.size();
		
		String[][]data= new String[m][m];
		
		for (int i=0;i<fichero.size();i++) {
			
			String[] x=fichero.get(i).split(" ");
			
			for (int j=0;j<x.length;j++) {
				data[i][j]=x[j];
			}
		}
		
		Matrix<String> matriz=Matrix.of(data);
		List<String>l=Ejercicio2.ej1Rec(matriz);
		for (String elem:l) {
			System.out.println((l.indexOf(elem)+1)+") "+elem);
		}
	}

}
