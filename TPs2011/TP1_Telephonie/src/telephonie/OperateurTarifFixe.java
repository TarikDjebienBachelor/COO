
package telephonie;

import java.util.*;

import telephonie.util.Date;

public class OperateurTarifFixe implements Operateur {
   //nombres de connexions maximales de l'operateur
   private int nbConnexionsMax ;
   //nombres de connexions en cours avec l'operateur courant
   private int nbConnexionsCourante ;
   //la liste des connexions en cours avec l'operateur courant
   private List<Connexion> listeConnexionsEtablies ;

   public OperateurTarifFixe(int nbConex){
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
   // Si la duree de communication est inferieur a 5 minutes :
   if (c.dureeConnexion() < 5 ) {
       // on facture la duree reelle de communication
      return (int) c.dureeConnexion() ;
    }//sinon on applique au dela de 5 minutes un coefficient reducteur de 0.80 :
   else {
      // en arrondissant a l'entier superieur le plus proche
      return  (int) (Math.ceil((double)(c.dureeConnexion()*0.80))) ;
    }//endif
   }//getDureeComptabilisee

   public int getTarifUnitaire(Connexion c){
   // 30 centimes d'euros la minute
   return 30;
   }

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

}// class OperateurTarifFixe
