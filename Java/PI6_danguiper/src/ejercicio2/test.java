package ejercicio2;

import ejercicio2.datosEj2.TipoCandidato;

public class test {

	public static void main(String[] args) {

		datosEj2.iniDatos("./fichero/PI6Ej2DatosEntrada1.txt");
		
		TipoCandidato p= datosEj2.candidatos.get(0);
		System.out.println(p);
		System.out.println(p.incompatibilidad().size()+"  "+p.incompatibilidad());

	}

}
