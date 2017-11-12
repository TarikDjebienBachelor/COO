package distributionCourrier;


public class LettreSimple extends Courrier<Texte> {

	private final static float COUT = 0.5f;
	
	public LettreSimple(Habitant exp,Habitant dest, Texte contenu){
		super(exp,dest,contenu);
	}
	
	@Override
	public void action() {
		this.expediteur.debiter(this.getCout());
	}

	@Override
	public float getCout() {
		return LettreSimple.COUT;
	}

	public String toString(){
		return super.toString()+ " simple [contenu : "+this.contenu.getDescription()+"] ";
	}
}
