package action;

/**
 * @author  tarik
 */
public abstract class Action {

	/**
	 * @uml.property  name="state"
	 * @uml.associationEnd  
	 */
	protected ActionState state;
	protected String msg;
	
	public Action() {
		this.state = ActionState.non_commencee;
	}

	public Action(String msg) {
		this.msg = msg;
		this.state = ActionState.non_commencee;
	}
	
	public void faire()  throws IllegalStateException{		
		if (this.estTerminee()) {
			throw new IllegalStateException("action terminee");
		}		
		if (msg != null) System.out.print(msg);
		this.contenuFaire();		
	}
	
	protected abstract void contenuFaire();
	
	public boolean estTerminee()  {
		return this.state == ActionState.terminee;
	}
	
	/**
	 * @return
	 * @uml.property  name="state"
	 */
	public ActionState getState() {
		return this.state;
	}
	
}
