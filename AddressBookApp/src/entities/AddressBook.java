package entities;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import addressbook.FlexibleComparator;
import addressbook.FlexibleComparator.sortBy;

public class AddressBook {
	private List<Person> personList;
	private FlexibleComparator comp = new FlexibleComparator();
	private FileSystemPerson fileSystem;
	
	public AddressBook() throws IOException{
		fileSystem = new FileSystemPerson();
		personList = fileSystem.readFile();
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(ArrayList<Person> personList) {
		this.personList = personList;
	}
	
	public void addPerson(Person person) throws IOException{
		personList.add(person);
		fileSystem.writeFile(person);
	}
	
	public void updatePerson(int index, String address, String country, String phone){
		personList.get(index).setAddress(address);
		personList.get(index).setAddress(country);
		personList.get(index).setAddress(phone);
	}
	
	public void deletePersonFromFile(Person person){
		try {
			fileSystem.deletePerson(person);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writePersonIntoFile(Person person){
		
	}
	
	public void removePerson(int index){
		personList.remove(index);
	}
	
	public int getNumberOfPersons(){
		return personList.size();
	}
	
	public void sortByCountry(){
		comp.setSortBy(sortBy.COUNTRY);
		Collections.sort(personList, comp);
	}
	
	public void sortByName(){
		comp.setSortBy(sortBy.NAME);
		Collections.sort(personList, comp);
	}
	
}



// interface 
// enum male/fi
