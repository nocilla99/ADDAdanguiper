package ejercicios;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
//filtra la lista segun pS. Mapea usando la funcion f. Ver si algun elemento hace match con pI
public class Ejercicio1{
	public static boolean  ejercicio1it(List<String> ls, Predicate<String> pS,Predicate<Integer> pI, Function<String,Integer> f){
		 int i=0;
		 while(i<ls.size()) {
			 if(pS.test(ls.get(i).trim())){
				 int r= f.apply(ls.get(i).trim());
				 if(pI.test(r)) {
					 return true;
				 }
			 }
			 i++;
		 }
		return false;
	}
	
//--------------------------------------------------------------------------------------------------------------------------------------------
	public static boolean  ejercicio1RE(List<String> ls, Predicate<String> pS,Predicate<Integer> pI, Function<String,Integer> f){
		boolean res= ej1Re(ls,pS,pI,f,0);
		return res;
	}
	private static boolean ej1Re(List<String> ls, Predicate<String> pS, Predicate<Integer> pI,Function<String, Integer> f, int i) {
		if(i==ls.size()) {
			return false;
		}else {  
			if(pS.test(ls.get(i).trim())){
			 int r= f.apply(ls.get(i).trim());
			 if(pI.test(r)) {
				 return true;
			 }
		}
		return ej1Re(ls,pS,pI,f,i+1);
		}
	}
	
	public static Predicate<String> predS(){
		return p->p.contains("a")||p.contains("o")||p.contains("e");
	}
	
	public static Predicate<Integer> predI(){
		return p->p%2==0;
	}
	public static Function<String,Integer> f() {
		return p ->p.length();
	}
	
}

