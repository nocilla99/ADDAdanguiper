package Ejercicios;

import java.util.stream.Stream;

public class Ejercicio1 {
	public static String Ej1it(int a,int b,int c) {
		String txt="";
		while(true) {
			if(a<3 &&b<3 && c<3) {
				String s=String.format("%d", a*b*c);
				txt=txt+"("+s+")";
				return txt;
			}else if(a<5 ||b<5 || c<5) {
				String s=String.format("%d", a+b+c);
				txt=txt+"("+s+")";
				return txt;
			}else if(a%2==0 &&b%2==0 && c%2==0) {
				String s=String.format("%d", a*b*c);
				txt=txt+s;
				a=a/2;
				b=b-2;
				c=c/2;
			}else {
				txt=txt+String.format("%d", a+c+b);
				a=a/3;
				b=b-3;
				c=c/3;
			}
		}
			
	}
	
	public static String ej1Fu(int a,int b,int c) {
		return Stream.iterate(new ej1(a,b,c,""),t->t.s=="condicionv (caso base)",t->new ej1(t.a/3,t.b-3,c/3,t.s+""))
				.filter(t->t.s=="casos bases").map(t->t.s).limit(1).toString();
	}
	
	public static String ej1ReF(int a, int b,int c) {
		return ej1Ref(a,b,c,"");
	}

	private static String ej1Ref(int a, int b, int c, String txt) {
		
		if(a<3 &&b<3 && c<3) {
			String s=String.format("%d", a*b*c);
			txt=txt+"("+s+")";
			return txt;
		}else if(a<5 ||b<5 || c<5) {
			String s=String.format("%d", a+b+c);
			txt=txt+"("+s+")";
			return txt;
		}else if(a%2==0 &&b%2==0 && c%2==0) {
			String s=String.format("%d", a*b*c);
			txt=txt+s;
			a=a/2;
			b=b-2;
			c=c/2;
		}else {
			txt=txt+String.format("%d", a+c+b);
			a=a/3;
			b=b-3;
			c=c/3;
		}
		return ej1Ref(a,b,c,txt);
	}


	public static String ej1ReNF(Integer a, Integer b, Integer c) {
		ej1 rec=ej1recnf(a,b,c,"");
		a=rec.a;
		b=rec.b;
		c=rec.c;
		String txt=rec.s;
		if(a<3 &&b<3 && c<3) {
			String s=String.format("%d", a*b*c);
			txt=txt+"("+s+")";
		}else {
			String s=String.format("%d", a+b+c);
			txt=txt+"("+s+")";
		}
			return txt;
	}

	private static ej1 ej1recnf(Integer a, Integer b, Integer c,String txt) {
		
		if((a<3 &&b<3 && c<3)||(a<5 ||b<5 || c<5)) {
			return new ej1(a,b,c,txt);
		}else{
			if(a%2==0 &&b%2==0 && c%2==0) {
				txt=txt+String.format("%d", a*b*c);
				a=a/2;
				b=b-2;
				c=c/2;
				
			}else {
				txt=txt+String.format("%d", a+c+b);
				a=a/3;
				b=b-3;
				c=c/3;
							}
		}
		return ej1recnf(a,b,c,txt);
	}
	
	
	public record ej1(int a,int b,int c,String s) {
	}
}
