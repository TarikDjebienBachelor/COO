package introihm;

/**
 * TestInteraction.java
 *
 * @author <a href="mailto:jean-christophe.routier@lifl.fr">Jean-Christophe Routier</a>
 * @version
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TestInteraction {

	private JButton unBouton;

	private JLabel unLabel;


	public void test() {
		JFrame f = new JFrame("event frame");
		f.setLocation(100, 300);
		f.setSize(100, 100);

		f.setLayout(new FlowLayout());

		unBouton = new JButton("click ici");
		unLabel = new JLabel("depart");

		// abonnement d'un listener :
		unBouton.addActionListener(new InterneActionListenerTest());

		f.add(unBouton);
		f.add(unLabel);

		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new TestInteraction().test();
	}

	private class InterneActionListenerTest implements ActionListener {		
		private boolean truc = true;

		public void actionPerformed(ActionEvent e) {
			this.truc = !this.truc;
			TestInteraction.this.unLabel.setText(new Boolean(this.truc).toString());
		}
	}// InterneActionListenerTest

}// TestInteraction
