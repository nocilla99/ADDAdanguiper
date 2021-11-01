package ejemplos;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
//testeo para hacer q devuelva la palabra tb
public class Ejercicio1v2{
	public static String  ejercicio1it(List<String> ls, Predicate<String> pS,Predicate<Integer> pI, Function<String,Integer> f){
		 int i=0;
		 while(i<ls.size()) {
			 if(pS.test(ls.get(i))){
				 int r= f.apply(ls.get(i));
				 if(pI.test(r)) {
					 Tupla p= new Tupla(true, ls.get(i));
					 return p.b+" "+p.pal;
				 }
			 }
			 i++;
		 }
		return "false";
	}
	
//--------------------------------------------------------------------------------------------------------------------------------------------
	public static String  ejercicio1RE(List<String> ls, Predicate<String> pS,Predicate<Integer> pI, Function<String,Integer> f){
		String res= ej1Re(ls,pS,pI,f,0);
		return res;
	}
	private static String ej1Re(List<String> ls, Predicate<String> pS, Predicate<Integer> pI,Function<String, Integer> f, int i) {
		if(i==ls.size()) {
			return "false";
		}else {  
			if(pS.test(ls.get(i))){
			 int r= f.apply(ls.get(i));
			 if(pI.test(r)) {
				 Tupla p= new Tupla(true, ls.get(i));
				 return p.b+" "+p.pal;
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
	
	public record Tupla(boolean b, String pal) {
	}
	
	
	
}

