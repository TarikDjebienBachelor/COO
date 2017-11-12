/*
 * Created on 16 juin 2006
 *
 */
package glace;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/**
 * @author <a href="mailto:routier@lifl.fr">routier</a>
 *
 * TODO
 */
public class Commande {

   protected List lesCoupes; 
   
   /**
    * 
    */
   public Commande() {
   }
   
   public void addCoupe(CoupeGlacee coupe) {
      	this.lesCoupes.add(coupe);
   }

   public void publieFacture(PrintWriter writer) {
      float total = 0;
      for (Iterator it = this.lesCoupes.iterator(); it.hasNext();) {
        CoupeGlacee coupe =  (CoupeGlacee) it.next();
        writer.println(coupe.description()+" + "+coupe.cout());
        total = total + coupe.cout();
      }
      writer.println("   TOTAL : "+total);
   }
   
}
