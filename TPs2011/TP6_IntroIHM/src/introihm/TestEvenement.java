package introihm;

/**
 * TestEvenement.java
 *
 * @author <a href="mailto:jean-christophe.routier@lifl.fr">Jean-Christophe Routier</a>
 * @version
 */
import java.awt.FlowLayout;
import introihm.*;
import javax.swing.*;

public class TestEvenement {

	private JButton unBouton;

	public void test() {
		JFrame f = new JFrame("event frame");
		f.setLocation(100, 300);
		f.setSize(100, 100);

		unBouton = new JButton("click ici");
		f.setLayout(new FlowLayout());

		// abonnement d'un listener :
		unBouton.addActionListener(new ActionListenerTest());

		f.add(unBouton);

		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new TestEvenement().test();
	}

}// TestEvenement
