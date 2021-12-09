package practicas;

import java.util.List;
import java.util.Map;

import us.lsi.tiposrecursivos.Tree;

public class Ejemplo4 {
	public static <E> Map<Integer,List<E>> sol_rec(Tree<E> arbol, int nivel, Map<Integer,List<E>> res){
		
		//MAPA (Nivel,Lista de nodos  q cumplen un predicado(hijos pares))
		switch(arbol.getType()) {
		case Empty:
			break;
		case Leaf:
			break;
		case Nary:
			if(arbol.getNumOfChildren()%2==0 && arbol.getNumOfChildren()>0) {
				if(res.containsKey(nivel)) {
					List<E> ls= res.get(nivel);
					res.put(nivel, ls);
				}else {
					res.put(nivel,(List<E>) arbol.getLabel());
				}
			}
			arbol.getChildren().forEach(subarbol-> sol_rec(subarbol,nivel+1,res));
			break;
		}
		return res;
	}
}
