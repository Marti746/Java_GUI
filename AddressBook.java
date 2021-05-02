import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class AddressBook extends JFrame implements ActionListener {

	final int WIDTH = 600;
	final int HEIGHT = 550;
	int counter = 0;
	private JLabel label, labelAd, labelPh, labelEm;
	private JButton buttonSF, buttonAC;
	private JTextField name, fieldAd, fieldPh, fieldEm;
	JTextArea contactsTextArea = new JTextArea(20, 50);
	//private JScrollPane scrollPane;
	
	public AddressBook() {
		createComponents();
		setSize(WIDTH, HEIGHT);
	}
	
	private void createComponents() {
		// Add a Button
		buttonAC = new JButton("Add Contact");
		buttonSF = new JButton("Save to File");
		// Add an actionListener
		buttonAC.addActionListener(this);
		buttonSF.addActionListener(this);
		// Add a JLabel
		label = new JLabel("Name:    ");
		labelAd = new JLabel("Address:");
		labelPh = new JLabel("Phone:   ");
		labelEm = new JLabel("Email:    ");
		contactsTextArea.setEditable(false);
		//Add TextFields with the size of 50
		name = new JTextField(50);
		fieldAd = new JTextField(50);
		fieldPh = new JTextField(50);
		fieldEm = new JTextField(50);
		// Creates a Panel to add the button and label 
		JPanel panelContacts = new JPanel(new GridLayout(4,2));
		panelContacts.setBorder(new TitledBorder("Enter New Contact Information"));
		// adds the Name label and textfield
		panelContacts.add(label);
		panelContacts.add(name);
		// adds the Address label and textfield
		panelContacts.add(labelAd);
		panelContacts.add(fieldAd);
		// adds the Phone label and textfield
		panelContacts.add(labelPh);
		panelContacts.add(fieldPh);
		// adds the Email label and textfield
		panelContacts.add(labelEm);
		panelContacts.add(fieldEm);
		
		// Creates panel for the buttons using a flow layout
		JPanel panelButton = new JPanel(new FlowLayout());
		panelButton.setBorder(new TitledBorder("Add New Contact or Save to File"));
		// adds the buttons to the panel
		panelButton.add(buttonAC);
		panelButton.add(buttonSF);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("Saved Contacts"));
		panel.add(contactsTextArea);
		readContactsFromFile();
		
		// Add panel to the frame
		this.add(panelContacts, BorderLayout.NORTH);
		this.add(panelButton, BorderLayout.CENTER);
		this.add(panel, BorderLayout.SOUTH);
	}
	
	/**
	 * Main method that creates the Address Book Object
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new AddressBook();
		frame.setTitle("Address Book Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	/**
	 * Read in the current Contact that is within the file and prints to the textarea
	 * 
	 */
	public void readContactsFromFile() {
		File fileIn = new File("contacts.txt");
		Scanner in = null;
		try {
			in = new Scanner(fileIn);
			String contacts = "";
			while (in.hasNextLine()) {
				contacts = contacts + in.nextLine() + "\n";
			}
			contactsTextArea.setText(contacts);
		} 
		catch (Exception e) {
			System.out.println("Problem opening the file");
		}
//		finally {
//			in.close();
//		}
	}
	
	/**
	 * Reads from the TextArea to then put into the file 
	 */
	public void writeContactsToFile () {
		String str = contactsTextArea.getText();
		PrintWriter out = null;
		try {
			out = new PrintWriter("contacts.txt");
			out.println(str);
			//out.println(name.getText() + ", " + fieldAd.getText() + ", " + fieldPh.getText() + ", " + fieldEm.getText());
		} catch (FileNotFoundException e) {
			System.out.println("Can't print to the file");
		} finally {
			out.close();
		}
	}
	
	/**
	 * Override that activates whenever one of the two buttons are pressed
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("Add Contact")) {
			// Append information from the JTextFields to JTextArea object
			System.out.println(name.getText() + ", " + fieldAd.getText() + ", " + fieldPh.getText() + ", " + fieldEm.getText());
			contactsTextArea.append(name.getText() + ", " + fieldAd.getText() + ", " + fieldPh.getText() + ", " + fieldEm.getText() + "\n");
			// sets the TextFields back to nothing
			name.setText("");
			fieldAd.setText("");
			fieldPh.setText("");
			fieldEm.setText("");
		}
		else if(event.getActionCommand().equals("Save to File")) {
			// Write contacts from the JTextArea to the file “contacts.txt”
			writeContactsToFile();
		}
	}

}
