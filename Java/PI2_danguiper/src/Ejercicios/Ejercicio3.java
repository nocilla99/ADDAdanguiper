package Ejercicios;
import java.util.List;

import us.lsi.common.IntegerSet;
public class Ejercicio3 {
	public static IntegerSet ej3rec(List<Integer> li,Integer inicio,Integer fin) {
		IntegerSet res= IntegerSet.empty();
		
		Integer indexIni= buscinicio(li,0,inicio,li.size());//inicio es el valor que queremos sacar
		Integer indexFin= buscfinal(li,0,fin,li.size());
		if(inicio==fin) {
			res.add(li.get(inicio));
			return res;
		}else if(inicio>fin) {
			return IntegerSet.empty();
		}else {
			for(int i:li.subList(indexIni, indexFin)) {
				res.add(i);
			}
			return res;
		}
	}

	private static Integer buscfinal(List<Integer> li, int inicio, Integer obj, int fin) {
		Integer indice=(inicio+fin)/2;
		if(li.get(indice)<obj && (li.get(indice+1)>obj)) {
			return indice;
		}else if(li.get(indice)>obj){
			fin=indice;
		}else {
			inicio=indice;
		}
		return buscfinal(li,inicio,obj,fin);
	}

	private static Integer buscinicio(List<Integer> li, Integer inicio,Integer obj, Integer fin) {
		Integer indice = (inicio+fin)/2;
		if (li.get(indice)==obj||(li.get(indice-1)<obj&&obj<li.get(indice))) { //Exacto ||  1 3 5 7 (cae en 5(indice) y buscamos 4(obj))-> [indice]>obj && [indice-1]<obj
			return indice;
		}else if(li.get(indice)<obj){
			inicio=indice;
		}else {
			fin=indice;	
		}
		return buscinicio(li,inicio,obj,fin);
	
	}
	/*
	 //rangeof if match-> add
	 public static IntegerSet prueba(List<Integer> ls,int inicio,int fin) {
		 IntegerSet res=IntegerSet.ofRange(inicio-1,fin-1);
		 IntegerSet resu=IntegerSet.empty();
		 for(int i:res) {
			 if(ls.indexOf(i)!=-1) {
				 resu.add(ls.get(i));
			 }
		 }
		 return resu;
	 }*/
}
