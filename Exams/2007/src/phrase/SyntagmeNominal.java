package phrase;

import java.util.StringTokenizer;

import phrase.mot.Adjectif;
import phrase.mot.Determinant;
import phrase.mot.Nom;
import phrase.dictionnaire.Dictionnaire;

public class SyntagmeNominal extends SyntagmeComposite {

	public SyntagmeNominal(Determinant d, ListeAdjectifs listAdjAvant, Nom nom, ListeAdjectifs listAdjApres) {
		super();
		this.lesSyntagmes.add(d);
		this.lesSyntagmes.add(listAdjAvant);
		this.lesSyntagmes.add(nom);
		this.lesSyntagmes.add(listAdjApres);
	}

	public static SyntagmeNominal build(String texte) throws PhraseMalFormeeException {

		StringTokenizer st = new StringTokenizer(texte, " ");
		Mot mot;
		ListeAdjectifs listAdjAvant = new ListeAdjectifs();
		ListeAdjectifs listAdjApres = new ListeAdjectifs();
		Nom nom = null;
		Determinant det = null;

		if (st.hasMoreTokens()) {
			mot = new Mot(st.nextToken());
			if (Dictionnaire.DICO_DETERMINANT.contient(mot)) {
				det = new Determinant(mot);
			}
		} else {
			throw new PhraseMalFormeeException();
		}

		boolean encore = st.hasMoreTokens();
		while (encore) {
			mot = new Mot(st.nextToken());
			if (Dictionnaire.DICO_ADJECTIF.contient(mot)) {
				listAdjAvant.addAdjectif(new Adjectif(mot));
				encore = st.hasMoreTokens();
			} else {
				if (Dictionnaire.DICO_NOM.contient(mot)) {
					encore = false;
					nom = new Nom(mot);
				} else {
					throw new PhraseMalFormeeException();
				}
			}
		}

		encore = st.hasMoreTokens();
		while (encore) {
			mot = new Mot(st.nextToken());
			if (Dictionnaire.DICO_ADJECTIF.contient(mot)) {
				listAdjApres.addAdjectif(new Adjectif(mot));
				encore = st.hasMoreTokens();
			} else {
				throw new PhraseMalFormeeException();
			}
		}
		
		return new SyntagmeNominal(det, listAdjAvant, nom, listAdjApres);
	}

}
