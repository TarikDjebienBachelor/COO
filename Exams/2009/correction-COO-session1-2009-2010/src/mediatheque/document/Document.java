package mediatheque.document;

import mediatheque.Auteur;
import mediatheque.abonnement.DocumentSelectionneur;

/**
 * @author  jc
 */
public abstract class Document {

	protected Auteur auteur;
	protected String titre;
	protected boolean estEmprunte;
	
	public Document(Auteur auteur, String titre) {
		this.auteur = auteur;
		this.titre = titre;
		this.estEmprunte = false;
	}

	public Auteur getAuteur() {
		return this.auteur;
	}

	public String getTitre() {
		return titre;
	}
	
	public String toString() {
		return this.auteur+" "+this.titre+" "+this.estEmprunte;
	}

	public boolean estEmprunte() { 
		return this.estEmprunte;
	}

	public void emprunte() {
		this.estEmprunte = true;	
	}
	public void retourEmprunt() {
		this.estEmprunte = false;
	}
	
	public abstract void consulter();	
	
	public abstract boolean accept(DocumentSelectionneur selectionneur);


}
