package Ejercicios;
import java.util.List;
import us.lsi.common.IntegerSet;

public class Ejercicio3 {
	
	public static IntegerSet ej3rec(List<Integer> li,Integer inicio,Integer fin) {
		Integer indexIni= buscinicio(li,0,inicio,li.size()-1);//indice del valor inicio (el valor más bajo)
		Integer indexFin= buscfinal(li,0,fin,li.size()-1);//indice del valor fin
		IntegerSet res=IntegerSet.empty();
		if(indexIni==null) {
			return IntegerSet.empty();
		}
		for(Integer i:li.subList(indexFin,indexIni+1)) {
			res.add(i);
		}
		return res;
		
	}

	private static Integer buscinicio(List<Integer> li, Integer ini,Integer obj, Integer fin) {
			if(obj<=li.get(li.size()-1)) {//Si es más pequeño que el último valor(menor), devuelve el indice del menor elemento
				return li.size()-1;
			}else if(li.get(fin)==obj) {
				return fin;
			}else if(li.get(ini)==obj) {
				return ini;
			}else if(obj>li.get(0)) {//Mayor que el primer elemento, devuelve un null, ya que el IntegerSet va a ser vacío
				return null;
			}
			//Siguiente iteración
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
		//este método es igual al de buscinicio
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
}
