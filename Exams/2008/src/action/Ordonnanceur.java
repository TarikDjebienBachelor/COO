package action;

import java.util.ArrayList;

public abstract class Ordonnanceur extends Action {

	protected int indexActionCourante;	
	protected ArrayList<Action> lesActions;
	
	public Ordonnanceur() {
		this.indexActionCourante = 0;
		this.lesActions = new ArrayList<Action>();
	}

	public void faire()  throws IllegalStateException{
		if (this.lesActions.isEmpty()) {
			throw new IllegalStateException("action terminee");
		}		
		super.faire();
	}

	
	public void ajouter(Action action) {
		this.lesActions.add(action);
	}
	
}
