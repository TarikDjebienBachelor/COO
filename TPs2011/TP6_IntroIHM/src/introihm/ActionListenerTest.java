package introihm;

/**
 * ActionListenerTest.java
 *
 * @author <a href="mailto:jean-christophe.routier@lifl.fr"> Jean-Christophe Routier</a>
 * @version
 */
import javax.swing.*;
import java.awt.event.*;

public class ActionListenerTest implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		
		// on peut recuperer le composant qui a emis l'evenement par getSource 
		// sur l'objet evenement passe en parametre de la methode
	    if (((JButton) e.getSource()).getText().equals("clik ici")){
		((JButton) e.getSource()).setText("clicked");
	    }
	    else
		((JButton) e.getSource()).setText("clik ici");
	}
}// ActionListenerTest
