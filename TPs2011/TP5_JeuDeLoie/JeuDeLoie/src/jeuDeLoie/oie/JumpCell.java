package jeuDeLoie.oie;


public class JumpCell extends BasicCell {

	/**
	 * @uml.property  name="jumpIndex"
	 */
	protected int jumpIndex;
	
	/**
	 */
	public JumpCell(int index, int jumpIndex){
		super(index);
		this.jumpIndex = jumpIndex;
	}
	
	/**
	 */
	@Override 
	public int consequence(int dieThrow){
		System.out.print(" ***JUMPCELL"+this.index+"*** teleport to cell "+this.jumpIndex+", ");
		return this.jumpIndex;
	}

}
