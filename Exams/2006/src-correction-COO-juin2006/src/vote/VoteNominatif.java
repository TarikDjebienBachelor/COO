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
public class VoteNominatif implements Vote {
   
   public VoteNominatif(String s) {
      this.s = s;
   }
   private String s;
   
   public String toString() {
      return this.s;
   }
   
   
   /* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
   public boolean equals(Object o) {
      if (o instanceof VoteNominatif) {
         return this.s.equals(((VoteNominatif) o).s);
      } 
      else {
         return false;
      }
   }
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {     
      return this.s.hashCode();
   }
}
