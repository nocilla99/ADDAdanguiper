package ejemplos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ejem2 {
	List<Integer> divisores(Long n){

	List<Integer>res=new ArrayList<Integer>();
	long i=2L;
		while(i<=(long)Math.sqrt(n)) {
			if(n%i==0) {
				res.add((int)i);
			}
			i++;
		}
		return res;
	}
	Integer BusqBin(List<Integer>l,Integer e,Comparator<Integer> comp) {
		Integer res=-1;
		Integer i=0;
		Integer j= l.size();
		Integer k=(j+i)/2;
		while(res==-1&&(j-i)>0) {
			k=(j+i)/2;
			if(l.get(k)==e) {
				res=k;
			}else if((l.get(k)<e)) { //k es mas chico que e
				i=k+1;
			}else{
				j=k-1;
			}
		}
		return res;
	}
}
