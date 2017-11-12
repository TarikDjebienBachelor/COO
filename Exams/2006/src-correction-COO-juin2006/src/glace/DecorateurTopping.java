/*
 * Created on 12 juin 2006
 *
 */
package glace;

/**
 * @author <a href="mailto:routier@lifl.fr">routier</a>
 * 
 * TODO
 */

public abstract class DecorateurTopping extends CoupeGlacee {

   protected CoupeGlacee coupe;
   
   /* (non-Javadoc)
    * @see glace.CoupeGlacee#description()
    */
   public abstract String description();
   /**
    * 
    */
   public DecorateurTopping(CoupeGlacee coupe) {
      super();
      this.coupe = coupe;
   }


}
