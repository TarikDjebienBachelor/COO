package distributionCourrier;


public class Habitant {
	
	private float soldeCompte;
	private Adresse adresse;
	private String nom;
	
	
	public Habitant(String name,float solde,Adresse adr){
		this.setNom(name);
		this.setSoldeCompte(solde);
		this.adresse=adr;
	}

	public Adresse getAdresse(){
		return this.adresse;
	}
	
	public void recoitCourrier(Courrier<?> courrier){
		courrier.action();
		System.out.println("Solde de "+courrier.getExpediteur().getNom()+" : "+courrier.getExpediteur().getSoldeCompte()+".\n");
	}
	
	public void envoieCourrier(Courrier<?> courrier){
		System.out.println(
				">>> "+
				courrier.getExpediteur().getNom()+
				" envoie "+
				courrier.toString()+
				"(cout: "+courrier.getCout()+")"+
				" à "+ courrier.getDestinataire().getNom()+".\n"
		);
		courrier.getDestinataire().getAdresse().getVille().posteLettre(courrier);
	}
	
	public void debiter(float montant){
		this.setSoldeCompte(this.getSoldeCompte()-montant);
	}
	
	public void crediter(float montant){
		this.setSoldeCompte(this.getSoldeCompte()+montant);
	}

	public void setSoldeCompte(float soldeCompte) {
		this.soldeCompte = soldeCompte;
	}

	public float getSoldeCompte() {
		return soldeCompte;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
}
