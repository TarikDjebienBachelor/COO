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
public class VoteOUI implements Vote {
   public static final VoteOUI SINGLETON = new VoteOUI("OUI");
   
   private VoteOUI(String s) {
      this.s = s;
   }
   private String s;
   
   public String toString() {
      return this.s;
   }
}
