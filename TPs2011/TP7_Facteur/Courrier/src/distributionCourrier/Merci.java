package distributionCourrier;


public class Merci extends LettreSimple {

	public Merci(Habitant exp, Habitant dest, String nomLettreChange){
		super(exp,dest,new Texte(nomLettreChange));
		
	}

}
