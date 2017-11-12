package jeuDeLoie.oie;

public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game leJeu = new Game(ClassicBoard.THE_BOARD);
		leJeu.addPlayer("Tarik");
		leJeu.addPlayer("Timoleon");
		leJeu.addPlayer("Ken");
		leJeu.addPlayer("Bilbo");
		leJeu.play();
	}

}
