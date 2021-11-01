package ejercicios;

import java.util.ArrayList;
import java.util.List;

//Itera un par de valores hasta que el primer valor sea igual o mayor al parámetro limit
//Cada par nuevo lo guarda en una lista y la convierte a String
public class Ejercicio3 {
	public static String ejercicio3it(Integer a, Integer limit) {
		List<Par> res= new ArrayList<>();
		Par I= new Par(0,a);
		
		while(I.v1<limit) {
			res.add(I);
			int v1=I.v1+1;
			int v2= I.v2;
			if(I.v1%3!=1) {
				v2+=I.v1;
			}
			I =new Par(v1,v2);
			
		}
		
		return res.toString();
	}
	
//------------------------------------------------------------------
	public static String ej3Re(Integer a, Integer limit) {
		List<Par> res= new ArrayList<>();
		 Par p=new Par(0,a);
		return ej3Re(p,limit,res); 
	}
	
	private static String ej3Re(Par p, Integer limit, List<Par> res) {
		if(p.v1<limit) {
			res.add(p);
			int v1= p.v1+1;
			int v2= p.v2;
			if(p.v1%3!=1) {
				v2=p.v1+p.v2;
			}
			p= new Par(v1, v2);
			ej3Re(p,limit,res);
		}
		return res.toString();
		
	}

	 
	public record Par(int v1,int v2) {
	}

}	
