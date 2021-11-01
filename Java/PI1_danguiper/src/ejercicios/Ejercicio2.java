package ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Coge todas las listas del elemento listas. Y las transforma en un stream de listas. 
//Devuelve un map<Integer,List>string>, KEY: Lenght, VALUE: Lista Palabras 

public class Ejercicio2 {
	public static Map<Integer,List<String>> ej2It (List<List<String>> listas) {
		Map <Integer,List<String>> res= new HashMap<Integer, List<String>>();
		int i=0;
		while(i<listas.size()) {
			int j=0;
			List<String>lista=listas.get(i);
			while(j<lista.size()) {
				String elem=lista.get(j);
				if(res.containsKey(elem.length())){
					List<String> palabras =res.get(elem.length());
					palabras.add(elem);
					res.put(elem.length(),palabras);
										
				}else {
					List<String> elemL = new ArrayList<>();
					elemL.add(elem);
					res.put(elem.length(), elemL);
				}
				j++;
			}
			i++;
		}
		return res;
	}
//---------------------------------------------------------------------------------------------------------------------------------
	public static Map<Integer,List<String>> ejercicio2RE (List<List<String>> listas) {
		Map <Integer,List<String>> res= new HashMap<Integer, List<String>>();
			res= ej2Re(res,listas,0,0);
			return res;
	}
	
	private static Map<Integer, List<String>> ej2Re(Map<Integer, List<String>> res, List<List<String>> listas, Integer i,Integer j) {
		if(i==listas.size()){
			return res;
		}else {
			List<String> list=listas.get(i);
			
			if(j==list.size()) {
				res= ej2Re(res,listas,i+1,0);
			}else {
				String elem=list.get(j);
				if(res.containsKey(elem.length())){
					List<String> palabras =res.get(elem.length());
					palabras.add(elem);
					res.put(elem.length(),palabras);
										
				}else {
					List<String> elemL = new ArrayList<>();
					elemL.add(elem);
					res.put(elem.length(), elemL);
				}
				res= ej2Re(res,listas,i,j+1);
				
			}
		}
		return res;
	}

}
