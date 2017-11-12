package introihm;

/**
 * Counter.java
 * 
 * @author <a href="mailto:jean-christophe.routier@lifl.fr">Jean-Christophe Routier</a>
 * @version
 */

public abstract class Counter {
	protected int value;

	public Counter() {
	}

	public int getCurrentValue() {
		return this.value;
	}

	public abstract void increment();

	public void init(int init) {
		this.value = init;
	}
}// Counter
