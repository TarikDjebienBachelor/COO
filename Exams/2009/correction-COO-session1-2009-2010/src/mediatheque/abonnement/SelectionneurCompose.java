package mediatheque.abonnement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import mediatheque.document.Document;

public class SelectionneurCompose extends DocumentSelectionneur {
	protected List<DocumentSelectionneur> lesSelectionneurs;

	public SelectionneurCompose() {
		this.lesSelectionneurs = new ArrayList<DocumentSelectionneur>();
	}
	
	public void add(DocumentSelectionneur select) {
		this.lesSelectionneurs.add(select);
	}

	@Override
	public Collection<Document> selectionne(Collection<? extends Document> documents) {
		Set<Document> result = new HashSet<Document>();
		for (Document doc : documents) {
			boolean accept = false; 
			Iterator<DocumentSelectionneur> it = this.lesSelectionneurs.iterator();
			while (!accept && it.hasNext()) {
				accept = accept || doc.accept(it.next());
			}
			if (accept) {
				result.add(doc);
			}
		}
		return result;
	}
	

}
