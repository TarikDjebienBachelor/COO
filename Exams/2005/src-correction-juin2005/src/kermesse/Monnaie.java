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

public class Monnaie {

   private String nom;
   
   public static final Monnaie TICKET = new Monnaie("K");
   public static final Monnaie EURO = new Monnaie("Euro");
   
   /**
    * 
    */
   private Monnaie(String nom) {
      this.nom = nom;
   }
   public String toString() {
      return this.nom;
   }
   
}
