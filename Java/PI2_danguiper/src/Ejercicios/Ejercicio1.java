package Ejercicios;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio1 {
	public static String Ej1it(int a,int b,int c) {
		String txt="";
		while(true) {
			if(a<3 &&b<3 && c<3) {
				String s=String.format("(%d)", a*b*c);
				txt=txt+s;
				return txt;
			}else if(a<5 ||b<5 || c<5) {
				String s=String.format("(%d)", a+b+c);
				txt=txt+s;
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
				return Stream
				.iterate(new ej1(a,b,c,""),
						t->t.b(t.a, t.b, t.c),
						t->t.NoBase(t.a, t.b, t.c, t.s)
						)
				.map(t->
						(t.a<3 && t.b<3 && t.c<3)?
								new ej1(t.a,t.b,t.c,String.format(t.s+"(%d)", t.a*t.b*t.c))
								:(t.a<5 ||t.b<5 || t.c<5)?
										new ej1(t.a,t.b,t.c,String.format(t.s+"(%d)", t.a+t.b+t.c))
										:t.NoBase(t.a, t.b, t.c, t.s)
						)
				.filter(t->(t.a<3 &&t.b<3 && t.c<3) || (t.a<5 ||t.b<5 || t.c<5))
				.map(t->(t.s().contains("("))?
					t.s
					:(t.a<3 && t.b<3 && t.c<3)?
					String.format(t.s+"(%d)", t.a*t.b*t.c)
						:String.format(t.s+"(%d)", t.a+t.b+t.c)
					).collect(Collectors.toList()).get(0);
	}
	public record ej1(int a,int b,int c,String s) {
		public ej1 NoBase(int a,int b,int c,String s) {
			if(a%2==0 && b%2==0 && c%2==0) {
				return new ej1(a/2,b-2,c/2,String.format(s+"%d", a*b*c));
			}else{
				return new ej1(a/3,b-3,c/3,String.format(s+"%d", a+c+b));
			}
		}
		public boolean b(int a,int b,int c) {
			if(!(a<3 &&b<3 && c<3)||!(a<5 ||b<5 || c<5)){
				return true;
			}else {
				return false;
			}
		}
	}
	
	public static String ej1ReF(int a, int b,int c) {
		return ej1Ref(a,b,c,"");
	}

	private static String ej1Ref(int a, int b, int c, String txt) {
		
		if(a<3 &&b<3 && c<3) {
			String s=String.format("(%d)", a*b*c);
			txt=txt+s;
			return txt;
		}else if(a<5 ||b<5 || c<5) {
			String s=String.format("(%d)", a+b+c);
			txt=txt+s;
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
			String s=String.format("(%d)", a*b*c);
			txt=txt+s;
		}else {
			String s=String.format("(%d)", a+b+c);
			txt=txt+s;
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
	
	
	
}
