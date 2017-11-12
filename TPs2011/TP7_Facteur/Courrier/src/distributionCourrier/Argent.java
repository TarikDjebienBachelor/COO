package distributionCourrier;


/**
 * @uml.dependency   supplier="distributionCourrier.Contenu"
 */
public class Argent implements Contenu {



	/**
	 * @uml.property  name="valeur"
	 */
	private float valeur;

	/**
	 */
	public Argent(float valeur){
	this.valeur = valeur;
	}
	
	/**
	 * Getter of the property <tt>valeur</tt>
	 * @return  Returns the valeur.
	 * @uml.property  name="valeur"
	 */
	public float getValeur() {
		return this.valeur;
	}

	/**
	 * Setter of the property <tt>valeur</tt>
	 * @param valeur  The valeur to set.
	 * @uml.property  name="valeur"
	 */
	public void setValeur(float valeur) {
		this.valeur = valeur;
	}

	@Override
	public String getDescription() {
		String j = new String();
		j = String.valueOf(this.getValeur());
		return j+" euros";
	}

}
