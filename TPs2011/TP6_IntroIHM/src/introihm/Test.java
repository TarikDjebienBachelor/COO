package introihm;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Test {

	public void testFenetre() {
		// JFrame : une fenêtre avec la barre fournie par l'environnement graphique
		JFrame f = new JFrame("frame");
		f.addWindowListener(new FermeWindowEvent());
		f.setSize(200, 200);
		f.setLocation(100, 100);

		f.setVisible(true);

		// JWindow : une fenêtre "brute", que la zone "d'affichage"
		JWindow w = new JWindow();
		w.setSize(200, 200);
		w.setLocation(500, 100);

		w.setVisible(true);
	}

	/*
	 * on utilise le conteneur par défaut "getContentPane"
	 */
	public void testGetContentPane() {
		JFrame f = new JFrame("getContent frame");
		f.addWindowListener(new FermeWindowEvent());
		f.setLocation(100, 300);

		f.add(new JLabel("Label"));
		f.add(new JButton("Button"));

		// /!\ NB : avant le 1.5 f.add(Component) n'était pas possible, il fallait dans ce cas
		// remplacer les 2 lignes précédentes par :
		// Container content = f.getContentPane();
		// content.setLayout(new FlowLayout());
		// content.add(new JLabel("Label"));
		// content.add(new JButton("Button"));

		f.pack();
		f.setVisible(true);
	}

	/*
	 * La différence avec la méthode précédente est la création d'un container ("content") qui est,
	 * une fois "rempli", désigné comme conteneur (setContentPane) de la fenêtre
	 */
	public void testSetContentPane() {
		JFrame f = new JFrame("setContent frame");
		f.addWindowListener(new FermeWindowEvent());
		f.setLocation(200, 300);

		Container content = new JPanel();
		content.setLayout(new FlowLayout());
		content.add(new JLabel("Label"));
		content.add(new JButton("Button"));

		// la difference avec methoode precedente est ici (plus les 4 lignes ci-dessus)
		// on n'utilise pas le "contenpane" par défaut, voir interet avec methoode suivante
		f.setContentPane(content);

		f.pack();
		f.setVisible(true);
	}

	/*
	 * pour illustrer l'intérêt d'avoir des conteneurs différents du conteneur par défaut, on fait
	 * changer le contenu de la fenêtre toutes les 2 secondes grâce à 2 container définis.
	 */
	public void testSetContentPaneBis() {
		JFrame f = new JFrame("changement du contenu toutes les 2 secondes (setContent frame bis)");
		f.addWindowListener(new FermeWindowEvent());
		f.setLocation(250, 300);
		f.setVisible(true);
		boolean alternance = true;

		// déifnition du premier conteneur
		Container content = new JPanel();
		content.setLayout(new GridLayout(2, 1));
		content.add(new JLabel("ATTENTION"));
		content.add(new JButton("Button"));
		// définition du second conteneur
		Container content2 = new JPanel();
		content2.setLayout(new FlowLayout());
		content2.add(new JLabel("CA A CHANGE !"));
		content2.add(new JButton("UN AUTRE Button"));

		// on utilise alternativement l'un ou l'autre des conteneurs
		while (true) {
			if (alternance) {
				f.setContentPane(content);
			} else { // alternance = false
				f.setContentPane(content2);
			}
			f.pack(); // mise à jour
			f.validate();
			alternance = !alternance; // on change !!!
			// pause de 2 secondes
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/*
	 * placement des éléments avec un FlowLayout : tant qu'on peut de gauche à droite puis de haut en
	 * bas
	 */
	public void testFlowLayout() {
		JFrame f = new JFrame("flow frame");
		f.addWindowListener(new FermeWindowEvent());
		f.setLocation(100, 400);

		f.setLayout(new FlowLayout());

		f.add(new JButton("b1"));
		f.add(new JButton("b2"));
		f.add(new JButton("b3"));
		f.add(new JButton("b4"));
		f.add(new JButton("b5"));
		f.add(new JButton("b6"));

		f.pack();
		f.setVisible(true);
	}

	/*
	 * placement des éléments avec un BorderLayout : notion de Nord,Sud,...
	 */
	public void testBorderLayout() {
		JFrame f = new JFrame("border frame");
		f.addWindowListener(new FermeWindowEvent());
		f.setLocation(200, 400);

		f.setLayout(new BorderLayout());

		f.add(new JButton("b1"), BorderLayout.NORTH);
		f.add(new JButton("b2"), BorderLayout.SOUTH);
		f.add(new JButton("b3"), BorderLayout.EAST);
		f.add(new JButton("b4"), BorderLayout.WEST);
		f.add(new JButton("b5"), BorderLayout.CENTER);
		f.add(new JButton("b6"), BorderLayout.NORTH); // meme endroit que B1

		f.pack();
		f.setVisible(true);
	}

	/*
	 * placement des éléments avec un GridLayout : ici une grille de 3 lignes et 2 colonnes, chaque
	 * élément est placé dans une "case" donnée
	 */
	public void testGridLayout() {
		JFrame f = new JFrame("grid frame");
		f.addWindowListener(new FermeWindowEvent());
		f.setLocation(300, 400);

		f.setLayout(new GridLayout(3, 2));

		f.add(new JButton("b1"));
		f.add(new JButton("b2"));
		f.add(new JButton("b3"));
		f.add(new JButton("b4"));
		f.add(new JButton("b5"));
		f.add(new JButton("b6"));

		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args) {
		Test t = new Test();

		/* décommentez (et "re"commentez) les lignes suivantes une par une en fonction du sujet de TP les codes à tester suivant */

		t.testFenetre();
		//t.testGetContentPane();
		//t.testSetContentPane();
		//t.testSetContentPaneBis();

		/*
		 * comparer ces trois layouts en redimensionnant les fenêtres créées avec chacun d'entre eux,
		 * vous pouvez les afficher à 3 en même temps
		 */
		t.testFlowLayout();
		t.testBorderLayout();
		t.testGridLayout();
	}

	// ----------------------------------------------------------------------
	// CLASSE INTERNE, revue au point 2.5 du sujet de TP
	class FermeWindowEvent extends WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent e) {
			System.exit(0);
		}
	}

}
