package distributionCourrier;

import java.util.*;


public class Ville {
	
	
	private List<Courrier<?>> boiteALettres;
	private String nom;
	
	
	public Ville(String n){
		this.nom=n;
		this.boiteALettres= new ArrayList<Courrier<?>>();
	}
	public void posteLettre(Courrier<?> c){
		this.getBoiteALettres().add(c);
	}

	public void distribueCourrier(){
		for ( Courrier<?> c : this.getBoiteALettres() ){
			c.getDestinataire().recoitCourrier(c);
		}		
	}
	
	/*
	public boolean courrierADistribuer(){
		return true;	
	}*/
	
	public void setBoiteALettres(List<Courrier<?>> boiteALettres) {
		this.boiteALettres = boiteALettres;
	}

	public List<Courrier<?>> getBoiteALettres() {
		return boiteALettres;
	}
	public String getNom() {
		return nom;
	}
}
