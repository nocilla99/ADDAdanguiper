package Test;

import java.util.ArrayList;
import java.util.List;

import Ejercicios.Ejercicio3;
import us.lsi.common.Files2;

public class test3 {

	public static void main(String[] args) {
		String ruta= "./fichero/PI2Ej3DatosEntrada.txt";
		List<String> fichero=Files2.linesFromFile(ruta);
		for(String linea:fichero) {
			String[] x = linea.split("#");
			String[] li= x[0].split(",");
			String[] lims=x[1].split(",");
			List<Integer> a=new ArrayList<Integer>();
			for (String i:li) {
				a.add(Integer.valueOf(i));
			}
			System.out.println("Entrada "+a+"\n Rango: ["+ lims[0]+","+lims[1]+")\n Conjunto: "+Ejercicio3.ej3_v2(a,Integer.valueOf(lims[0]),Integer.valueOf(lims[1]))+"\n");
		}

	}

}
