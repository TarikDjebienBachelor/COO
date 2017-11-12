package mediatheque.abonnement;

import mediatheque.document.Livre;

public class SelectionneLivreMotTitre extends DocumentSelectionneur {

	private String mot;

	public SelectionneLivreMotTitre(String mot) {
		this.mot = mot;
	}
	
	public boolean acceptLivre(Livre livre) {		
		return livre.getTitre().contains(mot);
	}

}
