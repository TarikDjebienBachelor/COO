package phrase.mot;

import phrase.Mot;

public class Nom extends Mot {

	public Nom(String mot) {
		super(mot);	
	}
	public Nom(Mot mot) {
		super(mot.toString());	
	}
}
