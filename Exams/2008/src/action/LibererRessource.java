package action;

import ressource.GestionnaireRessources;
import ressource.InvalidRessourceException;
import ressource.Ressource;
import ressource.RessourceUser;

public class LibererRessource<R extends Ressource> extends AbstractRessourceAction<R>  {

	public LibererRessource(String msg, GestionnaireRessources<R> gestionnaire, RessourceUser<R> user) {
		super(msg, gestionnaire, user);		
	}
		
	@Override
	protected void contenuFaire() {		
		try {
			// juste pour visualiser la trace en test
			System.out.println(" liberation de "+this.user.getRessource().description());
			
			this.gestionnaire.libererRessource(this.user.getRessource());
			this.user.resetRessource();
		} catch (InvalidRessourceException e) {			
			e.printStackTrace();
		}
		this.state = ActionState.terminee;
	}

}
