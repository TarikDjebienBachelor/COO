package mediatheque.document;

import mediatheque.Auteur;
import mediatheque.abonnement.DocumentSelectionneur;

public class Livre extends Document {

	protected int nbPages;
	protected final String isbn;

	public Livre(Auteur auteur, String titre, String isbn) {
		super(auteur, titre);
		this.isbn = isbn;
	}

	public void consulter() {
		this.lire();
	}

	public void lire() {
		// bla bla
	}

	public String toString() {
		return super.toString() + " " + this.nbPages + " " + this.isbn;
	}

	public boolean accept(DocumentSelectionneur selectionneur) {
		return selectionneur.acceptLivre(this);
	}
}
