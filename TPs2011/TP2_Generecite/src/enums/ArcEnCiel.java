   /**
    @author : DJEBIEN Tarik
   */

package enums;

/** DÉFINITION DE LA CLASSE ENUMEREE ArcEnCiel = [rouge, orange, jaune, vert, bleu, indigo, violet]
 */
public enum ArcEnCiel {
  ROUGE,
  ORANGE,
  JAUNE,
  VERT,
  BLEU,
  INDIGO,
  VIOLET;


    public static void main(String[] args) {
//   si un argument est fourni (chaine de caracteres), initialise une reference a de type
//  ArcEnCiel avec l’objet ArcEnCiel dont l’identificateur correspond a cette chaine
//  si il existe, dans le cas contraire ou si aucun argument n’est fourni, on initialise a avec
//  la valeur correspondant a orange
  ArcEnCiel a ;
  try{
    if (args.length == 0) {
      a = ArcEnCiel.ORANGE;
    }else{
      a = ArcEnCiel.valueOf(args[0].toUpperCase());
    }
      System.out.println("La valeur entréé est : " + a.name());
  }catch (IllegalArgumentException e) {
      System.out.println("La valeur entréé n''appartient pas dans l'enum ArcEnCiel");
      a = ArcEnCiel.ORANGE; //j'initialise a pour pouvoir l'utiliser prochainement même si aucune valeur n'est entree
  }

// initialise une reference avec la valeur qui suit a dans le type enumere(avec violet suivi de rouge)
  ArcEnCiel nextDeA ;
  nextDeA = (ArcEnCiel.values()) [(a.ordinal() + 1) % ArcEnCiel.values().length ] ;
    System.out.println("Le suivant de  " + a.name() + " est : " + nextDeA.name());

//affiche toutes les valeurs definies dans ce type enumere
    System.out.println("----------VALEURS ARC EN CIEL ----------");
  for (ArcEnCiel tmp: ArcEnCiel.values()){
    System.out.print(tmp.name());System.out.print(" | ");
  }





}


}
