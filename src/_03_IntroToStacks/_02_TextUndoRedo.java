package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	String text = "";
	Stack<Character> s = new Stack<Character>();
	_02_TextUndoRedo(){
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		frame.addKeyListener(this);
		frame.add(label);
		frame.pack();
	}
	
	public static void main(String[] args) {
		_02_TextUndoRedo test = new _02_TextUndoRedo();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()!=8&&e.getKeyCode()!=37&&e.getKeyCode()!=16) {
			text = text + e.getKeyChar();
			label.setText(text);
			System.out.println("works");
			frame.pack();
		}else if(e.getKeyCode()==8){
			char c = text.charAt(text.length()-1);
			text = text.substring(0,text.length()-1);
			label.setText(text);
			s.push(c);
			frame.pack();
			
		}else if(e.getKeyCode()==37){
			char c = s.pop();
			text = text + c;
			label.setText(text);
			frame.pack();
			
			
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
