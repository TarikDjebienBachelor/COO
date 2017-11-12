package mediatheque.document;

import java.net.URL;

public class DocumentTelechargeable extends DocumentDecorator {

	protected URL url;

	public DocumentTelechargeable(Document doc, URL url) {
		super(doc);
		this.url = url;
	}

	public String toString() {
		return super.toString() + " " + this.url;
	}

	public boolean estEmprunte() {
		return false;
	}

	
}
