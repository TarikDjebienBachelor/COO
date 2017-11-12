
import generics.*;
import enums.*;
import scanner.*;



public class BigMain {


    public static void main(String[] args) {


  System.out.println();
  System.out.println(" ----------------Dans ce TP on a 6 MAIN à executer ----------------");
  System.out.println(" Entrez 0 pour executer ListChoser  ");
  System.out.println(" Entrez 1 pour executer ListChoserLegume  ");
  System.out.println(" Entrez 2 pour executer ListChoserLegumeCloneable  ");
  System.out.println(" Entrez 3 pour executer Ramasseur ");
  System.out.println(" Entrez 4 pour executer ArcEnCiel ");
  System.out.println(" Entrez 5 pour executer Jour ");
  System.out.println("\n remarque : \n pour ArcEnCiel et Jour entrez le parametre selon la syntaxe suivante : \n java -jar generecite <parametre>\n");

        int choix = TestScanner.saisieEntier(6) ; //saisie d'un entier entre 0 et 6

        switch(choix)
        {
            case 0:
	      System.out.println(" --------------------------LISTCHOSER CHOISI  ---------------------------");
	      ListChoser.main(args);
            break;

            case 1:
	      System.out.println(" --------------------------LISTCHOSERLEGUME CHOISI  ---------------------------");
	      ListChoserLegume.main(args);
            break;

            case 2:
	      System.out.println(" --------------------------LISTCHOSERLEGUMECLONEABLE CHOISI  ---------------------------");
	      ListChoserLegumeCloneable.main(args);
            break;

            case 3:
	      System.out.println(" --------------------------RAMASSEUR CHOISI  ---------------------------");
	      Ramasseur.main(args);
            break;

            case 4:
	      System.out.println(" --------------------------ARCENCIEL CHOISI  ---------------------------");
	      ArcEnCiel.main(args);
            break;

            case 5:
	      System.out.println(" --------------------------JOUR CHOISI  ---------------------------");
	       Jour.main(args);
            break;


            default:
                  System.out.println(" Entrez un chiffre entre 1 et 6 !!  ");
            break;

        }





  }


}
