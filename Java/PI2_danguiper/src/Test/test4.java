package Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Ejercicios.Ejercicio4;
import us.lsi.common.Files2;

public class test4 {

	public static void main(String[] args) {
		String ruta= "./fichero/PI2Ej4DatosEntrada.txt";
		List<String> fichero=Files2.linesFromFile(ruta);
		Map<BigInteger, BigInteger> map= new HashMap<BigInteger, BigInteger>(); 
		for (String l:fichero) {
			String[] x= l.split("=");
			BigInteger dato=BigInteger.valueOf(Long.valueOf(x[1]));
			System.out.println("Entrada :"+l
			+"\n Rec Sin Mem: "+Ejercicio4.RecNM(dato)
			+"\n Rec Con Mem: "+Ejercicio4.RecCM(dato,map)
			+"\n Ite:         "+Ejercicio4.iter(Long.valueOf(x[1])));
		}

	}

}
