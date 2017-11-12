package action;


public class Scenario extends Ordonnanceur {
		
	public Scenario() {
		super();
	}

	@Override
	protected void contenuFaire() {		
		Action action = this.lesActions.get(this.indexActionCourante);
		action.faire();
		if (action.estTerminee()) {
			this.indexActionCourante = this.indexActionCourante + 1;
			if (this.indexActionCourante >= this.lesActions.size()) {
				this.state = ActionState.terminee;
			} 			
		}		
	}

}
