package distributionCourrier;


public class ContenuGogo implements Contenu {

	private Habitant[] beneficiaires;
	private float valeur;
	
	public ContenuGogo (Habitant[] tabHab,float val){
		this.beneficiaires=tabHab;
		this.valeur=val;
	}
	
	public Habitant[] getBeneficiaires(){
		return this.beneficiaires;
	}
	
	public float getValeur(){
		return this.valeur;
	}
	
	@Override
	public String getDescription() {
		return null;
	}

}
