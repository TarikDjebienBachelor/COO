package mediatheque.abonnement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mediatheque.document.Document;
import mediatheque.document.DocumentRiche;
import mediatheque.document.Livre;
import mediatheque.document.Musique;


public abstract class DocumentSelectionneur  {

	public Collection<Document> selectionne(Collection<? extends Document> documents) {
		List<Document> result = new ArrayList<Document>();
		for (Document doc : documents) {
			if (this.estAccessible(doc)) {
				result.add(doc);
			}
		}
		return result;
	}

	public boolean estAccessible(Document doc) {
		return doc.accept(this);
	}

	public boolean acceptLivre(Livre livre) {
		return true;
	}

	public boolean acceptMusique(Musique musique) {
		return true;
	}

	public boolean acceptDocRiche(DocumentRiche doc) {
		return true;
	}
	
	public boolean acceptDocTelechargeable(DocumentRiche doc) {
		return true;
	}
}
