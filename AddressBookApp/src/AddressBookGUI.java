import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

public class AddressBookGUI {

	private JFrame frame;

	private addPerson frameAdd;
	private AddressBook addressBook;
	private FileSystem fs;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressBookGUI window = new AddressBookGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddressBookGUI() {
		// addressBook = new AddressBook();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Address book");
		frame.setBounds(100, 100, 751, 514);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JPanel panel = new JPanel();
		panel.setBounds(236, 11, 420, 414);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 420, 414);
		panel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, },
				new String[] { "First Name", "Last Name", "Address", "Country", "Phone" }));
		scrollPane.setViewportView(table);

		JButton btnAddPerson = new JButton("Add person");
		btnAddPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameAdd = new addPerson();
				frame.setVisible(false);
				frameAdd.setVisible(true);
			}
		});
		btnAddPerson.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnAddPerson);

		JButton btnLoadData = new JButton("Load data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fs = new FileSystem();
				try {
					addressBook = fs.readFile();
					for (int i = 0; i < addressBook.getPersonList().size(); i++) {

						table.getModel().setValueAt(addressBook.getPersonList().get(i).getFirstName(), i, 0);
						table.getModel().setValueAt(addressBook.getPersonList().get(i).getLastName(), i, 1);
						table.getModel().setValueAt(addressBook.getPersonList().get(i).getAddress(), i, 2);
						table.getModel().setValueAt(addressBook.getPersonList().get(i).getCountry(), i, 3);
						table.getModel().setValueAt(addressBook.getPersonList().get(i).getPhone(), i, 4);

					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLoadData.setBounds(10, 204, 124, 23);
		frame.getContentPane().add(btnLoadData);

		JButton btnSortByCountries = new JButton("Sort by countries");
		btnSortByCountries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addressBook.sortByCountry();
				for (int i = 0; i < addressBook.getPersonList().size(); i++) {

					table.getModel().setValueAt(addressBook.getPersonList().get(i).getFirstName(), i, 0);
					table.getModel().setValueAt(addressBook.getPersonList().get(i).getLastName(), i, 1);
					table.getModel().setValueAt(addressBook.getPersonList().get(i).getAddress(), i, 2);
					table.getModel().setValueAt(addressBook.getPersonList().get(i).getCountry(), i, 3);
					table.getModel().setValueAt(addressBook.getPersonList().get(i).getPhone(), i, 4);

				}
			}
		});
		btnSortByCountries.setBounds(10, 252, 124, 23);
		frame.getContentPane().add(btnSortByCountries);
		
		JButton btnNewButton = new JButton("Sort by names");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addressBook.sortByName();
				for (int i = 0; i < addressBook.getPersonList().size(); i++) {

					table.getModel().setValueAt(addressBook.getPersonList().get(i).getFirstName(), i, 0);
					table.getModel().setValueAt(addressBook.getPersonList().get(i).getLastName(), i, 1);
					table.getModel().setValueAt(addressBook.getPersonList().get(i).getAddress(), i, 2);
					table.getModel().setValueAt(addressBook.getPersonList().get(i).getCountry(), i, 3);
					table.getModel().setValueAt(addressBook.getPersonList().get(i).getPhone(), i, 4);

				}
			}
		});
		btnNewButton.setBounds(10, 286, 124, 23);
		frame.getContentPane().add(btnNewButton);

		//

	}
}
