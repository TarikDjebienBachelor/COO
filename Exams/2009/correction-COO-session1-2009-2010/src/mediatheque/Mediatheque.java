package mediatheque;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import mediatheque.abonnement.DocumentSelectionneur;
import mediatheque.abonnement.SelectionneurCompose;
import mediatheque.abonnement.SelectionneurLivre;
import mediatheque.abonnement.SelectionneurMotCle;
import mediatheque.document.Document;

public class Mediatheque {

	protected Map<Reference, Document> lesDocuments;
	
	public Mediatheque() {
		this.lesDocuments = new HashMap<Reference,Document>();
	}

	public Collection<Document> getLesDocuments() {
		return lesDocuments.values();
	}

	public void affiche(DocumentSelectionneur selectionneur) {
		Collection<Document> lesDocs = selectionneur.selectionne(this.getLesDocuments());
		for(Document d : lesDocs) {
			System.out.println(d);
		}
	}
	
	public void ajouteDocument(Document doc) {
		this.lesDocuments.put(Reference.genereReference(doc), doc);
	}

	public void supprimeDocument(Reference ref) {
		this.lesDocuments.remove(ref);
	}

	
	public Document getDocument(Reference ref) {
		return this.lesDocuments.get(ref);
	}
	
	public void emprunte(Reference ref) throws DejaEmprunteException {
		if (this.lesDocuments.get(ref).estEmprunte()) {
			throw new DejaEmprunteException();
		}
		this.lesDocuments.get(ref).emprunte();
	}
	
	public void retour(Reference ref) {
		this.lesDocuments.get(ref).retourEmprunt();
	}
	
	public static void main(String[] args) {
		Mediatheque med = new Mediatheque();
		// ajout de doc...
		SelectionneurLivre sl = new SelectionneurLivre();
		med.affiche(sl);
		
		SelectionneurMotCle smc = new SelectionneurMotCle("mot1");
		med.affiche(smc);
		
		
		SelectionneurCompose sc = new SelectionneurCompose();
		sc.add(sl);
		sc.add(smc);
		med.affiche(smc);

//		List<String> motcles = new ArrayList<String>();
//		motcles.add("mot1");

	}

}
