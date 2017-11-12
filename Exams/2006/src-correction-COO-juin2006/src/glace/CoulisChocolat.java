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

public class CoulisChocolat extends DecorateurTopping {

   /**
    * @param coupe
    */
   public CoulisChocolat(CoupeGlacee coupe) {
      super(coupe); 
   }

   /* (non-Javadoc)
    * @see glace.CoupeGlacee#description()
    */
   public String description() {
      return this.coupe.description()+" recouvert de coulis de chocolat";
   }

   /* (non-Javadoc)
    * @see glace.CoupeGlacee#cout()
    */
   public float cout() {     
      return this.coupe.cout()+0.5f;
   }

}
