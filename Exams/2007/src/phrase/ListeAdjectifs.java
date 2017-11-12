package phrase;

import phrase.mot.Adjectif;

public class ListeAdjectifs extends SyntagmeComposite {


	public ListeAdjectifs() {
		super();
	}
	
	public void addAdjectif(Adjectif adjectif) {
		this.lesSyntagmes.add(adjectif);
	}


}
