package no.addressbook;

import java.io.IOException;

import no.entities.AddressBook;
import no.gui.AddressBookGUI;

public class AddressBookApp {

	public static void main(String[] args) throws IOException {
				AddressBook addressBook = new AddressBook();
				AddressBookGUI window = new AddressBookGUI(addressBook);
		
		}
	}

