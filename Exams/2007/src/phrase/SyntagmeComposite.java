package phrase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class SyntagmeComposite implements Syntagme, Iterable<Syntagme>  {

	protected List<Syntagme> lesSyntagmes;
	
	protected SyntagmeComposite() {
		this.lesSyntagmes = new ArrayList<Syntagme>();
	}
	
		
	public Iterator<Syntagme> iterator() {
		return this.lesSyntagmes.iterator();
	}

	
	public void affiche() {		
		for (Iterator<Syntagme> it_syntagme = this.lesSyntagmes.iterator();  it_syntagme.hasNext();) {
			it_syntagme.next().affiche();
			if (it_syntagme.hasNext()) {
				System.out.print(" ");
			}
		}
	}

}
