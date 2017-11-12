package phrase;

import java.util.StringTokenizer;
import phrase.dictionnaire.Dictionnaire;
import phrase.mot.Verbe;


public class Phrase extends SyntagmeComposite {

	public Phrase(SyntagmeNominal nominal, SyntagmeVerbal verbal) {
		super();
		this.lesSyntagmes.add(nominal);
		this.lesSyntagmes.add(verbal);
	}

	public void affiche() {
		super.affiche();
		System.out.println();
	}
	
	public static Phrase buildPhrase(String texteDePhrase) throws PhraseMalFormeeException {		
		Verbe leVerbe = null;		
		
		StringTokenizer st = new StringTokenizer(texteDePhrase, " ");
		Mot mot;
		boolean encore = st.hasMoreTokens(); 
		while(encore) {
			mot = new Mot(st.nextToken());
			if (Dictionnaire.DICO_VERBE.contient(mot)) {
				leVerbe = new Verbe(mot);
				encore = false;
			} else {
				encore = st.hasMoreTokens();;
			}
		}
		
		if (!st.hasMoreTokens()) {
			throw new PhraseMalFormeeException(); 
		}
		
		int indexVerbe = texteDePhrase.indexOf(leVerbe.toString());
		String texteSNSujet = texteDePhrase.substring(0,indexVerbe).trim();
		String texteSNVerbal = texteDePhrase.substring(indexVerbe+leVerbe.toString().length()).trim();
			
		SyntagmeNominal sujet = SyntagmeNominal.build(texteSNSujet);
		SyntagmeVerbal verbal = new SyntagmeVerbal(leVerbe, SyntagmeNominal.build(texteSNVerbal));
		
		return new Phrase(sujet, verbal);
	}

}
