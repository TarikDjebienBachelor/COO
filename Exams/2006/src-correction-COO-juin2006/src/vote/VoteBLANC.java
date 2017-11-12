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
public class VoteBLANC implements Vote {
   public static final VoteBLANC SINGLETON = new VoteBLANC("BLANC");
   
   private VoteBLANC(String s) {
      this.s = s;
   }
   private String s;
   
   public String toString() {
      return this.s;
   }
}
