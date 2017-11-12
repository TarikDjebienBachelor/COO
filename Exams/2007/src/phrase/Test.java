package phrase;

import phrase.dictionnaire.Dictionnaire;
import phrase.mot.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dictionnaire.DICO_DETERMINANT.addMot(new Determinant("le"));
		Dictionnaire.DICO_DETERMINANT.addMot(new Determinant("la"));
		Dictionnaire.DICO_DETERMINANT.addMot(new Determinant("ldu"));

		Dictionnaire.DICO_ADJECTIF.addMot(new Adjectif("petit"));
		Dictionnaire.DICO_ADJECTIF.addMot(new Adjectif("noir"));
		Dictionnaire.DICO_ADJECTIF.addMot(new Adjectif("jaune"));
		Dictionnaire.DICO_ADJECTIF.addMot(new Adjectif("joli"));
		Dictionnaire.DICO_ADJECTIF.addMot(new Adjectif("jolie"));
		
		Dictionnaire.DICO_NOM.addMot(new Nom("chien"));
		Dictionnaire.DICO_NOM.addMot(new Nom("balle"));
		Dictionnaire.DICO_NOM.addMot(new Nom("chat"));
		
		Dictionnaire.DICO_VERBE.addMot(new Verbe("mordre"));
		Dictionnaire.DICO_VERBE.addMot(new Verbe("mord"));
		Dictionnaire.DICO_VERBE.addMot(new Verbe("jouer"));
		
		try {
			Phrase p = Phrase.buildPhrase("le chien jaune mord la balle");
			p.affiche();
		} catch (PhraseMalFormeeException e) {
			e.printStackTrace();
		}
		
		try {
			Phrase p = Phrase.buildPhrase("le petit chien mord la balle jaune");
			p.affiche();
		} catch (PhraseMalFormeeException e) {
			e.printStackTrace();
		}

		try {
			Phrase p = Phrase.buildPhrase("le petit chien noir mord la jolie balle jaune");
			p.affiche();
		} catch (PhraseMalFormeeException e) {
			e.printStackTrace();
		}
		
		try {
			Phrase p = Phrase.buildPhrase("le petite chien mange la petite pomme");
			p.affiche();
		} catch (PhraseMalFormeeException e) {
			e.printStackTrace();
		}
		
	}

}
