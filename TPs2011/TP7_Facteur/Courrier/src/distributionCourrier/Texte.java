package distributionCourrier;


public class Texte implements Contenu {


	/**
	 * @uml.property  name="texte"
	 */
	private String texte;

		
	/**
	 */
	public Texte(String texte){
		this.texte = texte;
	}

	@Override
	public String getDescription() {
		return this.texte;
	}
	
}
