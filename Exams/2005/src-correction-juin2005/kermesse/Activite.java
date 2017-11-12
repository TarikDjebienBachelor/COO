/*
 * Created on 29 avr. 2005
 *
 */
package kermesse;

/**
 * @author <a href="mailto:routier@lifl.fr">routier</a>
 * 
 * TODO
 */

public abstract class Activite {

   /**
    * 
    */
   public Activite(String nom, float cout,float tarif, PolitiqueDeParticipation p) {
      this.nom = nom;
      this.cout = cout;
      this.tarif = tarif;
      this.politiqueDeParticipation = p;      
   }

   /**
    *  
    */
   protected String nom;

   /**
    *  
    */
   public String getNom() {
      return this.nom;
   }

   /**
    *  
    */
   protected float tarif;

   /**
    *  
    */
   public float getTarif() {
      return this.tarif;
   }

   /**
    *  
    */
   protected float cout;

   /**
    *  
    */
   public float getCout() {
      return this.cout;
   }

   public void participe(Personne p) throws PasAutoriseException {
      if (! this.politiqueDeParticipation.peutParticiper(p)) {
         throw new PasAutoriseException(this);
      }
      System.out.println(p.getNom()+" participe a "+this.nom);
   }

   public String toString() {
      return this.nom+", tarif : "+this.tarif+" "+this.getMonnaie()+", "+this.politiqueDeParticipation;
   }

   /**
    *  
    * @uml.property name="politiqueDeParticipation" multiplicity="(0 1)"
    */
   protected PolitiqueDeParticipation politiqueDeParticipation;

   /**
    *  
    * @uml.property name="politiqueDeParticipation"
    */
   public void setPolitiqueDeParticipation(PolitiqueDeParticipation politiqueDeParticipation) {
      this.politiqueDeParticipation = politiqueDeParticipation;
   }

   public abstract float getRecette(int nbParticipants);
   public abstract Monnaie getMonnaie();
}
