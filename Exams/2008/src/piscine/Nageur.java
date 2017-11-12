package piscine;

import ressource.Cabine;
import ressource.GestionnaireDeCabines;
import ressource.GestionnaireDePaniers;
import ressource.Panier;
import ressource.RessourceUser;
import action.*;

/**
 * @author  tarik
 */
public class Nageur extends Scenario {

	protected String name;
	/**
	 * @uml.property  name="paniers"
	 * @uml.associationEnd  
	 */
	protected GestionnaireDePaniers paniers;
	/**
	 * @uml.property  name="cabines"
	 * @uml.associationEnd  
	 */
	protected GestionnaireDeCabines cabines;
	protected int tempsDeshabillage;
	protected int tempsBaignade;
	protected int tempsRhabillage;
	
	/**
	 * @uml.property  name="cabineUser"
	 * @uml.associationEnd  
	 */
	protected RessourceUser<Cabine> cabineUser;
	/**
	 * @uml.property  name="panierUser"
	 * @uml.associationEnd  
	 */
	protected RessourceUser<Panier> panierUser;	
	
	
	public Nageur(String name, GestionnaireDePaniers paniers, GestionnaireDeCabines cabines, int td, int tb, int tr) {
		super();
		this.name = name;
		this.paniers = paniers;
		this.cabines = cabines;
		this.tempsDeshabillage = td;
		this.tempsBaignade = tb;
		this.tempsRhabillage = tr;
		
		this.cabineUser = new RessourceUser<Cabine>();
		this.panierUser = new RessourceUser<Panier>();
		
		this.initActions();
	}
	
	private void initActions() { 
		this.ajouter(new PrendreRessource<Panier>(this.name+" cherche panier", this.paniers, this.panierUser));
		this.ajouter(new PrendreRessource<Cabine>(this.name+" cherche cabine", this.cabines, this.cabineUser));
		this.ajouter(new Attente(this.name+" se deshabille", this.tempsDeshabillage));
		this.ajouter(new LibererRessource<Cabine>(this.name+" libere sa cabine", this.cabines, this.cabineUser));
		this.ajouter(new Attente(this.name+" se baigne",this.tempsBaignade));
		this.ajouter(new PrendreRessource<Cabine>(this.name+" cherche cabine",this.cabines, this.cabineUser));
		this.ajouter(new Attente(this.name+" se rhabille",this.tempsRhabillage));
		this.ajouter(new LibererRessource<Cabine>(this.name+" libere sa cabine", this.cabines, this.cabineUser));
		this.ajouter(new LibererRessource<Panier>(this.name+" libere son panier", this.paniers, this.panierUser));
		
	}
	
}
