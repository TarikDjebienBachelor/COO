package generics;

import scanner.*;
import java.util.*;

public class ListChoserLegume {

    // methode chose
    // elle est similaire a celle de ListChoser simplement elle ne fonctionne
    // qu'avec des listes d'objets de type Legume (cf. interface Legume)
    // quel changement apporter a la methode de ListChoser  ?
    public <T extends Legume > T chose (String s,List<T> L){
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
	List<Carotte> lCarottes = new ArrayList<Carotte>();
	lCarottes.add(new Carotte(1));
	lCarottes.add(new Carotte(2));
	lCarottes.add(new Carotte(3));

	List<Pomme> lPommes = new ArrayList<Pomme>();
	lPommes.add(new Pomme(1));
	lPommes.add(new Pomme(2));
	lPommes.add(new Pomme(3));

	ListChoserLegume lcl = new ListChoserLegume();

	Carotte choixCarotte = lcl.chose("quelle carotte ? ",lCarottes);
	System.out.println("vous avez choisi : "+choixCarotte);

	// NE COMPILE PAS :
	// Pomme choixPomme = lcl.chose("quelle pomme ? ",lPommes);

	// Explication :

	// choixPomme est une reference de type Pomme qui n'est pas un sous type de Legume
	// or le type de retour de la methode generique chose est
	// <T extends Legume> qui peut se traduire par :

	// "n'importe quels sous type T de Legume avec T le type des elements de la liste L en parametre."

	// Ici T = Pomme mais <Pomme extends Legume> provoque une erreur à la compilation d'ordre semantique.
	// En effet, une pomme ...n'est pas un legume !

    }
}
