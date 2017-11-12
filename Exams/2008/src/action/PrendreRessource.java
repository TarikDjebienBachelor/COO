package action;

import java.util.NoSuchElementException;

import ressource.GestionnaireRessources;
import ressource.Ressource;
import ressource.RessourceUser;

public class PrendreRessource<R extends Ressource> extends AbstractRessourceAction<R> { 
	
	public PrendreRessource(String msg, GestionnaireRessources<R> gestionnaire, RessourceUser<R> user) {
		super(msg, gestionnaire, user);		
	}

	protected void contenuFaire() {		
		try {
			R ressource = this.gestionnaire.fournitRessource();
			// on a reussi a recuperer une ressource
			this.user.setRessource(ressource);
			// juste pour visualiser la trace en test 
			System.out.println(" prise de "+this.user.getRessource().description());
			
			this.state = ActionState.terminee;
		}
		catch(NoSuchElementException e) {
			// pas de ressource disponible, action non terminee
			System.out.println();
		}		
	}

}
