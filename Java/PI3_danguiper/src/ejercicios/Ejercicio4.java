package ejercicios;
import java.util.HashSet;
import java.util.Set;

import us.lsi.tiposrecursivos.Tree;

public class Ejercicio4 {
	public static Set<String> ej4REC(Tree<String> arbol){
		return ej4reca(arbol, "", new HashSet<>());
	}

	private static Set<String> ej4reca(Tree<String> arbol,String pila,Set<String> res) {
		switch(arbol.getType()) {
		case Empty:
			break;
		case Leaf:
			String pilaux=pila.concat(arbol.getLabel());
			if(palindroma(pilaux)) {
				res.add(pilaux);
			}
			return res;
		case Nary:
			pilaux=pila.concat(arbol.getLabel());
			for(Tree<String> hijo:arbol.getChildren()) {
				ej4reca(hijo,pilaux,res);
			}
		}return res;
	}
	//falta areglar el metodo
	private static boolean palindroma(String s) {
		boolean res= true;
		for(int i=0;i<s.length()/2;i++) {
			if(res) {
				res= res && (s.charAt(i)==s.charAt(s.length()-(i+1)));
			}
		} 
		return res;
	}
}
