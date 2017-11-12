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

public class PasAutoriseException extends Exception {

   public PasAutoriseException(Activite a) {
      super("contrainte de participation a"+a+"non satisfaite");
   }

}
