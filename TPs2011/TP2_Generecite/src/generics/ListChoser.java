package generics;

import scanner.*;
import java.util.*;

public class ListChoser {

    // Definir la methode chose, qui prend en premier parametre
    // un message sous forme de chaene de caracteres et en second une liste.
    // Cette liste est typee mais sans restriction sur les types admis.
    // Cette methode propose de choisir un element de la liste en saisissant
    // sa position dans la liste.
    // L'element choisi est retourne par la methode, null si le choix 0 est fait.
    //
    public <T> T chose (String s,List<T> L){
	// On affiche le menu
	for (int i=0;i < L.size();i++)
	System.out.println("Element index "+(i+1)+" : "+L.get(i));
	// On demande à l'utilisateur
	System.out.println(s);
	int j = TestScanner.saisieEntier(L.size()+1);
	if (j == 0) {
		System.out.println("vous n'avez saisi aucune valeur");
		return null;
		}

	else {
		System.out.println("vous avez saisi : "+L.get(j-1).toString());
		return L.get(j-1);
		}
	}

    public static void main(String[] args) {
	// JEU DE TEST

	List<Carotte> lCarottes = new ArrayList<Carotte>();
	lCarottes.add(new Carotte(1));
	lCarottes.add(new Carotte(2));
	lCarottes.add(new Carotte(3));

	List<Pomme> lPommes = new ArrayList<Pomme>();
	lPommes.add(new Pomme(1));
	lPommes.add(new Pomme(2));
	lPommes.add(new Pomme(3));

	ListChoser lc = new ListChoser();

	Carotte choixCarotte = lc.chose("quelle carotte ? ",lCarottes);
	System.out.println("vous avez choisi : "+choixCarotte);

	Pomme choixPomme = lc.chose("quelle pomme ? ",lPommes);
	System.out.println("vous avez choisi : "+choixPomme);

	// NE COMPILE PAS
	//Pomme choixPomme2 = lc.chose("probleme ",lCarottes);

    // Explication :

    // On a une incompatibilité de types entre deux references,
    // on tente d'affecter une reference de type Carotte dans un objet de reference de type Pomme.
    // La methode generique fixe un seul type de retour generique T, celui ci certe peut etre soit de type Pomme ou Carotte
    // mais lors de l'envoi de message de la methode generique la JVM conserve le type generique T choisit.
    // On ne peut donc pas affecter par la suite deux references de types differents,
    // ceci etant vrai dans tout le langage JAVA hors contexte de generecité.
    }
}
