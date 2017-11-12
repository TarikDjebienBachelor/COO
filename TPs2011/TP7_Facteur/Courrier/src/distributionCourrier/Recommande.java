package distributionCourrier;


public class Recommande extends CourrierDecorateur {

	private static final float POURCENTAGE = 15.0f;
	
	public Recommande(Habitant exp, Habitant dest, Courrier<?> courrier){
		super(exp,dest,courrier);
		
	}
	
	@Override
	public void action() {
	     super.action();
	     this.destinataire.envoieCourrier(new AccuseReception(this.destinataire,this.expediteur,this.nom));
	     this.expediteur.debiter(this.getCout());
	}

	@Override
	public float getCout() {
		return ((this.contenu.getCout())/100)*Recommande.getPOURCENTAGE();
	}

	public static float getPOURCENTAGE() {
		return POURCENTAGE;
	}

}
