package Test;

import java.util.List;

import Ejercicios.Ejercicio1;
import us.lsi.common.Files2;

public class test1 {

	public static void main(String[] args) {
		String ruta= "./fichero/PI2Ej1DatosEntrada.txt";
		List<String> fichero=Files2.linesFromFile(ruta);
		
		for(String linea:fichero) {
			String[] x = linea.split(",");
			Integer a=Integer.valueOf(x[0]);
			Integer b=Integer.valueOf(x[1]);
			Integer c=Integer.valueOf(x[2]);
			System.out.println("Entrada ("+a+","+b+","+c+")\n Ite: "+Ejercicio1.Ej1it(a,b,c)
			//+"\n Re Final: "+Ejercicio1.ej1ReF(a, b, c)
			//+"\n Rec No Final: "+Ejercicio1.ej1ReNF(a, b, c)
			+"\n Fun: "+Ejercicio1.ej1Fu(a, b, c)
			);
		}
	}

}
