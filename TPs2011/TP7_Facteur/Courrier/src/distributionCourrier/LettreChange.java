package distributionCourrier;


public class LettreChange extends Courrier<Argent> {

	private static final float COUT_BASE = 1.0f;
	private static final float POURCENTAGE = 1.0f;
	
	public LettreChange(Habitant exp, Habitant dest, Argent contenu){
		super(exp,dest,contenu);
	}
	
	@Override
	public void action() {
		this.expediteur.debiter(this.contenu.getValeur());
		this.destinataire.crediter(this.contenu.getValeur());
		this.destinataire.envoieCourrier(new Merci(this.destinataire,this.expediteur,this.nom));
		this.expediteur.debiter(this.getCout());
	}

	@Override
	public float getCout() {
		return LettreChange.COUT_BASE + ((this.contenu.getValeur())/100)*LettreChange.POURCENTAGE;
	}
	
	public String toString(){
		return super.toString()+ " de change [valeur = "+this.contenu.getDescription()+"] ";
	}

}
