package jeuDeLoie.oie;


public class Game {

	/**
	 * @uml.property  name="board"
	 */
	protected Board board;

	/**
	 * @uml.property  name="thePlayers"
	 */
	protected PlayerList thePlayers;
	
	/**
	 */
	public Game(Board board){
		this.board = board;
		this.thePlayers = new PlayerList();
	}
	
	/**
	 */
	public void addPlayer(String name){
		this.thePlayers.addPlayer(new Player(name,this.board.getCell(0)));
	}

	/**
	 */
	private int boundedIndex(int index, int dicesThrow){
		int indexDestination = index + dicesThrow ;
		if ( indexDestination <= 63)
			return indexDestination ;
		else{
			return (63 - (indexDestination - 63)) ;
		}
	}

	/**
	 */
	public void play(){
		int nbOfTurns = 1;
		// TANT QUE la case d'arrivée n'est pas occupée FAIRE
		while (!(this.board.getCell(63).isBusy())){
			// Nombres de Tours de la partie :
			System.out.println("=========== TURN NUMBER : "+ nbOfTurns++ +" =============");
			
			// POUR chaque joueur FAIRE
			for (Player p : this.thePlayers.getListOfPlayers()){
				
				// Afficher son nom et sa position
				System.out.print(p.toString()+", ");
				
				// SI la case occupée par le joueur peut etre quittée FAIRE
				if (p.getCell().canBeLeft()){
					
					// Lancer les deux dés
					int resultDicesThrow = p.twoDicesThrow();
					
					// On regarde ou va atterrir le joueur sans se soucier d'eventuel effet
					int viewDestination = this.boundedIndex(p.getCell().getIndex(), resultDicesThrow);
					
					// Puis en prenant en compte l'effet:
					int effectDestination = this.board.getTheCells()[viewDestination].consequence(resultDicesThrow);
					
					// Finalement on verifie si l'effet n'a pas declenché un déplacement hors jeu
					int finalDestination = this.boundedIndex(effectDestination, 0);
					   
					// SI la destination est occupée FAIRE
					if (this.board.getTheCells()[finalDestination].isBusy()){
						
						// Inverser les joueurs qui occupent les case  
						p.swapPlayer(this.board.getTheCells()[finalDestination].getPlayer());
						
					}
					// SINON déplacer le joueur sur la case de destination libre
					else{
						// on libere la case que l'on va quitter :
						this.board.getTheCells()[p.getCell().getIndex()].setPlayer(null);
						// on se déplace vers la case destination libre :
						p.setCell(this.board.getTheCells()[finalDestination]);
						// qui dorenavant passe au statut occupée :
						this.board.getTheCells()[finalDestination].setPlayer(p);
					}
					
					// Afficher sa destination
					System.out.println("\n => "+p.getName()+" reaches cell "+p.getCell().getIndex());					
				}
				// SINON le joueur ne peut pas jouer
				else{
					System.out.println(p.getName()+" cannot play.");
				}
			}// FINPOUR
			
			// Tout les joueurs ont joués, on passe au tours suivant :
			System.out.println();
		}// FIN TANTQUE
		System.out.println(this.board.getCell(63).getPlayer().getName()+" has won. ");
	}// play()
				
}
