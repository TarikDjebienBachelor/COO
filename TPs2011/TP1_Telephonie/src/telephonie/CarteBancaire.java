
package telephonie;

import java.util.*;

import telephonie.util.Date;

public class CarteBancaire implements ModeDePaiement {
   // le solde de la carte bancaire en valeur entiere de centime d'euro
   private int solde;

   // le constructeur d'initialisation :
   public CarteBancaire(int s){
	   this.solde = s ;
   }// CarteBancaire

   // Une carte bancaire est toujours valide par definition
   public boolean valide(){
	return true;
   }// valide

   // Elles sont donc debitees d'une somme correspondant à :
   public void debiter(int dureeComptabilisee , int tarifUnitaireApplique) {
       this.solde = this.solde - (dureeComptabilisee*tarifUnitaireApplique);
       // trace pour visualiser l'operation de debit :
       System.out.println(" La carte bancaire a été debité de :"+dureeComptabilisee*tarifUnitaireApplique+" centimes d'euros.\n");
       System.out.println(" Son solde courant est dorenavant évalué à :"+this.getSolde()+" centimes d'euros.\n");
   }// debiter

   public int getSolde(){
   return this.solde;
   }//getSolde
}
