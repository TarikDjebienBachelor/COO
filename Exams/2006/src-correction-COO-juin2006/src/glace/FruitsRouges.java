package glace;

/**
 * @author <a href="mailto:routier@lifl.fr">routier</a>
 * 
 * TODO
 */

public class FruitsRouges extends CoupeGlacee {

   public static final FruitsRouges SINGLETON = new FruitsRouges();
   
   private FruitsRouges() {
      this.parfums.add(Parfum.FRAISE);
      this.parfums.add(Parfum.FRAMBOISE);
      this.parfums.add(Parfum.CASSIS);
   }

   public float cout() { 
      return 6;
   }

}
