
package telephonie;

import java.util.*;

import telephonie.util.Date;

public class CartePrePayee implements ModeDePaiement {
   // le solde de communication de la carte pre payee en valeur entiere de minutes
   private int nbMinute;
   // la carte Bancaire associé à la carte pre payee
   private CarteBancaire CB;
   // le constructeur d'initialisation :
   public CartePrePayee(CarteBancaire c){
	   this.nbMinute = 50;
	   this.CB = c;
	   c.debiter(this.nbMinute,15);
   }// CarteBancaire

   // Une carte pre payee est valide si il reste des minutes de credits
   public boolean valide(){
	return (this.getNbMinuteRestante() > 0);
   }// valide

   // Elles sont donc debitees d'une somme correspondant à :
   public void debiter(int dureeComptabilisee , int tarifUnitaireApplique) {
       //Si la duree de communication est inferieure au nombre de minute restant sur la carte,
       if (dureeComptabilisee <= this.getNbMinuteRestante()) {
       //pas de probleme, le nombre de minutes est diminué de cette durée :
       this.setNbMinuteRestante(this.getNbMinuteRestante()-dureeComptabilisee);
       if (this.getNbMinuteRestante() < 0) this.setNbMinuteRestante(0);
       }else {
       //sinon la duree en hors forfait est directement prelevé sur la CB associé
       //à la carte prepayee selon le tarif unitaire propre de l'operateur :
       int dureeHorsForfait = dureeComptabilisee - this.getNbMinuteRestante() ;
       this.setNbMinuteRestante(0);
       this.CB.debiter(dureeHorsForfait, tarifUnitaireApplique ) ;
       }//endelse

       // trace pour visualiser l'operation de debit :
       System.out.println(" La carte pre payee a été debité de :"+dureeComptabilisee+" minutes.\n");
       System.out.println(" Son solde de minutes restantes est dorenavant évalué à :"+this.getNbMinuteRestante()+" minutes\n");
   }// debiter

   public int getNbMinuteRestante(){
   return this.nbMinute;
   }//getNbMinuteRestante

   public void setNbMinuteRestante(int n){
   this.nbMinute = n ;
   }//setNbMinuteRestante

}// class CartePrePayee
