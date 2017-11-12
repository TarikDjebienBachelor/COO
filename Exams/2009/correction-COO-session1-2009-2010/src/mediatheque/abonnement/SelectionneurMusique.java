package mediatheque.abonnement;

import mediatheque.document.DocumentRiche;
import mediatheque.document.Livre;

public class SelectionneurMusique extends DocumentSelectionneur {


	public boolean acceptLivre(Livre lvre) {
		return false;
	}

	public boolean acceptDocRiche(DocumentRiche doc) {
		return false;
	}
	
	public boolean acceptDocTelechargeable(DocumentRiche doc) {
		return false;
	}
}
