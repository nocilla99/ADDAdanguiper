package datos;

import java.util.List;
import us.lsi.common.Files2;

public class datosEj1 {
	
	public static List<Archivo> archivos;
	
	public static record Archivo(String nombre, Integer peso) {
		
		public static Archivo create(String s) {
			String[] f= s.split(":");
			
			return new Archivo(f[0].trim(), Integer.valueOf(f[1].trim()));
		}
		
		public String getNombre() {
			return nombre;
		}
		
		public Integer getPeso() {
			return peso;
		}		
	}
		
	public static List<Memoria> memorias;
	
	public static record Memoria(String nombre,Integer capacidad,Integer tam_max) {
		
		public static Memoria create(String s) {
			String[] f= s.split(":");
			//MEM1:                         capacidad=80; tam_max=15;
			String[] nums= f[1].split("=");
			//capacidad	 	80; tam_max		15;
			String[] num1= nums[1].split(";");
			
			//80 		 tam_max
			
			return new Memoria(f[0].trim(),
					Integer.valueOf(num1[0].trim()),
					Integer.valueOf(nums[2].replace(";", "").trim()));
		}
		
		public int getCapacidad() {
			return capacidad;
		}

		public int getTamMax() {
			return tam_max;
		}
		
		public String getNombre() {
			return nombre;
		}

	}


	public static List<Archivo> getArchivos() {
		return archivos;
	}
	public static List<Memoria> getMemorias() {
		return memorias;
	}
	
	public static Integer getNumArchivos() {
		return archivos.size();
	}
	public static Integer getNumMemorias() {
		return memorias.size();
	}
	
	public static Archivo getArchivo(int i) {
		return archivos.get(i);
	}
	public static Memoria getMemoria(int i) {
		return memorias.get(i);
	}
	
	
	public static void iniDatos(String fichero) {
		
		
		archivos=Files2.streamFromFile(fichero).filter(l->!(l.contains("/")||l.contains(";"))).map(Archivo::create).toList();	
		memorias=Files2.streamFromFile(fichero).filter(l->(!l.contains("/")&&l.contains(";"))).map(Memoria::create).toList();
		//System.out.println("FICHEROS \n"+archivos+"\n MEMORIA\n"+memorias);
	}	
}
