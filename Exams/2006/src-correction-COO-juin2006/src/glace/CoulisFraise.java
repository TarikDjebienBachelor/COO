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

public class CoulisFraise extends DecorateurTopping {

   /**
    * @param coupe
    */
   public CoulisFraise(CoupeGlacee coupe) {
      super(coupe); 
   }

   /* (non-Javadoc)
    * @see glace.CoupeGlacee#description()
    */
   public String description() {
      return this.coupe.description()+" et son coulis de fraise des bois";
   }

   /* (non-Javadoc)
    * @see glace.CoupeGlacee#cout()
    */
   public float cout() {     
      return this.coupe.cout()+1f;
   }

}
