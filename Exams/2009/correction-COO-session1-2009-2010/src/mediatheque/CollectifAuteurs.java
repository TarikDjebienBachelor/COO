package mediatheque;

import java.util.List;

public class CollectifAuteurs implements Auteur {

	protected List<Auteur> lesAuteurs;
	
	public String toString() {
		String result = "";
		for(Auteur auteur : lesAuteurs) {
			result = result + "\n"+auteur.toString();
		}
		return result;
	}

	public void add(Auteur a) {
		this.lesAuteurs.add(a);
	}
}
