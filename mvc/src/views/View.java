package views;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;

public class View {
	
	private JFrame frame;
	private JLabel personIdLabel;
	private JComboBox<Integer> personId;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JButton firstNameSaveButton;
	private JButton lastNameSaveButton;
	private JButton hello;
	private JButton bye;
	
	public View(String title) {
		try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
		catch (Exception e) {}
		
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 163);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		// Create UI elements
		personIdLabel = new JLabel("Person ID: ");
		personIdLabel.setBounds(10, 11, 57, 14);
		personId = new JComboBox<Integer>();
		personId.setBounds(71, 8, 57, 20);
		
		firstNameLabel = new JLabel("First name: ");
		firstNameLabel.setBounds(10, 65, 57, 14);
		lastNameLabel = new JLabel("Last name: ");
		lastNameLabel.setBounds(10, 94, 56, 14);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(71, 62, 225, 20);
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(71, 91, 225, 20);
		
		firstNameSaveButton = new JButton("Save first name");
		firstNameSaveButton.setBounds(302, 61, 107, 23);
		lastNameSaveButton = new JButton("Save last name");
		lastNameSaveButton.setBounds(302, 90, 107, 23);
		
		hello = new JButton("Hello!");
		hello.setBounds(415, 61, 59, 23);
		bye = new JButton("Bye!");
		bye.setBounds(415, 90, 59, 23);
		
		// Add components
		frame.getContentPane().add(personIdLabel);
		frame.getContentPane().add(personId);
		frame.getContentPane().add(firstNameLabel);
		frame.getContentPane().add(lastNameLabel);
		frame.getContentPane().add(firstNameTextField);
		frame.getContentPane().add(lastNameTextField);
		frame.getContentPane().add(firstNameSaveButton);
		frame.getContentPane().add(lastNameSaveButton);
		frame.getContentPane().add(hello);
		frame.getContentPane().add(bye);
		
		frame.setVisible(true);
	}
	
	public JComboBox<Integer> getPersonId() {
		return personId;
	}

	public JTextField getFirstNameTextField() {
		return firstNameTextField;
	}

	public JTextField getLastNameTextField() {
		return lastNameTextField;
	}

	public JButton getFirstNameSaveButton() {
		return firstNameSaveButton;
	}

	public JButton getLastNameSaveButton() {
		return lastNameSaveButton;
	}

	public JButton getHello() {
		return hello;
	}

	public JButton getBye() {
		return bye;
	}
}
