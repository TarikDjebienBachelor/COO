/*
 * Created on 16 juin 2006
 *
 */
package vote;


/**
 * @author <a href="mailto:routier@lifl.fr">routier</a>
 *
 * TODO
 */
public class VoteNUL implements Vote {
   public static final VoteNUL SINGLETON = new VoteNUL("NUL");
   
   private VoteNUL(String s) {
      this.s = s;
   }
   private String s;
   
   public String toString() {
      return this.s;
   }
}
