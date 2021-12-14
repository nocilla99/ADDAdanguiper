package ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio5 {
	public static Map<Paridad,List<Integer>> ej5REC(BinaryTree<Integer> arbol){
		Map<Paridad,List<Integer>> map= new HashMap<Paridad,List<Integer>>();
		map.put(Paridad.PAR, new ArrayList<>());
		map.put(Paridad.IMPAR, new ArrayList<>());
		return ej5reca(arbol,map);
	}

	private static Map<Paridad, List<Integer>> ej5reca(BinaryTree<Integer> arbol, Map<Paridad,List<Integer>>  res) {
		if(!arbol.isEmpty()) {
			if(!arbol.getRight().isEmpty() && !arbol.getLeft().isEmpty()) {
				int i=arbol.getLeft().getLabel();
				int p= arbol.getLabel();
				int d=arbol.getRight().getLabel();
				if(i<p && p<d) {
					res.get(getParidad(p)).add(p);
					
				}
			}
			if(arbol.getLeft().isBinary()) {
				ej5reca(arbol.getLeft(),res);
			}
			if(arbol.getRight().isBinary()) {
				ej5reca(arbol.getRight(),res);
			
			}
			
		}
		return res;
		
	}

	
	public static Map<Paridad,List<Integer>> ej5FUN(BinaryTree<Integer> arbol){
	return  arbol.stream().filter(nodo->nodo.isBinary()&& !nodo.getRight().isEmpty() && !nodo.getLeft().isEmpty())
			.filter(arboli-> arboli.getLeft().getLabel() < arboli.getLabel() && arboli.getLabel()< arboli.getRight().getLabel())
			.map(elem->elem.getLabel()).collect(Collectors
					.groupingBy(elem-> getParidad(elem)));
	}
	
	private static Paridad getParidad(int p) {
		if (p%2==0) {
			return Paridad.PAR;
		}else {
			return Paridad.IMPAR;
		}
	}
}
