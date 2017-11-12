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
public class VoteNON implements Vote {
   public static final VoteNON SINGLETON = new VoteNON("NON");
   
   private VoteNON(String s) {
      this.s = s;
   }
   private String s;
   
   public String toString() {
      return this.s;
   }
}
