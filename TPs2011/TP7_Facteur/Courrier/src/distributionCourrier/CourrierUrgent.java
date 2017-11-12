package distributionCourrier;


public class CourrierUrgent extends CourrierDecorateur {

	private static final float FACTEUR_URGENCE = 2.0f;
	
	public CourrierUrgent(Habitant exp, Habitant dest, Courrier<?> courrier){
		super(exp,dest,courrier);
	}
	
	@Override
	public float getCout() {
		return super.getCout()*CourrierUrgent.FACTEUR_URGENCE;
	}

}
