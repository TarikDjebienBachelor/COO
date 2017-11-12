package mediatheque.document;

import mediatheque.Auteur;
import mediatheque.abonnement.DocumentSelectionneur;


public abstract class DocumentDecorator extends Document {

	protected Document document;

	public DocumentDecorator(Document doc) {
		super(doc.getAuteur(), doc.getTitre());
		this.document = doc;
	}

	public String toString() {
		return document.toString();
	}

	
	public void emprunte() {
		this.document.emprunte();
	}

	public boolean estEmprunte() {
		return this.document.estEmprunte();
	}

	public Auteur getAuteur() {
		return this.document.getAuteur();
	}

	public String getTitre() {		
		return this.document.getTitre();
	}

	public void retourEmprunt() {		
		this.document.retourEmprunt();
	}

	public void consulter() {
		this.document.consulter();		
	}

	public boolean accept(DocumentSelectionneur selectionneur) {
		return this.document.accept(selectionneur);
	}
}
