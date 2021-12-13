package ejercicios;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.List2;
import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio3 {
	public static Integer ej3REC(BinaryTree<Integer> arbol) {
		return ej3reca(arbol,new ArrayList<>(), 1);
	}

	private static Integer ej3reca(BinaryTree<Integer> arbol, ArrayList<Integer> lista,int maximo) {
		int mom=1;
		if(!arbol.isEmpty()) {
			if (arbol.isBinary()){
				lista.add(arbol.getLabel());
				if(!arbol.getRight().isEmpty()) {
					ArrayList<Integer>lid= (ArrayList<Integer>) List2.copy(lista);
					mom=ej3reca(arbol.getRight(),lid,maximo);
					if(mom>maximo) {
						maximo= mom;
						
					}
				}
				
				if(!arbol.getLeft().isEmpty()) {
					ArrayList<Integer>lii= (ArrayList<Integer>) List2.copy(lista);
					mom=ej3reca(arbol.getLeft(),lii,maximo);
					if(mom>maximo) {
						maximo= mom;
					}
					
				}
				
				
			}else {//caso hoja
				lista.add(arbol.getLabel());
				if(maximo<calcula(lista)) {
					maximo= calcula(lista);
				}
				return maximo;
			}
		}
		return maximo;
	}
	public record Dupla(int valor, List<Integer> lista) {}
	
	public static Integer calcula(List<Integer> lis) {
		int res=1;
		for( int elem: lis) {
			res*=elem;
		}
		return res;
	}
	
	
}