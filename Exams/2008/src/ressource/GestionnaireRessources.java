package ressource;


import java.util.LinkedList;
import java.util.NoSuchElementException;

public abstract class GestionnaireRessources<R extends Ressource> {

	protected int nbRessources;
	protected int nbRessourcesDisponibles;
	
	protected LinkedList<R> ressourcesDisponibles;
	protected LinkedList<R> ressourcesOccupees;
	
	public GestionnaireRessources(int nbRessources) {
		this.ressourcesDisponibles = new LinkedList<R>();
		for (int i = 0; i< nbRessources; i++) {
			this.ressourcesDisponibles.add(this.createRessource());
		}
		this.ressourcesOccupees = new LinkedList<R>();
	}
	
	public void libererRessource(R ressource) throws InvalidRessourceException  {
		if (! this.ressourcesOccupees.contains(ressource)) {
			throw new InvalidRessourceException(ressource.toString()+" invalide");
		}
		this.ressourcesDisponibles.add(ressource);
		this.ressourcesOccupees.remove(ressource);
	}
	
	public R fournitRessource() throws NoSuchElementException {
		if (this.ressourcesDisponibles.size() ==0 ) {		
			throw new NoSuchElementException();
		}
		R ressource = this.ressourcesDisponibles.remove(0); 
		this.ressourcesOccupees.add(ressource);
		return ressource;
	}
	
	protected abstract R createRessource();
}
