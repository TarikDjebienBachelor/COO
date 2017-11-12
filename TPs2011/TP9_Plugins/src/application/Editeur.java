package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import application.extensions.Extension;
import application.extensions.PluginChecker;
import application.extensions.events.PluginEvent;
import application.extensions.events.PluginListener;

public class Editeur
{
  private JFrame maFrame;
  private PluginChecker gestionnairePlugins;
  private JMenu outils;
  private JTextArea zoneDeTexte;
 


  public Editeur(String extensionsDirectory)
  {
    
    this.maFrame = new JFrame(" Final TP : plugins implementation  ");
    this.maFrame.setDefaultCloseOperation(3);
    this.zoneDeTexte = new JTextArea(35, 60);

    JMenuBar menuBar = new JMenuBar();
    JMenu fichier = new JMenu("File");
    JMenu help = new JMenu("help");
    menuBar.add(fichier);
    this.outils = new JMenu("tools");
    menuBar.add(this.outils);
    fichier.add(new Nouveau());
    fichier.add(new Item(new Ouvrir() ));
    fichier.addSeparator();
    fichier.add(new JMenuItem("save"));
    fichier.add(new JMenuItem("save as .."));
    fichier.addSeparator();
    fichier.add(new Item(new Quitter()));
    menuBar.add(help);
    help.add(new Version());
    help.add(new Auteur());
    help.add(new Apropos());
    
    this.maFrame.setJMenuBar(menuBar);
    this.maFrame.getContentPane().add(new JScrollPane(this.zoneDeTexte), "Center");
    this.maFrame.pack();
    this.maFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.gestionnairePlugins = new PluginChecker(1000, extensionsDirectory);
    this.gestionnairePlugins.addPluginListener(new OutilsListener());
  }

  public void start()
  {
    this.maFrame.setVisible(true);
    this.gestionnairePlugins.start();
  }

  public static void main(String[] args)
  {
    String path;
    if (args.length > 0) 
       path = args[0]; 
    else
      path = "extensions";
    new Editeur(path).start();
  }

  /* Classe Item herite de JMenuItem 
   * permet de gérer les plugins sur le GUI
   * permet de transformer une partie de texte selectionnée selon les plugins disponibles 
   */
  
  private class Item extends JMenuItem implements ActionListener
  {
    private Extension e;
    private static final long serialVersionUID = 1L;
	
    Item(Extension e)
    {
      super(e.toString());
      this.e = e;
      addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
      
     try {
    	  Editeur.this.zoneDeTexte.replaceSelection(this.e.transformer(Editeur.this.zoneDeTexte.getSelectedText()));
         }
    		  catch (NullPointerException e1) {
  	JOptionPane.showMessageDialog(null,"merci de séléctionner du texte pour appliquer la transformation ", "Aucun Texte n'est séléctionné !!",0);
      }
    }
  }
  
  private class Auteur extends JMenuItem implements ActionListener{

	private static final long serialVersionUID = 1L;

  public Auteur()
  {
    super(" Authors ");
    addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
	  JOptionPane.showMessageDialog(null, "Mr.YOULHAJEN Jamal dine \n \t& \n Mr.DJEBIEN Tarik \n" , "auteurs",1);

  }
}

  private class Version extends JMenuItem implements ActionListener{

	private static final long serialVersionUID = 1L;

  public Version()
  {
    super(" version ");
    addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
	  JOptionPane.showMessageDialog(null, "Editeur java  avec prise en charge des plugins v1.0 \n"
	                             +"  2010/2011  \n" , "version de l application ",1);

  }
}


private class Apropos extends JMenuItem implements ActionListener{

	private static final long serialVersionUID = 1L;

  public Apropos()
  {
    super(" About ");
    addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
	  JOptionPane.showMessageDialog(null,"L3 Informatique \n          Groupe 2   \n"+
	  		" \n \n Contact :jamaldine.youlhajen@gmail.com \n \t djebien.tarik@etudiant.univ-lille1.fr \n" +
	  		"\n\n                                          \n", "à propos de l'application",1);

  }
}
  

  class Nouveau extends JMenuItem implements ActionListener {
    Nouveau() {
     super(" New ");
     addActionListener(this);
    }

  public void actionPerformed(ActionEvent e) {
  Editeur.this.zoneDeTexte.setText("");
 
  }

  }
  




  private class OutilsListener implements PluginListener
  {
    private OutilsListener()
    {
    }

    public void pluginAdded(PluginEvent e)
    {
          Editeur.this.outils.add(new Item(e.getExtension()));
    }
    
    public void pluginRemoved(PluginEvent e) {
      for (int i = 0; i < Editeur.this.outils.getItemCount(); i++)
        if (Editeur.this.outils.getItem(i).getText().equals(e.getExtension().toString())) {
          Editeur.this.outils.remove(i);
          return;
        }
    }
  }

  /* Classe Ouvrir permet de ouvrir un fichier */
  public class Ouvrir implements Extension
  {
   public Ouvrir()
    {
    }

    public String transformer(String s)
    {
      StringBuffer r = new StringBuffer("");
      JFileChooser inDialog = new JFileChooser();
      if (inDialog.showOpenDialog(Editeur.this.maFrame) == 0) {
        try {
          BufferedReader in = new BufferedReader(new FileReader(inDialog.getSelectedFile()));
          Editeur.this.zoneDeTexte.setText("");
          String ligne;
          while ((ligne = in.readLine()) != null)
          {
            r.append(ligne + "\n");
          }
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(Editeur.this.maFrame, "impossible de lire le fichier  " + 
            inDialog.getSelectedFile().getName());
          return s;
        }
        return r.toString();
      }return s;
    }
    public String toString() { return "Open"; } 
  }
  
  public class Quitter implements Extension {
    
    public Quitter(){}
    public String toString(){ 
    return "Close";
    }
    public String transformer(String s){
    System.exit(0);
    return Editeur.this.zoneDeTexte.getText();
    } 
  }
}

