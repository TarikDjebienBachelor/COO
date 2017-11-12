package jeuDeLoie.oie;


public class ClassicBoard extends Board {

	/**
	 */
	public static final ClassicBoard THE_BOARD = new ClassicBoard(63);
	
	@Override
	protected void initBoard() {
		for(int i=0;i<this.theCells.length;i++){
			
			if(i==9||i==18||i==27||i==36||i==45||i==54){
				this.theCells[i] = new GooseCell(i);
			}else if(i==31||i==52){
				this.theCells[i] = new TrapCell(i);
			}else if(i==19){
				this.theCells[i] = new WaitCell(i,2);
			}else if(i==6){
				this.theCells[i] = new JumpCell(i,12);
			}else if(i==42){
				this.theCells[i] = new JumpCell(i,30);
			}else if(i==58){
				this.theCells[i] = new JumpCell(i,1);
			}else 
				this.theCells[i] = new BasicCell(i);
		}
	}

	/**
	 */
	private ClassicBoard(int nbOfCells){
	   super(nbOfCells);
	}

}
