package jeuDeLoie.oie;


public class WaitCell extends BasicCell {

	/**
	 * @uml.property  name="waitDuration"
	 */
	protected int waitDuration;

	/**
	 * @uml.property  name="waitTime"
	 */
	protected int waitTime;
		
	/**
	 */
	public WaitCell(int index, int waitDuration){
		super(index);
		this.waitDuration = waitDuration;
		this.waitTime = 0;
	}
			
	/**
	 */
	@Override
	public boolean canBeLeft(){
		if (this.getWaitDuration() != this.getWaitTime()){
			System.out.println(" ***WAITCELL"+this.index+"*** sorry but you can't play please wait during "+(this.getWaitDuration()-this.getWaitTime())+" turns.");
		}
		this.setWaitTime(this.getWaitTime()+1);
		return this.getWaitDuration() == (this.getWaitTime()-1);	
	}

	@Override
	public int consequence(int dieThrow) {
		System.out.print(" ***WAITCELL"+this.index+"*** please wait during "+this.getWaitDuration()+" turns, ");
		this.setWaitTime(0);
		return this.index;
	}
	
	/**
	 */
	@Override
	public void setPlayer(Player player){
		super.setPlayer(player);
	}

	/**
	 * @return the waitDuration
	 */
	public int getWaitDuration() {
		return waitDuration;
	}

	/**
	 * @param waitDuration the waitDuration to set
	 */
	public void setWaitDuration(int waitDuration) {
		this.waitDuration = waitDuration;
	}

	/**
	 * @return the waitTime
	 */
	public int getWaitTime() {
		return waitTime;
	}

	/**
	 * @param waitTime the waitTime to set
	 */
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}

}
