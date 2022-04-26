package ejercicio1Inten1;

import us.lsi.common.IntPair;
import us.lsi.graphs.virtual.Action;

public record Ej1_Action(String name,IntPair SrcDest) implements Action<Ej1_Vertex>{

	@Override
	public Ej1_Vertex neighbor(Ej1_Vertex v) {
		return v.neighbor(this);
	}

	@Override
	public boolean isApplicable(Ej1_Vertex v) {
		return v.isValid();
	}

	@Override
	public String name() {
		return this.name;
	}

}
