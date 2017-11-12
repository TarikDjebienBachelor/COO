package phrase;

import phrase.mot.Verbe;

public class SyntagmeVerbal extends SyntagmeComposite {

	public SyntagmeVerbal(Verbe verbe, SyntagmeNominal nominal) {
		super();
		this.lesSyntagmes.add(verbe);
		this.lesSyntagmes.add(nominal);
	}


}
