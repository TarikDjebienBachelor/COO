/*
 * Created on 16 juin 2006
 *
 */
package vote;

import java.util.Iterator;
import java.util.Set;

/**
 * @author <a href="mailto:routier@lifl.fr">routier</a>
 *
 * TODO
 */
public class ScrutinRelatif extends Scrutin {

   /**
    * @param lesVotants
    * @param lesVotesPossibles
    */
   public ScrutinRelatif(Set lesVotants, Set lesVotesPossibles) {
      super(lesVotants, lesVotesPossibles);   
   }

   /* (non-Javadoc)
    * @see vote.Scrutin#getVainqueur()
    */
   public Vote getVainqueur() {
      Vote vainqueur = null;
      int scoreMax = 0;
      float quinze = 15.f*this.lesVotants.size()/ 100.f; 
      
      int score;
      for(Iterator it = this.lesVotes.iterator(); it.hasNext(); ) {
         Vote v = (Vote) it.next();
         score = this.score(v);
         if (score > scoreMax && score > quinze) {
            vainqueur = v;
         }
      }
      
      return vainqueur;
   }

}
