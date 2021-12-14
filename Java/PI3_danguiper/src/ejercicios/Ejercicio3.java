package ejercicios;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.List2;
import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio3 {
	public static Dupla ej3REC(BinaryTree<Integer> arbol) {
		return ej3reca(arbol,new ArrayList<>(), 1,new ArrayList<>());
	}

	private static Dupla ej3reca(BinaryTree<Integer> arbol, ArrayList<Integer> lista,int maximo,ArrayList<Integer> defi) {
		Dupla mom=new Dupla(0,null);
		ArrayList<Integer> lismom= new ArrayList<>();
		if(!arbol.isEmpty()) {
			if (arbol.isBinary()){
				lista.add(arbol.getLabel());
				
				if(!arbol.getRight().isEmpty()) {//rama derecha no vacia
					ArrayList<Integer>lid= (ArrayList<Integer>) List2.copy(lista);
					mom=ej3reca(arbol.getRight(),lid,maximo,defi);
					if(mom.valor>maximo) {
						maximo= mom.valor;
						lismom= mom.lista;
					}
				}
				
				if(!arbol.getLeft().isEmpty()) {//rama izda no vacia
					ArrayList<Integer>lii= (ArrayList<Integer>) List2.copy(lista);
					mom=ej3reca(arbol.getLeft(),lii,maximo,defi);
					if(mom.valor>maximo) {
						maximo= mom.valor;
						lismom=mom.lista;
					}
					
				}
				
				
			}else {//caso hoja
				lista.add(arbol.getLabel());
				if(maximo<calcula(lista)) {
					maximo= calcula(lista);
					lismom=lista;
				}
				Dupla d= new Dupla(maximo,lismom);
				return d;
			}
		}
		return new Dupla(maximo,lismom);
	}
	public record Dupla(int valor, ArrayList<Integer> lista) {}
	
	public static Integer calcula(List<Integer> lis) {
		int res=1;
		for( int elem: lis) {
			res*=elem;
		}
		return res;
	}
	
	
}