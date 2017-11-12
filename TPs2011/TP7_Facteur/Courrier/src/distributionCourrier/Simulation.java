package distributionCourrier;


public class Simulation {

	public static void main(String[] args) {
		
		Ville Lille = new Ville("Lille");
		Habitant tarik = new Habitant("tarik",90.00f,new Adresse(37,"rue de Timoleon",Lille));
		Habitant cloud = new Habitant("cloud",90.00f,new Adresse(7,"rue de nibelheim",Lille));
		
		tarik.envoieCourrier(new LettreSimple(tarik,cloud,new Texte("Salut cloud")));
		cloud.envoieCourrier(new LettreSimple(cloud,tarik,new Texte("Salut tarik")));
		tarik.envoieCourrier(new LettreSimple(tarik,cloud,new Texte("Sava?")));
		cloud.envoieCourrier(new LettreSimple(cloud,tarik,new Texte("bien et toi ?")));
		tarik.envoieCourrier(new LettreSimple(tarik,cloud,new Texte("Sava merci")));
		cloud.envoieCourrier(new LettreSimple(cloud,tarik,new Texte("La prochaine fois, essaye de faire une meilleure simulation.")));
		tarik.envoieCourrier(new LettreSimple(tarik,cloud,new Texte("J'y penserai à l'occasion.")));
		
		
		Lille.distribueCourrier();
	}

}
