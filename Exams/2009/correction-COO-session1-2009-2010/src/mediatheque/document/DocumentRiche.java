package mediatheque.document;

import java.util.List;

import mediatheque.abonnement.DocumentSelectionneur;

public class DocumentRiche extends DocumentDecorator {

	protected List<String> motsCles;

	public DocumentRiche(Document doc, List<String> motsCles) {
		super(doc);
		this.motsCles = motsCles;
	}

	public boolean estMotCle(String mot) {
		return this.motsCles.contains(mot);
	}
	
	public boolean accept(DocumentSelectionneur selectionneur) {		
		return super.accept(selectionneur) && selectionneur.acceptDocRiche(this);
	}

	public String toString() {
		return super.toString()+" "+this.motsCles; // bon faut itérer sur les mot-clés normalement...
	}

	public boolean equals(Object o) {
		// TODO 
		return false;
	}

	public int hashCode() {
		// TODO 
		return 0;
	}



}
