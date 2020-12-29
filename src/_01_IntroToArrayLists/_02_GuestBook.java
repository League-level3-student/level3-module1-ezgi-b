package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	
	ArrayList<String> guests = new ArrayList<String>();
	JButton buttonAdd;
	JButton buttonView;
	public static void main(String[] args) {
		_02_GuestBook book = new _02_GuestBook();
		book.setup();
	}
	
	void setup() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		buttonAdd = new JButton("Add Name");
		buttonView = new JButton("View Names");
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		
		buttonAdd.addActionListener(this);
		buttonView.addActionListener(this);
		
		panel.add(buttonAdd);
		panel.add(buttonView);
		frame.add(panel);
		frame.pack();
	}
	
	void addName(String gn){
		guests.add(gn);
	}
	
	void viewNames() {
		String l = "";
		for(int i = 0; i < guests.size(); i++) {
			l = l + guests.get(i) + "\n";
		}
		JOptionPane.showMessageDialog(null, l);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(buttonAdd)) {
			addName(JOptionPane.showInputDialog("Type in a name."));
		}
		if(e.getSource().equals(buttonView)) {
			viewNames();
		}
		
	}
	
	
}
