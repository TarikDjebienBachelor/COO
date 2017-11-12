package application.extensions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.Timer;

import application.extensions.events.PluginEvent;
import application.extensions.events.PluginListener;

public class PluginChecker
{
  private PluginEvent pluginEvent;
  private File extensionsDirectory;
  private int delaiMiseAJour;
  private List<PluginListener> listeDesPlugins;
  


  public PluginChecker(int delaiMiseAJour, String extensionsDirectory)
  {
    this.listeDesPlugins = new ArrayList<PluginListener>();
    this.delaiMiseAJour = delaiMiseAJour;
    this.extensionsDirectory = new File(extensionsDirectory);
    this.pluginEvent = null;
  }
 
 /* lancer l'analyse du repertoire des extensions tous les delay/ms pour la mise ajour de la liste des plugins courants disponibles */
  public void start() {
    new Timer(this.delaiMiseAJour, new DirectoryObserver()).start();
  }

  /* Methode pour creer le plugin evenement pour une extension donnee */
  private boolean createEvent(String extName)
  {
    String ext = extName.substring(0, extName.length() - 6);
    try {
      this.pluginEvent = new PluginEvent(this, (Extension)Class.forName(ext).newInstance());
      return true;
    } catch (Exception ex) {
      System.err.println(ext + " : plugin not found");
    }return false;
  }
  
  /* methode permetant d ajouter un nouvel plugin */
  
  public void addPlugin(String extName)
  {
    if (createEvent(extName))
      firePluginAdded();
  }

  private void firePluginAdded()
  {
    Iterator<PluginListener> listeners = new ArrayList<PluginListener>(this.listeDesPlugins).iterator();
    while (listeners.hasNext())
      ((PluginListener)listeners.next()).pluginAdded(this.pluginEvent);
  }

  /* methode permetant de supprimer un plugin */
  public void removePlugin(String extName)
  {
	
    if (createEvent(extName))
      firePluginRemoved();
  }

  private void firePluginRemoved() {
    Iterator<PluginListener> listeners = new ArrayList<PluginListener>(this.listeDesPlugins).iterator();
    while (listeners.hasNext())
      ((PluginListener)listeners.next()).pluginRemoved(this.pluginEvent);
  }

  public void addPluginListener(PluginListener listener)
  {
    this.listeDesPlugins.add(listener);
  }

  public void removePluginListener(PluginListener listener) {
    this.listeDesPlugins.remove(listener);
  }

  private class DirectoryObserver
    implements ActionListener
  {
    private Set<String> oldPlugins = new HashSet<String>();

    DirectoryObserver() {
    }
    
    public void actionPerformed(ActionEvent e) {
    Set<String> newPlugins = new HashSet<String>(Arrays.asList(PluginChecker.this.extensionsDirectory.list(FiltreExtension.getInstance())));
    Iterator<String> i = new HashSet<String>(this.oldPlugins).iterator();

    while (i.hasNext()){
      String extName = (String)i.next();
        if (!newPlugins.contains(extName)) {
          PluginChecker.this.removePlugin(extName);
          this.oldPlugins.remove(extName);
        }
      }
      i = newPlugins.iterator();
      while (i.hasNext()) {
        String extName = (String)i.next();
        if (!this.oldPlugins.contains(extName)) {
          PluginChecker.this.addPlugin(extName);
          this.oldPlugins.add(extName);
        }
      }
    }
  }
}

