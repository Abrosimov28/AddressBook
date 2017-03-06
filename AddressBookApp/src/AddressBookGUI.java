import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class AddressBookGUI {

	private JFrame frame;
	private DefaultTableModel model;

	private AddPerson frameAdd;
	private AddressBook addressBook;
	private FileSystem fs;
	private JTable table;
	private String[] column_names = {"First name","Last name","Country","Address","Phone"};

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressBookGUI window = new AddressBookGUI();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public AddressBookGUI() throws IOException {
		fs = new FileSystem();
		addressBook = fs.readFile();
		initialize();
	}

	public AddressBookGUI(AddressBook addressBook) throws IOException {
		addressBook = new AddressBook();
		fs = new FileSystem();
		
		initialize();
	}
	
	public String getColumnName(int index){
		return column_names[index];
	}
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		addressBook = fs.readFile(); 
		frame = new JFrame("Address book");
		getFrame().setBounds(100, 100, 751, 514);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		getFrame().setVisible(true);

		JPanel panel = new JPanel();
		panel.setBounds(236, 11, 420, 414);
		getFrame().getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 420, 414);
		panel.add(scrollPane);

		// table = new JTable();
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"First Name", "Last Name", "Address", "Country", "Phone"
//			}
//		));
		 model = new DefaultTableModel (column_names,0) {
		};
		//	DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setColumnCount(5);
	//	model.setRowCount(5);
		table = new JTable(model);
//		for (int i = 0; i<5 ; i++)
//			model.col

		
		scrollPane.setViewportView(table);

		JButton btnAddPerson = new JButton("Add person");
		btnAddPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameAdd = new AddPerson(addressBook);
				getFrame().setVisible(false);
				frameAdd.setVisible(true);
			}
		});
		btnAddPerson.setBounds(10, 11, 124, 23);
		getFrame().getContentPane().add(btnAddPerson);

		JButton btnLoadData = new JButton("Load data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadData();
				
			}
		});
		btnLoadData.setBounds(10, 204, 124, 23);
		getFrame().getContentPane().add(btnLoadData);

		JButton btnSortByCountries = new JButton("Sort by countries");
		btnSortByCountries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addressBook.sortByCountry();
				loadData();
			}
		});
		btnSortByCountries.setBounds(10, 252, 124, 23);
		getFrame().getContentPane().add(btnSortByCountries);
		
		JButton btnSortByNames = new JButton("Sort by names");
		btnSortByNames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addressBook.sortByName();
				loadData();
			}
		});
		btnSortByNames.setBounds(10, 286, 124, 23);
		getFrame().getContentPane().add(btnSortByNames);
		
		JButton btnDeletePerson = new JButton("Delete person");
		btnDeletePerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow()>=0){
						deleteData(table.getSelectedRow());
						addressBook.removePerson(table.getSelectedRow());
				}
				
				
			}
		});
		btnDeletePerson.setBounds(10, 56, 124, 23);
		frame.getContentPane().add(btnDeletePerson);

		//

	}

	public JFrame getFrame() {
		return frame;
	}
	
	public void loadData(){
		for (int i = 0; i < addressBook.getPersonList().size(); i++) {
			model.setRowCount(addressBook.getPersonList().size());
			table.getModel().setValueAt(addressBook.getPersonList().get(i).getFirstName(), i, 0);
			table.getModel().setValueAt(addressBook.getPersonList().get(i).getLastName(), i, 1);
			table.getModel().setValueAt(addressBook.getPersonList().get(i).getAddress(), i, 2);
			table.getModel().setValueAt(addressBook.getPersonList().get(i).getCountry(), i, 3);
			table.getModel().setValueAt(addressBook.getPersonList().get(i).getPhone(), i, 4);

		}
	}
	
	public void deleteData(int index){
		table.getModel().setValueAt(null, index, 0);
		table.getModel().setValueAt(null, index, 1);
		table.getModel().setValueAt(null, index, 2);
		table.getModel().setValueAt(null, index, 3);
		table.getModel().setValueAt(null, index, 4);
	}
}
