package distributionCourrier;


public abstract class CourrierDecorateur extends Courrier< Courrier<?> > {

	public CourrierDecorateur(Habitant exp, Habitant dest, Courrier<?> contenu){
		super(exp,dest,contenu);
	}
	
	@Override
	public void action(){
		this.getContenu().action();
	}
	@Override
	public float getCout() {
		return this.getContenu().getCout();
	}

	@Override
	public String getDescription() {
		return this.getContenu().getDescription();
	}

	@Override
	public Habitant getDestinataire() {
		return super.getDestinataire();
	}

	@Override
	public Habitant getExpediteur() {
		return super.getExpediteur();
	}

	@Override
	public void repond(Courrier<?> c) {
		super.repond(c);
	}

}
