package addressbook;

import java.io.IOException;

import gui.AddressBookGUI;
import entities.AddressBook;

public class AddressBookApp {

	public static void main(String[] args) throws IOException {
				AddressBook addressBook = new AddressBook();
				AddressBookGUI window = new AddressBookGUI(addressBook);
		
		}
	}

