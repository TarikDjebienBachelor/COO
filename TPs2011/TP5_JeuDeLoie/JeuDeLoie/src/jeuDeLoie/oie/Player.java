package jeuDeLoie.oie;


/** A player in the "jeu de l'oie" game */
public class Player {

	/** current cell of the player */
    protected Cell cell;
    
    /** name of the player*/
    protected String name;
    
    /** 
     * Constructor of initialization of Player
     */
    public Player (String name, Cell cell){
        this.name = name;
        this.cell = cell;
    }
    
    /** */
    public String toString() { 
    	return this.name+" is in cell "+this.getCell().getIndex(); 
    }
    
    /** returns the current cell of the player */
    public Cell getCell() { 
       return this.cell ; 
    }
    
    /** changes the cell of the player */
    public void setCell(Cell newCell) { 
       this.cell = newCell; 
    }    
    
    /**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** result of a 1d6 throw*/
    private int oneDiceThrow() {	
       return ((int) (Math.random()*10000) % 6)+ 1; 
    }
    
    /** result of a 2d6 throw */ 
    public int twoDicesThrow() {
        int result = oneDiceThrow() + oneDiceThrow();
        System.out.print(this.name+" throws "+result+", ");	
        return result;
    }
    
    /**
     * 
     * @param p
     */
    public void swapPlayer(Player p){
    	// temp <-- position player 1
    	Cell temp = this.getCell();
    	// position player 1 <-- position player 2
    	this.setCell(p.getCell());
    	p.getCell().setPlayer(this);
    	// position player 2 <-- temp
    	p.setCell(temp);
    	temp.setPlayer(p);
    	// Affichage
    	System.out.print(this.getName()+" is sent to cell "+this.getCell().getIndex()+", ");
    	System.out.print(p.getName()+" is sent to cell "+p.getCell().getIndex()+".");
    }
    
}// Player