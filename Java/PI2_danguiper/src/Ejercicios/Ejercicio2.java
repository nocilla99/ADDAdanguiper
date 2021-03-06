package Ejercicios;

import java.util.ArrayList;
import java.util.List;
import us.lsi.common.Matrix;
import us.lsi.common.View4;

public class Ejercicio2 {
	public static List<String> ej1Rec(Matrix<String> mat){
		List<String> ls=new ArrayList<>();
		return ej1rec(mat,ls);	
	}

	private static List<String> ej1rec(Matrix<String> mat, List<String> ls) {
		String iteracion="";
		for(String pal:mat.corners()) {
			iteracion+=pal;
		}
		ls.add(iteracion);
		if (!(mat.nc()<=2)){
				View4<Matrix<String>> partes=mat.views4();
				ej1rec(partes.a(),ls);
				ej1rec(partes.b(),ls);
				ej1rec(partes.c(),ls);
				ej1rec(partes.d(),ls);
			}
		return ls;
	}
}
