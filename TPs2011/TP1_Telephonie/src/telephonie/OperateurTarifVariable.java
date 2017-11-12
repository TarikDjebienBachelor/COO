
package telephonie;

import java.util.*;

import telephonie.util.Date;

public class OperateurTarifVariable implements Operateur {

   //nombres de connexions maximales de l'operateur
   private int nbConnexionsMax ;
   //nombres de connexions en cours avec l'operateur courant
   private int nbConnexionsCourante ;
   //la liste des connexions en cours avec l'operateur courant
   private List<Connexion> listeConnexionsEtablies ;

   public OperateurTarifVariable(int nbConex){
   this.nbConnexionsMax = nbConex ;
   this.nbConnexionsCourante = 0 ;
   this.listeConnexionsEtablies = new LinkedList<Connexion> ();
   }

   public Connexion seConnecter(Date debut, ModeDePaiement m) throws OperateurSatureException, ModeDePaiementInvalideException {
   // Premierement, on verifie s'il n'est pas sature
      if ( this.getNbConnexionsCourante() == this.getNbConnexionsMax() ) {
            throw new OperateurSatureException();
      } else if (!m.valide()) {
   // Ensuite on verifie si le mode de paiement est valide
     throw new ModeDePaiementInvalideException();
     }
     else{ // L'operateur courant a un mode de paiement qui est valide et il n'est pas sature donc
          // On incremente le nombre de connexion courante a l'operateur :
          this.setNbConnexionsCourante(this.nbConnexionsCourante+1);
           // et on se connecte :
          Connexion enCours = new Connexion(this, debut, m);
          // en ajoutant la nouvelle connexion :
          this.listeConnexionsEtablies.add(enCours);
          // finalement on renvoi la connexion creer
          return enCours;
     }//fin else
   }// seConnecter

   public void seDeconnecter(Connexion c, Date fin) throws PasDeConnexionException {
   // Premierement, on verifie si la Connexion c est liee a l'operateur courant
   if (!this.listeConnexionsEtablies.contains(c)) {
         throw new PasDeConnexionException();
   } else {
       // la fin de connexion est notifiee a la connexion
       Connexion enCours = this.listeConnexionsEtablies.get(this.listeConnexionsEtablies.indexOf(c)) ;
       enCours.finConnexion(fin);
       // et le mode de paiement associe a la connexion est debite
       // en fonction de la duree de la connexion comptabilisee et du tarif unitaire :
       enCours.mode().debiter(this.getDureeComptabilisee(enCours), this.getTarifUnitaire(enCours) ) ;
    // On supprime la connexion de l'operateur associe :
    boolean estDeconnecter = this.listeConnexionsEtablies.remove(c);
    // et on decremente le nombre de connexion courante associe a l'operateur :
    if (estDeconnecter) this.setNbConnexionsCourante(this.getNbConnexionsCourante() - 1 );
    }// fin else
   }// seDeconnecter

   public int getDureeComptabilisee(Connexion c){
   // On facture la duree reelle de communication
      return (int) c.dureeConnexion();
   }//getDureeComptabilisee

   public int getTarifUnitaire(Connexion c){
   // Celui ci est fonction de l'heure de la date de debut de connexion :
   // Si l'heure de connexion 20h <= h <= 8h ,
   if (c.heureDebutConnexion() <= 8 || c.heureDebutConnexion() >= 20) {
	   // on facture la minute a 15 centimes d'euros
	   return 15;
	   } else
   //  Si l'heure de connexion 8h <= h <= 12h OU 14h <= h <= 20h ,
   if ((c.heureDebutConnexion() >= 8 && c.heureDebutConnexion() <= 12) || (c.heureDebutConnexion() >= 14 && c.heureDebutConnexion() <= 20)) {
	   // on facture la minute a 30 centimes d'euros
	   return 30;
	   } else
   // Si l'heure de connexion 12h <= h <= 14h ,
   if (c.heureDebutConnexion() <= 14 && c.heureDebutConnexion() >= 12) {
	   // on facture la minute a 45 centimes d'euros
	   return 45;
      } // n'entrera jamais dans ce cas normalement :
      else {
		System.out.println("  probleme : heure de debut de connexion n'est pas comprise entre 0 et 23 '");
		return 0;
	}
   }//getTarifUnitaire

   public int getNbConnexionsMax() {
   return this.nbConnexionsMax;
   }

   public int getNbConnexionsCourante() {
   return this.nbConnexionsCourante;
   }

   public void setNbConnexionsMax(int nb) {
   this.nbConnexionsMax = nb;
   }

   public void setNbConnexionsCourante(int nc) {
   this.nbConnexionsCourante = nc;
   }

}//class OperateurTarifVariable
