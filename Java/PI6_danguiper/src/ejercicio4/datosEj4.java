package ejercicio4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import us.lsi.common.Files2;

public class datosEj4 {
	public static List<Elemento> elementos= new ArrayList<>();
	public static List<Contenedor> contenedores= new ArrayList<>();;
	
	
	public static List<String> hazLista(String[] in){
		List<String> res= new ArrayList<>();
		for (String el : in) {
			res.add(el.trim());
		}
		return res;
		
	}
	
	public static record Elemento(String nombre, Integer tamaño,List<String> tipos) {
		
		public static Elemento create(String s) {
			String[] f= s.split(":");
			String id=f[0].trim();
			f= f[1].split(";");
			Integer tam= Integer.valueOf(f[0].trim());
			List<String> tipos= hazLista(f[1].split(","));
			
			return new Elemento(id,tam,tipos);
		}
				
	}
	
	public static record Contenedor(String nombre,Integer capacidad,String tipo) {
		
		public static Contenedor create(String s) {

			String[] f= s.split(":");
			String id= f[0].trim();
			f=f[1].split(";");
			
			String[]j=f[0].split("=");
			Integer capa= Integer.valueOf(j[1].trim());
			j=f[1].split("=");
			String tipo= j[1].trim();
			return new Contenedor(id,capa,tipo);
		}

	}

	public static int getNumElems() {
		return elementos.size();
	}
	public static int getNumContenedores() {
		return contenedores.size();
	}
	public static Contenedor getContenedor(int memos) {
		return contenedores.get(memos);
	}
	public static Elemento getElemento(int memos) {
		return elementos.get(memos);
	}
	
	//init del ej3
	public static void iniDatos(String fichero) {
		int modo=0;
		List<String> lineas= Files2.streamFromFile(fichero).collect(Collectors.toList());
		lineas= lineas.subList(1, lineas.size());
		for (String l : lineas) {
			if(modo==1) {
				elementos.add(Elemento.create(l));
			}else {
				if(l.contains("//")) {
					modo=1;
				}else {
					contenedores.add(Contenedor.create(l));
				}
			}
		}
		//elementos=elementos.stream().sorted(Comparator.comparing(Elemento::tamaño).reversed()).collect(Collectors.toList());
	}
	
}
