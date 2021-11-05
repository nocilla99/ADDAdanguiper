package Ejercicios;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio5 {
	public static Integer RecNM(int a,int b,int c) {
		return recnm(a,b,c);
	}

	private static Integer recnm(int a, int b, int c) {
		if(a<3 ||b<3|| c<3) {
			return a+b*b+2*c;
		}else if(a%b==0) {
			return recnm(a-1,b/2,c/2)+recnm(a-3,b/3,c/3);
		}
		return recnm(a/3,b-3,c-3)+recnm(a/2,b-2,c-2);
	}
	
	public static Integer RecCM(int a,int b,int c,Map<Tupla,Integer> m) {
		return reccm(a,b,c, m);
	}

	private static Integer reccm(int a, int b, int c,Map<Tupla,Integer> m) {
		if(m.containsKey(new Tupla(a,b,c))) {
			return m.get(new Tupla(a,b,c));
		}else {
			if(a<3 ||b<3|| c<3) {
				int res=a+b*b+2*c;
				m.put(new Tupla(a,b,c), res);
				return res;
			}else if(a%b==0) {
				return reccm(a-1,b/2,c/2,m)+reccm(a-3,b/3,c/3,m);
			}
			return reccm(a/3,b-3,c-3,m)+reccm(a/2,b-2,c-2,m);
		}
	}
	
	
	public static Integer ite(int a,int b,int c) {
		Map<Tupla,Integer> m= new HashMap<>();
		while(true) {
			if(m.containsKey(new Tupla(a,b,c))) {
		
				return m.get(new Tupla(a,b,c));
			}else {
				if(a<3 ||b<3|| c<3) {
					b=b*b;
					c=2*c;
					int res=a+b+c;
					m.put(new Tupla(a,b,c), res);
					return res;
				}else if(a%b==0) {
					int x=m.get(new Tupla(a-1,b/2,c/2));
					int y=m.get(new Tupla(a-3,b/3,c/3));
					return x+y;
				}else {
					int x=m.get(new Tupla(a/3,b-3,c-3));
					int y=m.get(new Tupla(a/2,b-2,c-2));
					return x+y;
		
				}
				
			}
		}
	}
	
	public record Tupla(int a, int b, int c) {
		
	}
}
