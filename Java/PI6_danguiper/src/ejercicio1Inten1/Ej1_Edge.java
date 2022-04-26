package ejercicio1Inten1;

import us.lsi.graphs.virtual.SimpleEdgeAction;

public record Ej1_Edge(Ej1_Vertex Src, Ej1_Vertex Dst, Integer peso, Ej1_Action accion) implements SimpleEdgeAction<Ej1_Vertex,Ej1_Action>{

	@Override
	public Ej1_Vertex source() {
		return this.Src;
	}

	@Override
	public Ej1_Vertex target() {
		return this.Dst;
	}

	@Override
	public Double weight() {
		return Double.valueOf(this.peso);
	}

	@Override
	public Ej1_Action action() {
		return this.accion;
	}

}
