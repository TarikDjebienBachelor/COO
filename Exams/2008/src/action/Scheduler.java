package action;

public class Scheduler extends Ordonnanceur {

	private int nbActionsTerminees;

	public Scheduler() {
		super();
		this.nbActionsTerminees = 0;
	}

	@Override
	protected void contenuFaire() {
		Action action = this.lesActions.get(this.indexActionCourante);
		if (!action.estTerminee()) { // pas encore terminee ?
			action.faire();
			// et maintenant, terminee ?
			if (action.estTerminee()) {
				this.nbActionsTerminees = this.nbActionsTerminees + 1;
			}
		}
		if (this.nbActionsTerminees == this.lesActions.size()) {
			this.state = ActionState.terminee;
		} else {
			do {
				this.indexActionCourante = (this.indexActionCourante + 1) % this.lesActions.size();
			} while (this.lesActions.get(this.indexActionCourante).estTerminee()); // il y en a forcément une de non terminée 
		}
	}

}
