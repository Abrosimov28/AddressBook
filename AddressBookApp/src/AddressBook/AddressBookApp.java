package AddressBook;

import java.io.IOException;

import GUI.AddressBookGUI;
import Objects.AddressBook;

public class AddressBookApp {

	public static void main(String[] args) throws IOException {
				AddressBook addressBook = new AddressBook();
				AddressBookGUI window = new AddressBookGUI(addressBook);

		
		}
	}

