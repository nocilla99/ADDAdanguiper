package Ejercicios;

import java.util.ArrayList;
import java.util.List;
import us.lsi.common.Matrix;
import us.lsi.common.View4;

//Acabado
public class ejercicio2 {
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
		//ls.add(mat.corers()) -> cambiar a List<List<String>>
		if (!(mat.nc()<=2)){
				View4<Matrix<String>> v4=mat.views4();
				ej1rec(v4.a(),ls);
				ej1rec(v4.b(),ls);
				ej1rec(v4.c(),ls);
				ej1rec(v4.d(),ls);
			}
		return ls;
	}
}
