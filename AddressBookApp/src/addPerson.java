import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class addPerson extends JFrame {

	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField address;
	private JTextField country;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	private AddressBook addressBook;
	
	addPerson (AddressBook addressBook){
		this.addressBook = addressBook;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addPerson frame = new addPerson();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public addPerson() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		firstName = new JTextField();
		firstName.setBounds(113, 11, 213, 20);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setBounds(113, 42, 213, 20);
		contentPane.add(lastName);
		lastName.setColumns(10);
		
		address = new JTextField();
		address.setBounds(113, 73, 213, 20);
		contentPane.add(address);
		address.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(10, 14, 79, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(10, 45, 79, 14);
		contentPane.add(lblLastName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 76, 79, 14);
		contentPane.add(lblAddress);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(10, 109, 79, 14);
		contentPane.add(lblCountry);
		
		country = new JTextField();
		country.setColumns(10);
		country.setBounds(113, 106, 213, 20);
		contentPane.add(country);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(113, 137, 213, 20);
		contentPane.add(phone);
		
		JLabel label = new JLabel("Phone");
		label.setBounds(10, 140, 79, 14);
		contentPane.add(label);
		
		JButton btnAddPerson = new JButton("Add person");
		btnAddPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				addressBook.addPerson(firstName.getText(), lastName.getText(),address.getText(),country.getText(),phone.getText());
			}
		});
		btnAddPerson.setBounds(306, 208, 89, 23);
		contentPane.add(btnAddPerson);
	}
}
