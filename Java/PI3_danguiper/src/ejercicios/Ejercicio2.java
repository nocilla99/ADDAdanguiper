package ejercicios;

import java.util.HashSet;
import java.util.Set;

import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio2 {
	public static Set<Integer> ej2REC(BinaryTree<Integer> arbol, Integer limite){
		Set<Integer> res= new HashSet<>();
		return ej2reca(arbol,limite,res);
	}
	public static Set<Integer> ej2reca(BinaryTree<Integer> arbol, Integer limite,Set<Integer> res){
		switch(arbol.getType()){
		case Empty:
			break;
		case Leaf:
			Integer et= arbol.getLabel();
			if(et>=limite){ 
				res.add(arbol.getLabel());
				}
			break;
		case Binary:
			et= arbol.getLabel();
			if(et>=limite){ 
				res.add(arbol.getLabel());
				}
			ej2reca(arbol.getRight(),limite,res);
			ej2reca(arbol.getLeft(),limite,res);
			break;
		}
		return res;
	}

}
