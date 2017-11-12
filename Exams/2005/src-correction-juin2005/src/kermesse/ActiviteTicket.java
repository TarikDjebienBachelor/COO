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

public class ActiviteTicket extends Activite {

   protected Ticket ticket;
   
   /**
    * @param nom
    * @param tarif
    * @param p
    */
   public ActiviteTicket(String nom, float cout, float tarif, Ticket ticket) {
      super(nom, cout, tarif, PolitiqueParDefautPourActiviteTicket.INSTANCE);
      this.ticket = ticket;
   }

   /* (non-Javadoc)
    * @see kermesse.Activite#getRecette(int)
    */
   public float getRecette(int nbParticipants) {      
      return tarif*nbParticipants*this.ticket.getValeur();
   }

   /**
    * @see kermesse.Activite#getMonnaie()
    */
   public Monnaie getMonnaie() {
      return Monnaie.TICKET;
   }
}
