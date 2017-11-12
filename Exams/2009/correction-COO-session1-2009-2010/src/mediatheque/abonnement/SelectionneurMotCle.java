package mediatheque.abonnement;

import mediatheque.document.DocumentRiche;

public class SelectionneurMotCle extends DocumentSelectionneur {

	protected String motCle;

	public SelectionneurMotCle(String motCle) {
		this.motCle = motCle;
	}

	public boolean acceptDocRiche(DocumentRiche doc) {
		return doc.estMotCle(this.motCle);
	}

	public boolean acceptDocTelechargeable(DocumentRiche doc) {
		return false;
	}
}
