package glace;

/**
 * @author <a href="mailto:routier@lifl.fr">routier</a>
 * 
 * TODO
 */

public class TripleChocolat extends CoupeGlacee {

   public static final TripleChocolat SINGLETON = new TripleChocolat();
   
   private TripleChocolat() {
      this.parfums.add(Parfum.CHOCOLAIT);
      this.parfums.add(Parfum.CHOCONOIR);
      this.parfums.add(Parfum.CHOCOBLANC);
   }
   /* (non-Javadoc)
    * @see glace.CoupeGlacee#cout()
    */
   public float cout() { 
      return 5;
   }

}
