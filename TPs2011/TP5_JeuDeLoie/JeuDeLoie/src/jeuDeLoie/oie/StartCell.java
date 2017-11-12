package jeuDeLoie.oie;


public class StartCell implements Cell {

	protected PlayerList thePlayers;
	
	@Override
	public boolean canBeLeft() {
		return true;
	}

	@Override
	public int consequence(int dieThrow) {
		return 0;
	}

	@Override
	public int getIndex() {
		return 0;
	}

	@Override
	public Player getPlayer() {
		return this.thePlayers.nextPlayer();
	}

	@Override
	public boolean isBusy() {
		return false;
	}

	@Override
	public void setPlayer(Player player) {
		this.thePlayers.addPlayer(player);
	}

}
