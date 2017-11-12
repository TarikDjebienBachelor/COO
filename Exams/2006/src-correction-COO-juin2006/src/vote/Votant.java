/*
 * Created on 16 juin 2006
 *
 */
package vote;

import java.util.Set;

/**
 * @author <a href="mailto:routier@lifl.fr">routier</a>
 *
 * TODO
 */
public interface Votant {
   public Vote vote(Set votesPossibles);
   public int hashCode();
   public boolean equals(Object o);
}
