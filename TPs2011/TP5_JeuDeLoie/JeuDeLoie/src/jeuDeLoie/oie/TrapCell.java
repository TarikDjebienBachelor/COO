package jeuDeLoie.oie;


public class TrapCell extends BasicCell {

		
	/**
	 */
	public TrapCell(int index){
		super(index);
	}
	
	/**
	 * 
	 */
	@Override
	public boolean canBeLeft(){
		return false;	
	}

	@Override
	public int consequence(int dieThrow) {
		System.out.print(" ***TRAPCELL"+this.index+"*** Don't move, ");
		return this.index;
	}
}
