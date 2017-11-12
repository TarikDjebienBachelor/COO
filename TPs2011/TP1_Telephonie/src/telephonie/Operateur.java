
package telephonie;

import telephonie.util.Date;


public interface Operateur {

   public Connexion seConnecter(Date debut, ModeDePaiement m) throws OperateurSatureException, ModeDePaiementInvalideException;

   public void seDeconnecter(Connexion c, Date fin) throws PasDeConnexionException;

   public int getDureeComptabilisee(Connexion c);

   public int getTarifUnitaire(Connexion c);
}
