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

public class Parfum {

   public static final Parfum FRAISE = new Parfum("fraise");
   public static final Parfum FRAMBOISE = new Parfum("framboise");
   public static final Parfum CASSIS = new Parfum("cassis");
   public static final Parfum CHOCOLAIT = new Parfum("chocolat au lait");
   public static final Parfum CHOCONOIR = new Parfum("chocolat noit");
   public static final Parfum CHOCOBLANC = new Parfum("chocolat blanc");

   private String name;

   private Parfum(String s) {
      this.name = s;
   }

   public String toString() {
      return this.name;
   }

}
