package ejercicios;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.nio.Attribute;
import org.jgrapht.nio.DefaultAttribute;

import elementos_aux.Alumno;
import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.colors.GraphColors.Shape;
import us.lsi.colors.GraphColors.Style;
import us.lsi.common.Files2;
import us.lsi.common.Pair;

public class Ejercicio4 {

	public static  Map<String, Attribute> POSITIVOS = Map.of("style", DefaultAttribute.createAttribute(
			Style.filled.toString()),
			"shape", DefaultAttribute.createAttribute(Shape.ellipse.toString()),
			"color", DefaultAttribute.createAttribute(Color.red.toString()));
	
	public static  Map<String, Attribute> CONTAGIADOS = Map.of("style", DefaultAttribute.createAttribute(
			Style.filled.toString()),
			"shape", DefaultAttribute.createAttribute(Shape.ellipse.toString()),
			"color", DefaultAttribute.createAttribute(Color.orange.toString()));
	
	public static  Map<String, Attribute> NEGATIVOS = Map.of("style", DefaultAttribute.createAttribute(
			Style.filled.toString()),
			"shape", DefaultAttribute.createAttribute(Shape.ellipse.toString()),
			"color", DefaultAttribute.createAttribute(Color.green.toString()));
	
//-------------------------------
	/*public static SimpleWeightedGraph<Alumno, DefaultWeightedEdge> construirGrafo(List<String> lista) {
		 SimpleWeightedGraph<Alumno, DefaultWeightedEdge> gf = 
				new SimpleWeightedGraph<Alumno, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		for(int i = 4; i<=lista.size()-1; i++) {
			String alum = lista.get(i);
			gf.addVertex(Alumno.ofFormat(alum.split("/")));
		}
		
		Set<Alumno> vertices= gf.vertexSet();
		for(Alumno a:vertices) {
			
			for(Alumno b:vertices) {
				
				Double dist=0.0;
				
				if(vecino(a,b).first()==true) {
					
					
					if(vecino(a,b).second()=="v") {
						dist=Double.valueOf(lista.get(2));
					}else {
						DecimalFormat df = new DecimalFormat("#.##");
						Double raiz= Math.sqrt(
								Math.pow(Double.valueOf(lista.get(2)), 2) +
								Math.pow(Double.valueOf(lista.get(3)), 2));
						
						dist=Double.valueOf(df.format(raiz).replace(",", "."));
					}
					if (dist<1.2) {
						gf.addEdge(a, b);
						gf.setEdgeWeight(a,b,dist);}
					if((a.getCovid()==true||Contagios.contains(a))&&dist<1.2) {
						Contagios.add(b);
					}else if((b.getCovid()==true||Contagios.contains(b))&&dist<1.2) {
						Contagios.add(a);
					}
				}
			}
		}
		return gf;
		
	}*/
	//------------------------------------------------------------------------------------------------------------------
	public static List<String> lecturaFichero(String n) {
		
		Function<String, String> parseo = x -> {
			return String.format("%s/%s/%s", 
					x.charAt(0),// +-
					x.charAt(1),//fila
					x.charAt(3));//colum
		};
		
		List<String> datos = Files2.streamFromFile("./ficheros/PI4E4_DatosEntrada"+ n + ".txt")
		.filter(x -> !x.startsWith("#"))
		.map(x -> (x.contains("=") ? x.split("=")[1] : x)) 
		.map(x -> (x.startsWith("+") || x.startsWith("-") ? parseo.apply(x) : x))
		.toList();
		
		//System.out.println(datos);  <-Debug
		return datos;
	}

	public static List<Alumno> Contagios=new ArrayList<>();
	public static SimpleWeightedGraph<Alumno, DefaultWeightedEdge> construirGrafo(List<String> lista) {
		 SimpleWeightedGraph<Alumno, DefaultWeightedEdge> gf = 
				new SimpleWeightedGraph<Alumno, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		for(int i = 4; i<=lista.size()-1; i++) {
			String alum = lista.get(i);
			gf.addVertex(Alumno.ofFormat(alum.split("/")));
		}
		
		Set<Alumno> vertices= gf.vertexSet();
		for(Alumno a:vertices) {
			
			for(Alumno b:vertices) {
				
				Double dist=0.0;
				
				if(vecino(a,b).first()==true) {
					
					
					if(vecino(a,b).second()=="v") {
						dist=Double.valueOf(lista.get(2));
					}else {
						DecimalFormat df = new DecimalFormat("#.##");
						Double raiz= Math.sqrt(
								Math.pow(Double.valueOf(lista.get(2)), 2) +
								Math.pow(Double.valueOf(lista.get(3)), 2));
						
						dist=Double.valueOf(df.format(raiz).replace(",", "."));
					}
					if (dist<1.2) {
						gf.addEdge(a, b);
						gf.setEdgeWeight(a,b,dist);}
					if((a.getCovid()==true||Contagios.contains(a))&&dist<1.2) {
						Contagios.add(b);
					}else if((b.getCovid()==true||Contagios.contains(b))&&dist<1.2) {
						Contagios.add(a);
					}
				}
			}
		}
		return gf;
		
	}
		
		 
	public static Pair<Boolean,String> vecino(Alumno a,Alumno b) {
		boolean pr=false;
		String di="";
		Integer fA = a.getFila();
		Integer cA = a.getColumna();
		Integer fB = b.getFila();
		Integer cB = b.getColumna();
		
		if(fA==fB || cA==cB) { 
			if(fA==fB+1 || fA==fB-1 || cA==cB+1 || cA==cB-1) {
				pr=true;
				di="v"; 
			}
		}else if((fA==fB-1 && cA==cB-1) ||
				 (fA==fB-1 && cA==cB+1) ||
				 (fA==fB+1 && cA==cB-1) ||
				 (fA==fB+1 && cA==cB+1)){ 
			pr=true;
			di="d";
			
		}
		return  Pair.of(pr,di);
	}

	
	//fichero 1
		public static void salida(SimpleWeightedGraph<Alumno, DefaultWeightedEdge> g,Integer n ) {
		List<Alumno> Posi = g.vertexSet().stream().filter(x -> x.getCovid()==true).toList();
	
		GraphColors.toDot(g, "./ficheros/Ejercicio4A_entrada"+n+".gv",
				Alumno::toString,
				c -> g.getEdgeWeight(c)+"0",
				v -> GraphColors.all((Posi.contains(v) ? POSITIVOS : 
					(Contagios.contains(v) ? CONTAGIADOS : NEGATIVOS))),
				e -> GraphColors.color(Color.blue));
	}

	//fichero 2 



}
