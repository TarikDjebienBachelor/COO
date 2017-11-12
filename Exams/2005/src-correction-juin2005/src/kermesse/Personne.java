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

public class Personne {

 
   public Personne(String nom, int age) {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    *  
    */
   private String nom;

   /**
    *  
    */
   public String getNom() {
      return this.nom;
   }

   /**
    *  
    */
   private int age;

   /**
    *  
    * @uml.property name="age"
    */
   public int getAge() {
      return this.age;
   }

}
