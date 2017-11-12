package mediatheque;

import java.util.Date;

public class Personne implements Auteur {

	private static final int PAS_MORT = -1;

	protected String nom;
	protected int naissance;
	protected int deces;

	public Personne(String nom, int naissance, int deces) {
		// ...
	}

	public String toString() {
		String result = this.nom + " né en " + this.naissance;
		if (deces != PAS_MORT) {
			result = result + " décédé en " + this.deces;
		}
		return result+" ";
	}
}
