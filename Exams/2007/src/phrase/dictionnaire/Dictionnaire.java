package phrase.dictionnaire;

import java.util.HashSet;
import java.util.Iterator;

import phrase.Mot;
import phrase.mot.Adjectif;
import phrase.mot.Determinant;
import phrase.mot.Nom;
import phrase.mot.Verbe;

public class Dictionnaire<T extends Mot> implements Iterable<T> {
	
	public static final Dictionnaire<Determinant> DICO_DETERMINANT = new Dictionnaire<Determinant>();
	public static final Dictionnaire<Adjectif> DICO_ADJECTIF = new Dictionnaire<Adjectif>();
	public static final Dictionnaire<Verbe> DICO_VERBE = new Dictionnaire<Verbe>();
	public static final Dictionnaire<Nom> DICO_NOM = new Dictionnaire<Nom>();
	
	
	protected HashSet<T> lesMots;
	
	protected Dictionnaire() {
		this.lesMots = new HashSet<T>();
	}
	
	public boolean contient(Mot leMot) {
		for(Mot m : this.lesMots) {
			if (m.equals(leMot))  {
				return true;
			}
		}
		return false;
	}

	public void addMot(T leMot) {
		this.lesMots.add(leMot);
	}
	
	public boolean removeMot(T leMot) {
		return this.lesMots.remove(leMot);
	}
	
	public Iterator<T> iterator() {
		return this.lesMots.iterator();
	}
}
