package ressource;

public class GestionnaireDeCabines extends GestionnaireRessources<Cabine> {

	public GestionnaireDeCabines(int nbRessources) {
		super(nbRessources);		
	}

	@Override
	protected Cabine createRessource() {
		return new Cabine();
	}

}
