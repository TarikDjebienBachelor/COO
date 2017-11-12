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
public class ScrutinMajoritaire extends Scrutin {

   /**
    * @param lesVotants
    * @param lesVotesPossibles
    */
   public ScrutinMajoritaire(Set lesVotants, Set lesVotesPossibles) {
      super(lesVotants, lesVotesPossibles);
   }

   /* (non-Javadoc)
    * @see vote.Scrutin#getVainqueur()
    */
   public Vote getVainqueur() {
      int blancs = this.score(VoteBLANC.SINGLETON);
      int nuls = this.score(VoteNUL.SINGLETON);
      int majo = (this.lesVotes.size() - blancs - nuls) / 2; // eventuellement + 1 à cause arrondi
      
      Vote vainqueur = null;
      
      for(Iterator it = this.lesVotes.iterator(); it.hasNext(); ) {
         Vote v = (Vote) it.next();
         if (this.score(v) > majo) {
            vainqueur = v;
         }
      }
      
      return vainqueur;
   }

}
