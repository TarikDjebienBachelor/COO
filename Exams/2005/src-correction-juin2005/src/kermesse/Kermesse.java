/*
 * Created on 29 avr. 2005
 *
 */
package kermesse;

import java.util.*;

/**
 * @author <a href="mailto:routier@lifl.fr">routier</a>
 * 
 * TODO
 */

public class Kermesse {

   private Ticket ticket;
   
   /**
    * 
    */
   public Kermesse(float valeurTicket) {
      this.ticket = new Ticket(valeurTicket);
      this.activites = new ArrayList();
   }
   
   public Ticket getTicket() {
      return this.ticket;
   }
   
   /**
    *  
    */
   private Collection activites;

   public void addActivite(Activite activite) {
      	this.activites.add(activite);
   }

   public Iterator getActivites() {
      return this.activites.iterator();
   }

   public float getCout() {
      float cout = 0;
      for(Iterator activite_it = this.getActivites(); activite_it.hasNext(); ) {
         cout = cout + ((Activite) activite_it.next()).getCout();
      }
      return cout;
   }

   public float getRecette(int nbParticipants) {
      float recette = 0;
      for(Iterator activite_it = this.getActivites(); activite_it.hasNext(); ) {
         recette = recette + ((Activite) activite_it.next()).getRecette(nbParticipants);
      }      
      return recette;
   }

   public float getSolde(int nbParticipants) {
      return this.getRecette(nbParticipants) - this.getCout();
   }

}
