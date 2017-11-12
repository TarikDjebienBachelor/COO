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

public class PolitiqueParDefautPourActiviteTicket implements PolitiqueDeParticipation {

   public static final PolitiqueParDefautPourActiviteTicket INSTANCE = new PolitiqueParDefautPourActiviteTicket();
   /**
    * 
    */
   private PolitiqueParDefautPourActiviteTicket() {    
   }

   /**
    * @see kermesse.PolitiqueDeParticipation#peutParticiper(kermesse.Personne)
    */
   public boolean peutParticiper(Personne p) {
      return true;
   }

   public String toString() {
      return "activite ouverte à tous";
   }
}
