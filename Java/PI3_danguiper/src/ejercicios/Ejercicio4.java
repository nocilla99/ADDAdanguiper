package ejercicios;
import java.util.HashSet;
import java.util.Set;

import us.lsi.tiposrecursivos.Tree;

public class Ejercicio4 {
	public static Set<String> ej3(Tree<String> arbol){
		return ej3reca(arbol, "", new HashSet<>());
	}

	private static Set<String> ej3reca(Tree<String> arbol,String pila,Set<String> res) {
		switch(arbol.getType()) {
		case Empty:
			break;
		case Leaf:
			pila+=arbol.getLabel();
			if(palindroma(pila)) {
				res.add(pila);
			}
			break;
		case Nary:
			for(Tree<String> hijo:arbol.getChildren()) {
				ej3reca(hijo,pila+arbol.getLabel(),res);
			}
		}
		return res;
	}

	private static boolean palindroma(String s) {
		boolean res= true;
		for(int i=0;i<s.length()/2;i++) {
			if(res) {
				res= res && (s.charAt(i)!=s.charAt(-i));
			}
		} 
		return res;
	}
}
