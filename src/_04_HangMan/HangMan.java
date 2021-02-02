package _04_HangMan;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HangMan{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel guess = new JLabel();
	JLabel man = new JLabel();
	public static void main(String[] args) {
		HangMan joe = new HangMan();
		joe.setup();
		}
	
	void setup() {
		frame.add(panel);
		panel.add(guess);
		panel.add(man);
		man.setText("<html><pre class=\\\"tab\\\">______<br>|    |<br>|   \\0/<br>     |<br>    / \\</pre></html>");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		frame.pack();
	}
	
	
}
