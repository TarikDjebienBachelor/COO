package ressource;

public class GestionnaireDePaniers extends GestionnaireRessources<Panier> {

	public GestionnaireDePaniers(int nbRessources) {
		super(nbRessources);		
	}

	@Override
	protected Panier createRessource() {
		return new Panier();
	}

}
