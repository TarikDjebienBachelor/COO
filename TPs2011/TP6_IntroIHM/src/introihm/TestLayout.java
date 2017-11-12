package introihm;

import java.awt.*;
import javax.swing.*;

public class TestLayout {

	public void testFlowLayout() {
		JFrame f = new JFrame("layout frame");
		f.setLocation(100, 400);

		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());

		panel1.add(new JButton("b1"), BorderLayout.NORTH);
		panel1.add(new JButton("b2"), BorderLayout.EAST);
		panel1.add(new JButton("b3"), BorderLayout.WEST);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());

		panel2.add(new JButton("b4"));
		panel2.add(new JButton("b5"));
		panel2.add(new JButton("b6"));

		f.add(panel1, BorderLayout.NORTH);
		f.add(panel2, BorderLayout.SOUTH);

		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new TestLayout().testFlowLayout();
	}

}
