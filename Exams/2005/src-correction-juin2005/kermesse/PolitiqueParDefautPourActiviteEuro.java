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

public class PolitiqueParDefautPourActiviteEuro implements PolitiqueDeParticipation {

   private static final int AGE_LIMITE = 12;
   
   public static final PolitiqueParDefautPourActiviteEuro INSTANCE = new PolitiqueParDefautPourActiviteEuro(); 
   /**
    * 
    */
   private PolitiqueParDefautPourActiviteEuro() {
      super();
   }

   /**
    * @see kermesse.PolitiqueDeParticipation#peutParticiper(kermesse.Personne)
    */
   public boolean peutParticiper(Personne p) {
      return p.getAge() >= AGE_LIMITE;
   }

   public String toString() {
      return "activite reservee au plus de "+AGE_LIMITE+" ans";
   }

}
