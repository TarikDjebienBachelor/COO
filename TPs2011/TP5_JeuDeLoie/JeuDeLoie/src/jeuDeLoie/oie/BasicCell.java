package jeuDeLoie.oie;

public class BasicCell implements Cell {
	
	/**
	 * @uml.property  name="index"
	 */
	protected int index;
	
	/**
	 * @uml.property  name="player"
	 */
	protected Player player;

	/**
	 */
	public BasicCell(int index){
	this.index = index;
	this.player = null;
	}
	
	@Override
	public boolean canBeLeft() {
		return true;
	}

	@Override
	public int consequence(int dieThrow) {
		return this.index;
	}

	@Override
	public boolean isBusy() {
		return this.getPlayer() != null;
	}

	@Override
	public int getIndex() {
		return this.index;
	}

	/**
	 * Setter of the property <tt>index</tt>
	 * @param index  The index to set.
	 * @uml.property  name="index"
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 */
	@Override
	public Player getPlayer(){
		return this.player;
	}

	/**
	 * Setter of the property <tt>player</tt>
	 * @param player  The player to set.
	 * @uml.property  name="player"
	 */
	@Override
	public void setPlayer(Player player) {
		this.player = player;
	}		


			
	

	

}
