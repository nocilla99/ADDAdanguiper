package ejercicios;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import us.lsi.tiposrecursivos.Tree;

public class Ejercicio1 {
	

	public static <E> Set<E> ej1REC(Tree<E> arbol , Predicate<E> pred){
		return ej1rec(arbol,pred,new HashSet<E>());
	}
	public static <E> Set<E> ej1rec(Tree<E> arbol , Predicate<E> pred, Set<E> res ){
		switch(arbol.getType()){
		case Empty:
			break;
		case Leaf:
			E etiqueta = arbol.getLabel();
			if(pred.test(etiqueta)) { res.add(etiqueta);};
			break;
		case Nary:
			arbol.getChildren().forEach(sub->ej1rec(sub,pred,res));
			break;
		}
		return res;
		
	}
	
	public static <E> Set<E> ej1Fun(Tree<E> arbol, Predicate<E> pred){
		return  arbol.stream().filter(h-> h.isLeaf() && pred.test(h.getLabel()))
				.map(t-> t.getLabel()).collect(Collectors.toSet());
	}
}
