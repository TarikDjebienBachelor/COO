package jeuDeLoie.oie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jeuDeLoie.oie.Player;


public class PlayerList {

	/** 
	 */
	private List<Player> listOfPlayers;
	
	/**
	 * 
	 */
	private Iterator<Player> iter;
	
	/**
	 */
	public PlayerList(){
		this.listOfPlayers = new ArrayList<Player>();
		this.iter = this.listOfPlayers.iterator();
	}
	
	/**
	 */
	public void addPlayer(Player player){
	this.listOfPlayers.add(player);
	}
	
	
	/**
	 */
	public Player nextPlayer(){
	  if (iter.hasNext())
		return this.iter.next();
	  else{
		this.iter = this.listOfPlayers.iterator();
	    return this.iter.next();
	  }
	}
	
	/** 
	 * Getter of the property <tt>listOfPlayers</tt>
	 * @return  Returns the listOfPlayers.
	 * @uml.property  name="listOfPlayers"
	 */
	public List<Player> getListOfPlayers() {
		return this.listOfPlayers;
	}

	/** 
	 * Setter of the property <tt>listOfPlayers</tt>
	 * @param listOfPlayers  The listOfPlayers to set.
	 * @uml.property  name="listOfPlayers"
	 */
	public void setListOfPlayers(List<Player> listOfPlayers) {
		this.listOfPlayers = listOfPlayers;
	}
	
}
