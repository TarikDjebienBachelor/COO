package distributionCourrier;


public class Adresse {
	
	private int numero;
	private String rue;
	private Ville ville;
	
	public Adresse(int num,String rue,Ville ville){
		this.numero=num;
		this.rue=rue;
		this.ville=ville;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * @return the ville
	 */
	public Ville getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	

}
