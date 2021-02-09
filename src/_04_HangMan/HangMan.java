package _04_HangMan;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel guess = new JLabel();
	JLabel guessed = new JLabel();
	String gLS = "Already guessed letters: ";
	Stack<Character> guessedLetters = new Stack<Character>();
	JLabel man = new JLabel();
	String guessing;
	String letters = "";
	int z = 0;
	boolean ended = false;
	Stack<String> words = new Stack<String>();
	String[] hangman = new String[7];
	public static void main(String[] args) {
		HangMan joe = new HangMan();
		joe.setup();
		int numWords = Integer.parseInt(JOptionPane.showInputDialog("How many words do you want to play Hangman with?"));
		joe.numToWordsInStack(numWords);
		joe.wordToPanel();
		while(!joe.ended) {
			String g = JOptionPane.showInputDialog("Guess a letter");
			joe.guessWord(g.charAt(0));
		}
	}
	
	void setup() {
		hangman[0] = "<html><pre class=\\\"tab\\\">______<br>|    |<br>|   <br>     <br>    </pre></html>";
		hangman[1] = "<html><pre class=\\\"tab\\\">______<br>|    |<br>|    0</pre></html>";
		hangman[2] = "<html><pre class=\\\"tab\\\">______<br>|    |<br>|    0<br>     |</pre></html>";
		hangman[3] = "<html><pre class=\\\"tab\\\">______<br>|    |<br>|    0<br>     |<br>      \\</pre></html>";
		hangman[4] = "<html><pre class=\\\"tab\\\">______<br>|    |<br>|    0<br>     |<br>    / \\</pre></html>";
		hangman[5] = "<html><pre class=\\\"tab\\\">______<br>|    |<br>|   \\0<br>     |<br>    / \\</pre></html>";
		hangman[6] = "<html><pre class=\\\"tab\\\">______<br>|    |<br>|   \\0/<br>     |<br>    / \\</pre></html>";
		frame.add(panel);
		panel.add(guess);
		panel.add(man);
		man.setText(hangman[z]);
		panel.add(guessed);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		frame.pack();
		
	}
	
	void numToWordsInStack(int n) {
		for(int i = 0; i<n; i++) {
			String s = Utilities.readRandomLineFromFile("dictionary.txt");
			if(words.contains(s)) {
				i--;
			}else {
				words.push(s);
			}
		}
		System.out.println(words.size());
	}
	
	void wordToPanel() {
		guessing = words.pop();
		for(int i = 0; i<guessing.length(); i++) {
			letters+="_";
		}
		guess.setText(letters + "  Number of letters: " + guessing.length());
		frame.pack();
	}
	
	void guessWord(char c) {
		if(guessing.contains(c+"")){
			guessedLetters.push(c);
			letters = "";
			for(int i = 0; i<guessing.length(); i++) {
				if(guessedLetters.contains(guessing.charAt(i))) {
					letters+=guessing.charAt(i);
				}else {
					letters+="_";
				}
				
			}
			guess.setText(letters + "  Number of letters: " + guessing.length());
			frame.pack();
		}else {
			z++;
			man.setText(hangman[z]);
			frame.pack();
			if(z==6) {
				ended = true;
				JOptionPane.showMessageDialog(null, "You lost :(");
			}
		}
		
		gLS += c + ", ";
		guessed.setText(gLS);
		frame.pack();
	}
	
	
}
