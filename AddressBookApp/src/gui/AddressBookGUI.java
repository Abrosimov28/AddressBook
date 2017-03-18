package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import entities.AddressBook;

public class AddressBookGUI {

	private JFrame frame;
	private DefaultTableModel model;

	private AddPersonScreen frameAdd;
	private AddressBook addressBook;
	private JTable table;
	private String[] column_names = { "First name", "Last name", "Address", "Country",  "Phone" };




	public AddressBookGUI(AddressBook addressBook) {
		this.addressBook = addressBook;
		initialize();
	}

	public String getColumnName(int index) {
		return column_names[index];
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initPanel() {
		JPanel panel = new JPanel();
		panel.setBounds(236, 11, 420, 414);
		getFrame().getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 420, 414);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
	}

	private void initTable() {
		model = new DefaultTableModel(column_names, 0);
		model.setColumnCount(5);
		table = new JTable(model);
	}
	
	private void initButtonAddPerson(){
		JButton btnAddPerson = new JButton("Add person");
		btnAddPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameAdd = new AddPersonScreen(addressBook);
				getFrame().setVisible(false);
				frameAdd.setVisible(true);
			}
		});
		btnAddPerson.setBounds(10, 11, 124, 23);
		getFrame().getContentPane().add(btnAddPerson);
	}
	
	private void initButtonLoadData(){
		JButton btnLoadData = new JButton("Load data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadData();

			}
		});
		btnLoadData.setBounds(10, 204, 124, 23);
		getFrame().getContentPane().add(btnLoadData);
	}
	
	private void initButtonSortByCountries(){
		JButton btnSortByCountries = new JButton("Sort by countries");
		btnSortByCountries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addressBook.sortByCountry();
				loadData();
			}
		});
		btnSortByCountries.setBounds(10, 252, 124, 23);
		getFrame().getContentPane().add(btnSortByCountries);
	}

	private void initButtonSortByNames(){
		JButton btnSortByNames = new JButton("Sort by names");
		btnSortByNames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addressBook.sortByName();
				loadData();
			}
		});
		btnSortByNames.setBounds(10, 286, 124, 23);
		getFrame().getContentPane().add(btnSortByNames);
	}
	
	private void initButtonDeletePerson(){
		JButton btnDeletePerson = new JButton("Delete person");
		btnDeletePerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() >= 0) {
					addressBook.deletePersonFromFile(addressBook.getPersonList().get(table.getSelectedRow()));
					deleteData(table.getSelectedRow());
					addressBook.removePerson(table.getSelectedRow());
					loadData();

				}

			}
		});
		btnDeletePerson.setBounds(10, 56, 124, 23);
		frame.getContentPane().add(btnDeletePerson);
	}
	
	private void initialize() {
		frame = new JFrame("Address book");
		getFrame().setBounds(100, 100, 751, 514);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		getFrame().setVisible(true);
		initButtonAddPerson();
		initButtonLoadData();
		initButtonSortByCountries();
		initButtonSortByNames();
		initButtonDeletePerson();

		initTable();
		initPanel();

	}

	public JFrame getFrame() {
		return frame;
	}

	public void loadData() {
		for (int i = 0; i < addressBook.getPersonList().size(); i++) {
			model.setRowCount(addressBook.getPersonList().size());
			table.getModel().setValueAt(addressBook.getPersonList().get(i).getFirstName(), i, 0);
			table.getModel().setValueAt(addressBook.getPersonList().get(i).getLastName(), i, 1);
			table.getModel().setValueAt(addressBook.getPersonList().get(i).getAddress(), i, 2);
			table.getModel().setValueAt(addressBook.getPersonList().get(i).getCountry(), i, 3);
			table.getModel().setValueAt(addressBook.getPersonList().get(i).getPhone(), i, 4);

		}
	}

	public void deleteData(int index) {
		table.getModel().setValueAt(null, index, 0);
		table.getModel().setValueAt(null, index, 1);
		table.getModel().setValueAt(null, index, 2);
		table.getModel().setValueAt(null, index, 3);
		table.getModel().setValueAt(null, index, 4);
	}
}
