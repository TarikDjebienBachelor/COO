package introihm;

/**
 * ModularCounter.java
 * 
 * @author <a href="mailto:jean-christophe.routier@lifl.fr">Jean-Christophe Routier</a>
 * @version
 */

public class ModularCounter extends Counter {
	protected int modulo;

	public ModularCounter(int modulo) {
		super();
		this.modulo = modulo;
	}

	public void increment() {
		this.value = (this.value + 1) % this.modulo;
	}
}// ModularCounter
