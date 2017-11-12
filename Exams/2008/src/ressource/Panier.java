package ressource;

public class Panier implements Ressource {

	private static int cpt =0;
	private int index;
	
	public Panier() {
		this.index = cpt++;
	}

	@Override
	public String description() {		
		return "panier-"+this.index;
	}
		
}
