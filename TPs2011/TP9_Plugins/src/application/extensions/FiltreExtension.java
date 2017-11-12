package application.extensions;

import java.io.File;
import java.io.FilenameFilter;


/* classe permettant de filtrer les differnetrepertoire */

public final class FiltreExtension implements FilenameFilter
{ 
  /* Utilisation du design pattern SINGLETON : UNE SEULE INSTANCE DE L'EXTENSION DES FILTRES  */
  
  private static final FiltreExtension SINGLETON = new FiltreExtension();

  public static FiltreExtension getInstance() 
  { 
  	return SINGLETON;
  }


public boolean accept(File dir, String nomDeLextension)
  {
    if (!nomDeLextension.endsWith(".class")) 
        return false;
    
    nomDeLextension = nomDeLextension.substring(0, nomDeLextension.length() - 6);
    
    Class<?> c = null;
    try {
      c = Class.forName(nomDeLextension);
      if (c.isInterface()) return false;

      return Extension.class.isAssignableFrom(c);
    } 
    catch (NoClassDefFoundError e)
    {
      return false; } catch (ClassNotFoundException e) {
    }
    return false;
  }
}
