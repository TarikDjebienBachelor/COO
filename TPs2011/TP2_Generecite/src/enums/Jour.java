   /** 
    @author : DJEBIEN Tarik
   */


package enums;
import scanner.TestScanner ; 


/** DÉFINITION DE LA CLASSE ENUMEREE Jour */


public enum Jour {
  LUNDI(true), 
  MARDI(true), 
  MERCREDI(true), 
  JEUDI(true), 
  VENDREDI(true), 
  SAMEDI(false),
  DIMANCHE(false);
  
  /** L'attribut qui contient la valeur associé à l'enum */
  private Boolean estTravaille ; 


  /** Constructeur*/
  private Jour(Boolean estTravaille){
    this.estTravaille=estTravaille;
  }

  /** méthode lendemain, renvoie le jour suivant dans la semaine
  @param j le jour sur lequel est basé le calcul de lendemain
  @return le lendemain du jour j 
  */
  public Jour lendemain(){
    return ( (Jour.values()) [(this.ordinal() + 1) % Jour.values().length] ); 
  }

  /** 
  methode estTravaille, permet de savoir si le jour est ou non travaille
  @param j le jour sur lequel on teste s'il est ou non travaillé
  @return predicat qui teste s'il est ou non travaille
  */
  public Boolean estTravaille(){
    if (this.estTravaille){ 
      System.out.println(" => Le jour " + this.name() + " est un jour travaille " );
      return true ; 
    }else{
      System.out.println(" => Le jour " + this.name() + " est un jour de repos " );
      return false ; 
      }
  }

  public static void main(String[] args) {

  // a partir d’un nom de jour passe en parametre on affiche a partir de ce jour les 7 jours de la semaine en precisant si ils sont ou non travailles.
    System.out.println();
    Jour j ;
    try{
      if (args.length == 0) {
	j = Jour.LUNDI;
      }else{ 
	j= Jour.valueOf(args[0].toUpperCase());
      }
	System.out.println("La valeur entréé est : " + j.name());
    }catch (IllegalArgumentException e) {
	System.out.println("La valeur entréé n'appartient pas à l'enum JOUR, par défaut on va mettre LUNDI");
	j = Jour.LUNDI; 
    }

// a partir d’un nom de jour passe en parametre on affiche a partir de ce jour 
// les 7 jours de la semaine en precisant si ils sont ou non travailles.
  System.out.println();
  System.out.println("----------VALEURS JOUR EN COMPTANT A PARTIR DE LA VALEUR ----------");
  Jour[] tabJour = Jour.values();
  int indiceDeJ=j.ordinal();
  for (int l = indiceDeJ ; l <= (tabJour.length + indiceDeJ-1) ; l ++){
    System.out.println(tabJour[l%tabJour.length] ); tabJour[l%tabJour.length].estTravaille();
  }

//  saisir un entier correspondant a un numero de jour dans la semaine et afficher la chaine de caracteres representant ce jour
// (ainsi pour 2 on aura l’affichage de mercredi).
  System.out.println();
  System.out.println("----------EN UTILISANT UN ENTIER INDIQUANT L'INDICE Du JOUR ----------");
  System.out.println("Entrez un entier ");
  int entierEntre = TestScanner.saisieEntier(7) ; //saisie d'un entier entre 0 et 6
  System.out.println("Le jour correspondant à  " + entierEntre + " est : " + tabJour [ entierEntre  ]  );
  }   
};
