/*
 * Created on 16 juin 2006
 *
 */
package vote;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

/**
 * @author <a href="mailto:routier@lifl.fr">routier</a>
 *
 * TODO
 */
public abstract class Scrutin {

   protected Set lesVotesPossibles;
   protected Set lesVotants;
   protected List lesVotes;
   protected boolean estClos;
   protected Set ontVote;
   protected Map lesResultats;
   
   public Scrutin(Set lesVotants, Set lesVotesPossibles) {
      this.lesVotants = lesVotants;
      this.lesVotesPossibles = lesVotesPossibles;
      this.lesVotesPossibles.add(VoteNUL.SINGLETON);
      
      this.lesVotes = new ArrayList();
      this.ontVote = new HashSet();
      this.estClos = false;
      
      this.lesResultats = new HashMap();
      for (Iterator it = lesVotesPossibles.iterator(); it.hasNext(); ) {
         this.lesResultats.put(it.next(), new Integer(0));
      }
   }
   
   public final void vote(Votant votant) throws VoteImpossibleException {
       if (this.peutVoter(votant)) {
       Vote vote = votant.vote(this.lesVotesPossibles);
       this.enregistreVote(vote);
       this.aVote(votant);
       }
       else {
       throw new VoteImpossibleException ();
       }
      }
      /**
    * @param votant
    */
   private void aVote(Votant votant) {
      this.ontVote.add(votant);      
   }
      /**
    * @param votant
    * @return
    */
   private boolean peutVoter(Votant votant) {
      return (!this.estClos
            && !this.ontVote.contains(votant)
            && this.lesVotants.contains(votant));
   }
      
   private final void enregistreVote(Vote vote) {
       this.lesVotes.add(vote);
   }
   
   public float tauxParticipation() {
      return ((float) this.ontVote.size() / (float) this.lesVotants.size()) * 100.0f;
   }
   
   private void incrementeVote(Vote v) {
      Integer i = (Integer) this.lesResultats.get(v);
      this.lesResultats.put(v,new Integer(i.intValue()+1));
   }
   
   public void depouille(){
      this.estClos = true;
      for(Iterator it = this.lesVotes.iterator(); it.hasNext(); ) {
         Vote v = (Vote) it.next();
         if (this.lesVotesPossibles.contains(v)) {
            this.incrementeVote(v);
         } else {
            this.incrementeVote(VoteNUL.SINGLETON);
         }
      }
   }
   
   protected int score(Vote v) {
      return ((Integer) this.lesResultats.get(v)).intValue();
   }
   
   public abstract Vote getVainqueur();
   
 
   public void afficheResultat() {
      for(Iterator it = this.lesVotes.iterator(); it.hasNext(); ) {
         Vote v = (Vote) it.next();
         System.out.println(v+" : "+this.score(v));
      }
   }
}
