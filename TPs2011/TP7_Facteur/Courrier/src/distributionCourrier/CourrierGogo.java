package distributionCourrier;


public class CourrierGogo extends Courrier<ContenuGogo> {

	private final static float COUT = 1.0f;
	
	public CourrierGogo(Habitant exp,Habitant dest, ContenuGogo contenu){
		super(exp,dest,contenu);
	}
	
	@Override
	public void action() {
	}

	@Override
	public float getCout() {
		return CourrierGogo.COUT;
	}

}
