import javax.swing.*;
import java.awt.event.*;

public class MenuFrame extends JFrame implements ActionListener {
	
	private JMenuItem createItem, saveItem, displayItem, addItem;
	private AddressBook addressBook;
	private JTextArea textArea;
	
	public MenuFrame() {
		JFrame f = new JFrame("SYSC 3110: Lab 4");
		f.setSize(400,300);
		
		JMenuBar menuBar = new JMenuBar();
		f.setJMenuBar(menuBar);
		
		JMenu addressMenu = new JMenu("Address Book");
		menuBar.add(addressMenu);
		
		JMenu buddyMenu = new JMenu("BuddyInfo");
		menuBar.add(buddyMenu);
		
		createItem = new JMenuItem("Create");
		createItem.addActionListener(this);
		addressMenu.add(createItem);
		
		saveItem = new JMenuItem("Save");
		saveItem.addActionListener(this);
		addressMenu.add(saveItem);
		saveItem.setEnabled(false);
		
		displayItem = new JMenuItem("Display");
		displayItem.addActionListener(this);
		addressMenu.add(displayItem);
		displayItem.setEnabled(false);
		
		addItem = new JMenuItem("Add");
		addItem.addActionListener(this);
		buddyMenu.add(addItem);
		addItem.setEnabled(false);
		
		textArea = new JTextArea();
		f.add(textArea);
		
		f.setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "Create":
				textArea.setText(null);
				saveItem.setEnabled(true);
				addItem.setEnabled(true);
				addressBook = new AddressBook();
				break;
			case "Save":
				textArea.setText(null);
				addressBook.saveAddressBook();
				break;
			case "Display":
				textArea.setText(addressBook.toString());
				break;
			case "Add":
				textArea.setText(null);
				displayItem.setEnabled(true);
				BuddyInfo buddy = new BuddyInfo (JOptionPane.showInputDialog("Name"), JOptionPane.showInputDialog("Home Address"), JOptionPane.showInputDialog("Phone Number"));
				addressBook.addBuddy(buddy);
				break;
		}
	}	

}
