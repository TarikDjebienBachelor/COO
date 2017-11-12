/*
 * Created on 29 avr. 2005
 *
 */
package kermesse;

/**
 * @author <a href="mailto:routier@lifl.fr">routier</a>
 * 
 * TODO
 */

public class ActiviteEuro extends Activite {

   /**
    * @param nom
    * @param tarif
    * @param p
    */
   public ActiviteEuro(String nom, float cout, float tarif) {
      super(nom, cout, tarif, PolitiqueParDefautPourActiviteEuro.INSTANCE);
   }

   /**
    * @see kermesse.Activite#getRecette(int)
    */
   public float getRecette(int nbParticipants) {      
      return tarif*nbParticipants;
   }
   
   /**
    * @see kermesse.Activite#getMonnaie()
    */
   public Monnaie getMonnaie() {
      return Monnaie.EURO;
   }

}
