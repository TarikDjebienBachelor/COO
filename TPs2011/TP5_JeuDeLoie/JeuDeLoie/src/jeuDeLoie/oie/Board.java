package jeuDeLoie.oie;


public abstract class Board {

	/**
	 * @uml.property  name="NB_OF_CELLS" readOnly="true"
	 */
	protected final int NB_OF_CELLS;
	
	/** 
	 * @uml.property name="theCells"
	 */
	protected Cell[] theCells;

	/**
	 */
	public Board(int nbOfCells){
		this.NB_OF_CELLS = nbOfCells + 1;
		this.theCells = new Cell[this.NB_OF_CELLS];
		this.initBoard();
	}		
			
	/**
	 */
	public Cell getCell(int numero){
		return this.theCells[numero];
	}
	
	/**
	 * @return the theCells
	 */
	public Cell[] getTheCells() {
		return theCells;
	}

	/**
	 */
	public int getNbOfCells(){
		return this.NB_OF_CELLS;
	}
	
	/**
	 */
	protected abstract void initBoard();
					

}
