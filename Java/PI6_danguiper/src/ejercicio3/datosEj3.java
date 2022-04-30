package ejercicio3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import us.lsi.common.Files2;

public class datosEj3{
	public static Map<String,DuplaComponente> componentes= new HashMap<>();
	public static List<TipoProducto> productos=new ArrayList<>();
	public static int TiempoMaxProd,TiempoMaxManual;
		
	public static TipoProducto getProducto(int i) {
		return productos.get(i);		
	}
	
	public static List<dupla> ComponentesNecesarios(int indice){
		return productos.get(indice).componentes;
	}
	
	public static DuplaComponente getTiempos(String idCom) {
		return componentes.get(idCom);
	}
	
	public record TipoComponente(String nombreComp, int Tprod, int Telab) {
		public static TipoComponente create(String s) {
			String[] f= s.split(":");
			String[] nums= f[1].split("=");
			String[] num1= nums[1].split(";");
			return new TipoComponente(f[0].trim(),
					Integer.valueOf(num1[0].trim()),
					Integer.valueOf(nums[2].replace(";", "").trim()));
		}
			
			
	}

	public record TipoProducto(String id, double precio, List<dupla> componentes, int maxUnidades) {
		
		public static TipoProducto create(String s) {
			String[] j= s.split("->");
			String id=j[0].trim();
			j=j[1].split(";");
			double precio= Double.valueOf(j[0].replace("precio=", "").trim());
			int maxUnidades= Integer.valueOf(j[2].replace("max_u=", "").trim());
			
			j=j[1].split("=");
			j=j[1].split(",");
			
			List<dupla> componentes= hazLizta(j);
			
			return new TipoProducto(id, precio, componentes, maxUnidades);
			
		}
	}
	public record dupla(String nombreComp,int cantidad) {}
	public record DuplaComponente(int prod,int manual) {}
	
	
	//-------
	public static List<dupla> hazLizta(String[] in){
		List<dupla> res= new ArrayList<>();
		for (String el : in) {
			el=el.replace("(", "");
			el=el.replace(")", "");
			String[] j= el.split(":");			
			res.add(new dupla(j[0].trim(),Integer.valueOf(j[1].trim())));
		}
		return res;
		
	}
	
	private static void TotalProd(String line) {
		String[] p= line.split("=");
		TiempoMaxProd=Integer.valueOf(p[1].trim());
		
	}
	
	private static void TotalMan(String l) {
		String[] p= l.split("=");
		TiempoMaxManual= Integer.valueOf(p[1].trim());
	}
	
	public static void iniDatos(String fichero) {
		List<String> lineas= Files2.streamFromFile(fichero).collect(Collectors.toList());
		TotalProd(lineas.get(0));
		TotalMan(lineas.get(1));
		lineas=lineas.subList(3, lineas.size());
		int modo=0; //0 = componente 1=producto
		
		for (String l : lineas) {
			if(modo==1) {
				productos.add(TipoProducto.create(l));
			}else {
				if(l.contains("//")) {
					modo=1;
				}else {
					TipoComponente com= TipoComponente.create(l);
					componentes.put(com.nombreComp(), new DuplaComponente(com.Tprod, com.Telab));
				}
			}
		}
		
	}
	
	public static Integer getProducots() {
		return productos.size();
	}

	public static Integer getMaxProductos() {
		return productos.stream().map(t->t.maxUnidades).reduce(0,Integer::sum);
	}

	
	
}
