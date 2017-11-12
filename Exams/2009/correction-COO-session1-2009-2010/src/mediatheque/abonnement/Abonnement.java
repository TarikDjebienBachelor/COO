package mediatheque.abonnement;

import java.util.Collection;

import mediatheque.DejaEmprunteException;
import mediatheque.Mediatheque;
import mediatheque.Reference;
import mediatheque.document.Document;

public class Abonnement {

	protected Mediatheque mediatheque;
	protected DocumentSelectionneur selectionneur;
	
	/** construit un abonnement
	 * @param mediatheque la médiathèque pour laquelle cet abonnement est actif
	 * @param selectionneur le sélectionneur qui permet de filtrer les documents de la médiathèque 
	 * accessibles pour cet abonnement
	 */
	public Abonnement(Mediatheque mediatheque, DocumentSelectionneur selectionneur) {
		this.mediatheque = mediatheque;
		this.selectionneur = selectionneur;
	}

	public Mediatheque getMediatheque() {
		return mediatheque;
	}

	/** fournit les documents de la mediathèque accessibles pour cet abonnement 
	 * @return les documents accessibles
	 */
	public Collection<Document> documentsAccessibles() {
		return this.selectionneur.selectionne(this.mediatheque.getLesDocuments());
	}
	
	/** permet l'emprunt d'un document par cet abonnement
	 * @param ref la réference du document à emprunter
	 * @throws DocumentHorsAbonnementException si le document n'est pas accessible pour cet abonnement
	 * @throws DejaEmprunteException si le document est déjà emprunté
	 */
	public void emprunte(Reference ref) throws DocumentHorsAbonnementException, DejaEmprunteException {
		Document doc = this.mediatheque.getDocument(ref);
		if (! this.selectionneur.estAccessible(doc)) {
			throw new DocumentHorsAbonnementException(doc);
		}		
		this.mediatheque.emprunte(ref); // leve une exception : DejaEmprunteException
	}

}
