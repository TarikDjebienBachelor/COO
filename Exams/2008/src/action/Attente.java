package action;

public class Attente extends Action {

	private int tempsAttente;
	
	public Attente(int tempsAttente) {
		this(null,tempsAttente);
	}

	public Attente(String msg, int tempsAttente) {
		super(msg);
		this.tempsAttente = tempsAttente;
	}

	
	@Override
	protected void contenuFaire() {		
		if ((--this.tempsAttente) == 0) {
			this.state = ActionState.terminee;
		}		
		// juste pour visualiser la trace en test
		System.out.println(" "+this.tempsAttente);
	}

}
