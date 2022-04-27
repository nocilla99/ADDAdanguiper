package practs;

import java.util.List;
import us.lsi.common.Files2;
import us.lsi.common.List2;

public class datosprob3 {
	public static List<Alumno> alumnos;
	
	public static record Alumno(String nombre,List<Integer> afinidades) {
		public static Alumno create(String s) {
			//parsear
			String[] j= s.split(":");
			
			return new Alumno(j[0],List2.parse(j[1].trim().split(","), Integer::parseInt));
		}
		public int getAfinidad(int indice) {
			return afinidades.get(indice);
		}
		
	}
	
	public static Integer getNumGrupos() {
		return alumnos.get(0).afinidades.size();
	}

	public static int getNumAlumnos() {
		return alumnos.size();
	}
	
	public static int getTamGrupo() {
		return getNumAlumnos()/getNumGrupos();
	}

	public static Alumno getAlumno(int i) {
		return alumnos.get(i);
	}

	public static Integer getAfinidad(int indice, Integer action) {
		return alumnos.get(indice).getAfinidad(action);
	}
	
	public static void iniDatos(String fichero) {
		alumnos=Files2.streamFromFile(fichero).map(Alumno::create).toList();
	}
	
}
