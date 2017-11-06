import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;

public class MenuFrame extends JFrame implements ActionListener{
	
	private JMenuItem createItem, saveItem, displayItem, addItem, editItem, removeItem;
	private AddressBook addressBook;
	private JTextArea textArea;
	private JList<String> buddyList;
	private String selectedBuddy;
	private DefaultListModel<String> buddyListModel;
	
	public MenuFrame() {
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		//Initializes Address Book menu
		JMenu addressMenu = new JMenu("Address Book");
		menuBar.add(addressMenu);
		
		//Initializes BuddyInfo menu
		JMenu buddyMenu = new JMenu("BuddyInfo");
		menuBar.add(buddyMenu);
		
		//Menu items 
		//Create button for Address Book menu
		createItem = new JMenuItem("Create");
		createItem.addActionListener(this);
		addressMenu.add(createItem);
		
		//Save button for Address Book menu
		saveItem = new JMenuItem("Save");
		saveItem.addActionListener(this);
		addressMenu.add(saveItem);
		saveItem.setEnabled(false);
		
		//Display button for Address Book menu
		displayItem = new JMenuItem("Display");
		displayItem.addActionListener(this);
		addressMenu.add(displayItem);
		displayItem.setEnabled(false);
		
		//Add button for BuddyInfo menu
		addItem = new JMenuItem("Add");
		addItem.addActionListener(this);
		buddyMenu.add(addItem);
		addItem.setEnabled(false);
		
		//Edit button for BuddyInfo menu
		editItem = new JMenuItem("Edit");
		editItem.addActionListener(this);
		buddyMenu.add(editItem);
		editItem.setEnabled(false);
		
		//Remove button for BuddyInfo menu
		removeItem = new JMenuItem("Remove");
		removeItem.addActionListener(this);
		buddyMenu.add(removeItem);
		removeItem.setEnabled(false);
		
		//Text are to display BuddyInfo
		textArea = new JTextArea();
		this.add(textArea);
		
		
		buddyListModel = new DefaultListModel<>();	//ListModel for BuddyInfo
		buddyList = new JList<>(buddyListModel);	//List using ListModel for BuddyInfo
		buddyList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					selectedBuddy = buddyList.getSelectedValue();
					if (selectedBuddy == null) {
						editItem.setEnabled(false);
						removeItem.setEnabled(false);
					} else {
						editItem.setEnabled(true);
						removeItem.setEnabled(true);
					}
				}
			}
		});
		
		this.add(new JScrollPane(buddyList));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("SYSC 3110: Lab 4");
		this.setSize(400,300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
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
				final String name = JOptionPane.showInputDialog("Name");
				addressBook.addBuddy(new BuddyInfo (name, JOptionPane.showInputDialog("Home Address"), JOptionPane.showInputDialog("Phone Number")));
				buddyListModel.addElement(name);
				break;
			case "Edit":
				buddyListModel.addElement(addressBook.editBuddy(selectedBuddy));
				buddyListModel.removeElement(selectedBuddy);
			case "Remove":
				textArea.setText(null);
				buddyListModel.removeElement(selectedBuddy);
				addressBook.removeBuddy(selectedBuddy);
		}
	}	
}
