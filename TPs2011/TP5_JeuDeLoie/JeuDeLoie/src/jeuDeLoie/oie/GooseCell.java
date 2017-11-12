package jeuDeLoie.oie;


public class GooseCell extends BasicCell {

	/**
	 */
	public GooseCell(int index){
		super(index);
	}
	
	
	/**
	 */
	@Override
	public int consequence(int dieThrow){
		int destinationGoose = this.index + dieThrow ;
		System.out.print(" ***GOOSECELL*** jump to cell "+destinationGoose+",");
		return destinationGoose;
	}
	
}
