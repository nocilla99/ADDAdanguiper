package Ejercicios;

import java.math.BigInteger;
import java.util.Map;

public class Ejercicio4 {
	public static BigInteger RecNM(BigInteger a) {
		return recnm(a);
	}

	private static BigInteger recnm(BigInteger a) {
	
		if(a.equals(BigInteger.TWO)) {
			return BigInteger.valueOf(6);
		}else if(a.equals(BigInteger.ONE)) {
			return BigInteger.valueOf(4);
		}else if(a.equals(BigInteger.ZERO)) {
			return BigInteger.valueOf(2);
		}else {
			return recnm(a.subtract(BigInteger.ONE)).multiply(BigInteger.TWO).add(
					recnm(a.subtract(BigInteger.TWO)).multiply(BigInteger.valueOf(4 ))).add(
					recnm(a.subtract(BigInteger.valueOf(3))).multiply(BigInteger.valueOf(6)));
		}
		
	}
	
	public static BigInteger RecCM(BigInteger a,Map<BigInteger,BigInteger> map) {
		return reccm(a,map);
	}

	private static BigInteger reccm(BigInteger a,Map<BigInteger,BigInteger> map) {
		if(map.containsKey(a)) {
			return map.get(a);
		}else {
			if(a.equals(BigInteger.TWO)) {
				return BigInteger.valueOf(6);
			}else if(a.equals(BigInteger.ONE)) {
				return BigInteger.valueOf(4);
			}else if(a.equals(BigInteger.ZERO)) {
				return BigInteger.valueOf(2);
			}else {
				BigInteger b=recnm(a.subtract(BigInteger.ONE)).multiply(BigInteger.TWO).add(
						recnm(a.subtract(BigInteger.TWO)).multiply(BigInteger.valueOf(4 ))).add(
						recnm(a.subtract(BigInteger.valueOf(3))).multiply(BigInteger.valueOf(6)));
				map.put(a, b);
				return b;
			}
		}
		
	}
}
