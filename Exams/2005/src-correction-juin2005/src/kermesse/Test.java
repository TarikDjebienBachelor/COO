/*
 * Created on 29 avr. 2005
 *
 */
package kermesse;

import java.util.Iterator;

/**
 * @author <a href="mailto:routier@lifl.fr">routier</a>
 * 
 * TODO
 */

public class Test {

   public static void main(String[] args) {      
      Kermesse k = new Kermesse(0.5f);
      // les activites
      Activite a;
      a = new ActiviteEuro("vente de patisseries",0,2);
      k.addActivite(a);
      k.addActivite(new ActiviteEuro("buvette",0,2));
      k.addActivite(new ActiviteEuro("tombola",600,1));
      k.addActivite(new ActiviteTicket("marionnettes en carton",30,1,k.getTicket()));
      k.addActivite(new ActiviteTicket("jeu de massacres",40,1,k.getTicket()));
      k.addActivite(new ActiviteTicket("pêche à la ligne",40,1,k.getTicket()));
      k.addActivite(new ActiviteTicket("jeu d'adresse",40,1,k.getTicket()));
      a = new ActiviteTicket("stand maquillage",150,2,k.getTicket());
      a.setPolitiqueDeParticipation(PolitiquePourActiviteMaquillage.INSTANCE);
      k.addActivite(a);
      // affichages
      System.out.println("Le ticket vaut "+k.getTicket().getValeur()+" euro\n");
      for(Iterator activite_it = k.getActivites(); activite_it.hasNext(); ) {
         System.out.println(" - "+activite_it.next().toString());
      }
      System.out.println("\nCout de la kermesse "+k.getCout());
      System.out.println("\nRecette estimée pour 50 = "+k.getRecette(50)+" Solde estimé pour 50 = "+k.getSolde(50));
      System.out.println("Recette estimée pour 200 = "+k.getRecette(200)+" Solde estimé pour 200 = "+k.getSolde(200));
   }
}
