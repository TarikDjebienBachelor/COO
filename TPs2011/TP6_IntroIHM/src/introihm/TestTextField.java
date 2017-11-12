package introihm;

/**
 * TestTextField.java
 *
 * @author <a href="mailto:jean-christophe.routier@lifl.fr">Jean-Christophe Routier</a>
 * @version
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TestTextField {

	private JButton unBouton;

	private JLabel unLabel;

	private JTextField unTexte;


	public void test() {
		JFrame f = new JFrame("event frame");
		f.setLocation(100, 300);
		f.setSize(100, 100);
		f.addWindowListener(new FermeWindowEvent());

		f.setLayout(new BorderLayout());

		unBouton = new JButton("click ici");
		unLabel = new JLabel("depart");
		unTexte = new JTextField();

		// abonnement d'un listener unBouton
		unBouton.addActionListener(new UnBoutonActionListenerTest());
		// abonnement d'un listener à unTexte
		unTexte.addActionListener(new UnTexteActionListenerTest());
		unTexte.addKeyListener(new UnTexteKeyListener());

		f.add(unBouton, BorderLayout.NORTH);
		f.add(unLabel, BorderLayout.CENTER);
		f.add(unTexte, BorderLayout.SOUTH);

		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new TestTextField().test();
	}

	//
	// CLASSES INTERNES POUR LES EVENEMENTS
	//
	private class UnBoutonActionListenerTest implements ActionListener {
		private boolean truc = true;
		public void actionPerformed(ActionEvent e) {
			this.truc = ! this.truc;
			TestTextField.this.unLabel.setText(new Boolean(this.truc).toString());
		}
	}// 

	private class UnTexteActionListenerTest implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TestTextField.this.unLabel.setText(unTexte.getText());
		}
	}// 

	private class UnTexteKeyListener implements KeyListener {
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			if (c == 'X') {
				TestTextField.this.unBouton.setText("XXXXXXX");
			} else if (c == 'x') {
				TestTextField.this.unBouton.setText("click ici");
			}
		}

		// obligatoire à cause de l'interface KeyListener mais ici on ne souhaite rien faire dans ce casa
		public void keyPressed(KeyEvent e) {
		}
		// obligatoire à cause de l'interface KeyListener mais ici on ne souhaite rien faire dans ce casa
		public void keyReleased(KeyEvent e) {
		}
	}

	private class FermeWindowEvent extends WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent e) {
			System.exit(0);
		}
	}

}// TestTextField
