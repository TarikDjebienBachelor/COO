package mediatheque.document;

import mediatheque.Auteur;
import mediatheque.abonnement.DocumentSelectionneur;

public class Musique extends Document {

	protected int duree;
	protected Genre genre;

	public Genre getGenre() {
		return genre;
	}

	public Musique(Auteur auteur, String titre, int duree, Genre genre) {
		super(auteur, titre);
		this.duree = duree;
		this.genre = genre;
	}

	public void consulter() {
		this.ecouter();
	}

	public void ecouter() {
		// bla bla
	}

	public String toString() {
		return super.toString()+" "+this.duree;
	}


	public boolean accept(DocumentSelectionneur selectionneur) {
		return selectionneur.acceptMusique(this);
	}
}
