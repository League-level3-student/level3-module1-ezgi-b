package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	private HashMap<Integer, String> entries = new HashMap<Integer, String>();
	private JFrame frame = new JFrame("Users");
	private JPanel panel = new JPanel();
	private JButton addEntry = new JButton("Add Entry");
	private JButton searchByID = new JButton("Search by ID");
	private JButton viewList = new JButton("View List");
	private JButton removeEntry = new JButton("Remove Entry");
	public static void main(String[] args) {
		_02_LogSearch x = new _02_LogSearch();
	}
	public _02_LogSearch() {
		addEntry.addActionListener(this);
		searchByID.addActionListener(this);
		viewList.addActionListener(this);
		removeEntry.addActionListener(this);
		frame.add(panel);
		panel.add(addEntry);
		panel.add(searchByID);
		panel.add(viewList);
		panel.add(removeEntry);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(addEntry)) {
			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID number:"));
			String name = JOptionPane.showInputDialog("Enter a name:");
			entries.put(id, name);
		}
		
		if(e.getSource().equals(searchByID)) {
			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID number of the person you are looking for:"));
			String name = "";
			if(entries.containsKey(id)) {
			for(Integer i: entries.keySet()) {
				if(id==i) { 
					name = entries.get(id);
				}
			}
				JOptionPane.showMessageDialog(null, "Name: " + name);
			}else {
				JOptionPane.showMessageDialog(null, "There is no person with this ID number in the database!");
			}
		}
		
		if(e.getSource().equals(viewList)) {
			String output = "";
			for(Integer i: entries.keySet()) {
				output += "ID: " + i + "; Name: " + entries.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, output);
		}
		if(e.getSource().equals(removeEntry)) {
			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID number of the person you want to remove:"));
			int remove = 0;
			if(entries.containsKey(id)) {
				for(Integer i: entries.keySet()) {
					if(id==i) { 
						remove = i;
					}
				}
				entries.remove(remove);
				JOptionPane.showMessageDialog(null, "The person with that ID number has been removed.");
			}else {
				JOptionPane.showMessageDialog(null, "There is no person with this ID number in the database!");
			}
		}
	}
}
	

