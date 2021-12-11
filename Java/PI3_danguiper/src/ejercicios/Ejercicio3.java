package ejercicios;

import java.util.ArrayList;
import java.util.List;
import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.parsers.ProgramParser.CallExprContext;

public class Ejercicio3 {
	public static Integer ej3Rec(BinaryTree<Integer> arbol) {
		return ej3reca(arbol,new ArrayList<>(), 0);
	}

	private static Integer ej3reca(BinaryTree<Integer> arbol, ArrayList<Integer> lista,int maximo) {
		switch(arbol.getType()) {
		case Empty:
			lista.add(0);
			maximo=calcula(lista);
		case Leaf:
			lista.add(arbol.getLabel());
			int prod= calcula(lista);
			if (prod> maximo){
				maximo=prod;
			}
			
		case Binary:
			lista.add(arbol.getLabel());
			ej3reca(arbol.getRight(),lista,maximo);
			ej3reca(arbol.getLeft(),lista,maximo);
			//ej3reca(arbol.getRight(),lista,ej3reca(arbol.getLeft(),lista,maximo));
		}
		return maximo;
	}
	
	public static Integer calcula(List<Integer> lis) {
		int res=0;
		for( int elem: lis) {
			res+=elem;
		}
		return res;
	}
	
	
}
