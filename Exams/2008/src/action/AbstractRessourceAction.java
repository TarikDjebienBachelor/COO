package action;

import ressource.GestionnaireRessources;
import ressource.Ressource;
import ressource.RessourceUser;

/**
 * @author  tarik
 */
public abstract class AbstractRessourceAction<R extends Ressource> extends Action {

	/**
	 * @uml.property  name="gestionnaire"
	 * @uml.associationEnd  
	 */
	protected GestionnaireRessources<R> gestionnaire;
	/**
	 * @uml.property  name="user"
	 * @uml.associationEnd  
	 */
	protected RessourceUser<R> user;
	
	public AbstractRessourceAction(String msg, GestionnaireRessources<R> gestionnaire, RessourceUser<R> user) {
		super(msg);
		this.gestionnaire = gestionnaire;
		this.user = user;
	}

	
}
