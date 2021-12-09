package practicas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.Tree;
import us.lsi.tiposrecursivos.Tree.TreeLevel;

public class Ejemplo3 {
	
	
	/*String ruta= "./fichero/entrada.txt";
	List<Tree<Integer>> input =Files2.streamFromFile(ruta).map(linea->linea).collect.Collectors.toList());
	Predicate<Integer> predicado = n-> n%2==0 ;
	
	input.stream().forEach(a-> {
				system.out.println(a,predicado);
				system.out.println(a,predicado,0,new ArrayList<Boolean>()
	});
	*/
	
	public static <E> List<Boolean> sol_rec(Tree<E> arbol,Predicate<E> esPar, int nivel,List<Boolean> res){
		
		switch(arbol.getType()) {
			case Empty:
				if(nivel==res.size()) { //primera vez q se explora el nivel?
					res.add(true);
				}else if(res.get(nivel)) { //ese nivel se esta explorando
					res.set(nivel, true);
				}//si hay un false no nos merece la pena hacer nada poque sabemos q ese nivel no cumple una condicion
				break;
			case Leaf:
				Boolean solucion= esPar.test(arbol.getLabel());
				if(nivel==res.size()) { //primera vez q se explora el nivel?
					res.add(solucion);
				}else if(res.get(nivel)) { //ese nivel se esta explorando
					res.set(nivel, solucion);
				}
				 break;	
			case Nary:
				Boolean solucion2= esPar.test(arbol.getLabel());
				if(nivel==res.size()) { //primera vez q se explora el nivel?
					res.add(solucion2);
				}else if(res.get(nivel)) { //ese nivel se esta explorando
					res.set(nivel, solucion2);
				}
				arbol.getChildren().forEach(
						subarbol -> sol_rec(subarbol,esPar,nivel+1,res));
				break;
			
		}
		return res;
	}
	
	public static <E> List<Boolean> sol_ite(Tree<E> arbol,Predicate<E> esPar){
		List<Boolean> res= new ArrayList<>();
		
		Iterator<TreeLevel<E>> iterador= arbol.byLevel();
		
		while(iterador.hasNext()) {
			
			TreeLevel<E> subarbol= iterador.next();
			
			 if((res.size()==subarbol.level())) {
					 if(subarbol.tree().isEmpty()){
						 res.add(true);
					 }
					 
					res.add(esPar.test(subarbol.tree().getLabel()));
				
			}else if(res.get(subarbol.level())) {
					
					 if(subarbol.tree().isEmpty()){
						 continue;
					 }else {
						 res.set(subarbol.level(), esPar.test(subarbol.tree().getLabel()));
					 }
			}
		}
		return res;
	}
/*
 * 3(2,5)
 * 10(4,6)
 * 10(4,6(2,5))
 * 10(4,6(14,5(2,3)))
 * 10(4(2,15),6(22,5(2,3)))
 * 4(2,5)
 * 3(2(7,_),20(5,8))
 * 10(2(8,4(10,_)),3(5(7,9),6(5,_)))
 */ 
 }
 