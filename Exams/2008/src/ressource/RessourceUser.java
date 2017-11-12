package ressource;


/**
 * La classe des utilisateurs de ressource.
 * @param  < R  >  le type de ressource utilis�e
 */
public class RessourceUser<R extends Ressource> {
	
	/**
	 * La ressource utilis�e
	 * @uml.property  name="ressource"
	 */
	protected R ressource;
	/**
	 * @return  la ressource actuellement utilis�e, <t>null</t> si aucune
	 * @uml.property  name="ressource"
	 */
	public R getRessource() {
		return this.ressource;
	}	
	/**
	 * fixe la ressource utilis�e
	 * @param ressource  la ressource
	 * @uml.property  name="ressource"
	 */
	public void setRessource(R ressource) {
		this.ressource = ressource;
	}
	/**
	 * 
	 */
	public void resetRessource() {
		this.ressource = null;		
	}
}
