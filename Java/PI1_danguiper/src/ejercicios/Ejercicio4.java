package ejercicios;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio4 {


	public static double ejercicio4RE(Double n, Double e) {
		return ej4Re(n,1.,e,Math.cbrt(n));
	}
	
	public static double ej4Re(Double fin, Double ini, Double e,Double root) {
		double next=(fin+ini)/2;
		if(next < root + e && next > root - e) {
			return next;
		}else if(next < root){
			ini=next;
		}else {
			fin=next;
		}
		return ej4Re(fin,ini,e,root);
	}
//------------------------------------------------------------------------------
	public static double ejercicio4it(Double n, Double e) {
		double root= Math.cbrt(n);
		double ini=1;
		double fin=n;
		
		while(true) {
			double next = (fin+ini)/2;
			if(next < root + e && next > root - e) {
				return next;
			}else if(next < root){
				ini=next;
			}else {
				fin=next;
			}
		}
	}
//------------------------------------------------------------------------------
	public static double Ej4Fu(double n,double e) {
		return Stream.iterate( new Tupla(n,e,1,n,n),
				t->(t.next >= Math.cbrt(t.num) + t.err || t.next <= Math.cbrt(t.num) - t.err),
				t->new Tupla(t.num,t.err, (t.next < Math.cbrt(t.num))?t.next : t.ini,(t.next > Math.cbrt(t.num))?t.next : t.fin,(t.ini+t.fin)/2)
				).map(t->(t.ini+t.fin)/2).filter(t->t<Math.cbrt(n)+e && t>Math.cbrt(n)-e).limit(1).collect(Collectors.toList()).get(0);
			//.collect(Collectors.toList()).get(List::s-1); ??
			}

	public record Tupla(double num, double err,double ini,double fin, double next) {
	}
}