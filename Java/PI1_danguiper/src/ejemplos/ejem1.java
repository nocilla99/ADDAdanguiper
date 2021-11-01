package ejemplos;

import java.util.ArrayList;
import java.util.List;

public class ejem1 {
	
}
	//Iterativo
	/*
	 List<Tuple2<Long,Long>> primosPar(Long m,Long n,Integer k){
	 
		List<Integer>listaTupla =new ArrayList<Integer>();
		Long i=siguientePrimo(m-1);
		while(i<n) {
			Long j= siguientePrimo(i);
			if(j<n && (j-i==k)) {
				//listaTupla.add(Tuple2.create(i,j));
			}
			i=j;
		}
		return listaTupla;
	}
	private Long siguientePrimo(Long i) {
		// TODO Auto-generated method stub
		return null;
	}
	List<Tuple2<Long,Long>> primosParR(Long m,Long n,Integer k){
		List<Integer>listaTupla =new ArrayList<Integer>();
		Long i=siguientePrimo(m-1);
		List<Integer>listaTupla =new ArrayList<Integer>();
		Long i=siguientePrimo(i);
		primosParRR(listaTupla,i,j,n,k);
		return listaTupla;
	}
	void primosParRR(List<Integer> listaTupla,Long i,Long j,Long n,Integer k){
		if(j<n) {
			if(j-i==k) {
				listaTupla.add(Tuple2.create(i,j));
			}
		}else {
			primosParRR(listaTupla,i,j,n,k);
		}
	}
}
//diapo 44 
*/