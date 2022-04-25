package ejercicio1;

public class Tipo_memoria {
	private int capacidad,tamMax;

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getTamMax() {
		return tamMax;
	}

	public void setTamMax(int tamMax) {
		this.tamMax = tamMax;
	}

	public Tipo_memoria(int capacidad, int tamMax) {
		this.capacidad = capacidad;
		this.tamMax = tamMax;
	}
	public Tipo_memoria() {
	}
	
}
