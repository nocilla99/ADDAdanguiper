package Ejercicios;
import java.util.List;
import us.lsi.common.IntegerSet;

//acabado
public class Ejercicio3 {
	
	public static IntegerSet ej3rec(List<Integer> li,Integer inicio,Integer fin) {
		Integer indexIni= buscinicio(li,0,inicio,li.size()-1);//inicio es el valor que queremos sacar
		Integer indexFin= buscfinal(li,0,fin,li.size()-1);

		if(indexIni==null) {
			return IntegerSet.empty();
		}
		return IntegerSet.ofRange(li.get(indexIni), li.get(indexFin)+1);
		
	}

	private static Integer buscinicio(List<Integer> li, Integer ini,Integer obj, Integer fin) {
			if(obj<=li.get(li.size()-1)) {
				return li.size()-1;
			}else if(li.get(fin)==obj) {
				return fin;
			}else if(li.get(ini)==obj) {
				return ini;
			}else if(obj>li.get(0)) {
				return null;
			}
			Integer indice = (ini+fin)/2;
			if (li.get(indice)==obj||(li.get(indice-1)<obj&&obj<li.get(indice))) { 
				return indice;
			}else if(li.get(indice)>obj){
				ini=indice;
			}else {
				fin=indice;	
			}
			return buscinicio(li,ini,obj,fin);
		}

	private static Integer buscfinal(List<Integer> li, int ini, Integer obj, int fin) {
			if(obj>li.get(0)) {
				return 0;
			}else if(li.get(li.size()-1)>obj&&li.get(li.size()-2)<=obj) {
				return li.size()-1;
			}
			if(li.get(fin)>obj&&li.get(fin+1)<=obj) {
				return fin;
			}
			Integer indice=(ini+fin)/2;
			if(li.get(indice)==obj) {
				return indice+1;
			}else if(li.get(indice)<=obj){
				fin=indice;
			}else if(li.get(indice)>obj) {
				ini=indice;
			}
			return buscfinal(li,ini,obj,fin);
		}
	
	
//-------------------------------------------------------------------------------------------------------
	public static IntegerSet ej3_v2(List<Integer> li,int ini,int fin) {
		return ej3rec2(li,ini,fin,IntegerSet.empty(),0);
	}
	
	private static IntegerSet ej3rec2(List<Integer> li, int ini, int fin, IntegerSet res,int indice) {
		if(ini>li.get(0)) {
			return res;
		}else {
			if(indice==li.size()) {
				return res;
			}else {
				if(li.get(indice)>=ini && li.get(indice)<fin) {
					res.add(li.get(indice));
				}
				return ej3rec2(li,ini,fin,res,indice+1);
			}
		}
	}
}
