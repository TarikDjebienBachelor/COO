package distributionCourrier;


public class AccuseReception extends LettreSimple {
	
	public AccuseReception(Habitant exp,Habitant dest,String nomRecommande){
		super(exp,dest,new Texte(nomRecommande+" bien recu!"));
	}

	

}
