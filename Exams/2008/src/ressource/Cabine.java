package ressource;

public class Cabine implements Ressource {
	private static int cpt =0;
	private int index;
	
	public Cabine() {
		this.index = cpt++;
	}

	@Override
	public String description() {		
		return "cabine-"+this.index;
	}
		
}

