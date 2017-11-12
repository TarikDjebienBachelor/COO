package distributionCourrier;


public abstract class Courrier <T extends Contenu> implements Contenu {

	
	protected T contenu;
	private static int cpt;
	protected Habitant destinataire;
	protected Habitant expediteur;
	protected String nom;
	
	public Courrier(Habitant exp, Habitant dest, T contenu){
		this.expediteur = exp;
		this.destinataire = dest;
		this.contenu = contenu;
		Courrier.setCpt(Courrier.getCpt() + 1);
	}
	
	public abstract void action();
	public abstract float getCout();
	
	public T getContenu(){
		return this.contenu;
	}
	
	@Override
	public String getDescription() {
		return this.getContenu().getDescription();
	}
	
	public Habitant getDestinataire(){
		return this.destinataire;
	}

	public Habitant getExpediteur(){
		return this.expediteur;
	}
	
	/**
	 * @return the cpt
	 */
	public static int getCpt() {
		return cpt;
	}

	public static void setCpt(int cpt) {
		Courrier.cpt = cpt;
	}

	public String toString(){
		return "courrier"+Courrier.getCpt();
	}

	public void repond(Courrier<?> c){
		
	}
}
