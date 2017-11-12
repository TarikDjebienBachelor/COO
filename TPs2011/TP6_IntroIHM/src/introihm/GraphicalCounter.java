package introihm;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GraphicalCounter {

    protected Counter counter;
    private JButton init;
    private JButton increment;
    private JTextField saisie;
    private JLabel affichage;
    private JFrame frame;
    
    public GraphicalCounter(Counter counter){
        JPanel zoneSaisie    = new JPanel();
        zoneSaisie.setLayout(new FlowLayout());
	JPanel zoneAffichage = new JPanel();
        zoneAffichage.setLayout(new FlowLayout());
	JPanel zoneBouton    = new JPanel();
        zoneBouton.setLayout(new BorderLayout());
	this.saisie = new JTextField();
        zoneSaisie.add(this.saisie);
	this.affichage = new JLabel("Depart");
	zoneAffichage.add(this.affichage);

	this.init = new JButton("init");
	zoneBouton.add(this.init,BorderLayout.WEST);
	this.increment = new JButton("increment");
	zoneBouton.add(this.increment,BorderLayout.EAST);

	this.counter = counter;
        this.frame = new JFrame("compteur");
        this.frame.setLocation(100,300);
	this.frame.setSize(300,300);
	this.frame.addWindowListener(new FermetureEvent());

	// abonnement d'un listener au Bouton Init
	this.init.addActionListener(new InitActionListenerTest());       
	// abonnement d'un listener au Bouton Increment
	this.increment.addActionListener(new IncrementActionListenerTest()); 

        this.frame.setLayout(new BorderLayout());
	this.frame.add(zoneSaisie,BorderLayout.NORTH);
	this.frame.add(zoneAffichage,BorderLayout.CENTER);
	this.frame.add(zoneBouton,BorderLayout.SOUTH);

	this.frame.pack();
	this.frame.setVisible(true);
    }

    public static void main(String[] args){
	Counter c1 = new SimpleCounter();
	GraphicalCounter g1 = new GraphicalCounter(c1);
    }

	//
	// CLASSES INTERNES POUR LES EVENEMENTS
	//
	private class InitActionListenerTest implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		    GraphicalCounter.this.counter.init(Integer.parseInt(GraphicalCounter.this.saisie.getText()));
		}
	}// 

	private class IncrementActionListenerTest implements ActionListener {
		public void actionPerformed(ActionEvent e) {
                    GraphicalCounter.this.counter.increment();
		    String res = new String();
		    res = res.valueOf(GraphicalCounter.this.counter.getCurrentValue());
		    GraphicalCounter.this.affichage.setText(res);
		}
	}// 

    private class UnTexteActionListenerTest implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    GraphicalCounter.this.affichage.setText(saisie.getText());
	}
    }// 
    
    private class FermetureEvent extends WindowAdapter {
	public void windowClosing(java.awt.event.WindowEvent e) {
	    System.exit(0);
	}
    }
    
}
