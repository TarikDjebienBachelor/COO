package mediatheque.abonnement;

import mediatheque.document.DocumentRiche;
import mediatheque.document.Musique;

public class SelectionneurLivre extends DocumentSelectionneur {


	public boolean acceptMusique(Musique musique) {
		return false;
	}

	public boolean acceptDocRiche(DocumentRiche doc) {
		return false;
	}
	
	public boolean acceptDocTelechargeable(DocumentRiche doc) {
		return false;
	}
}
